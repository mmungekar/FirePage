package controller;

import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;

import customcalendar.CalendarAdapter;
import model.User.Dorm;
import model.User.RA;
import view.CalendarView;

/**
 * Created by Bill Xiong on 3/15/17.
 * Controller for RA- this is a parallel inheritance with User class,
 * dont care enough to fix it
 */

public class RAController extends UserController {

    public RAController(String username, CalendarView cv) {
        super(cv);
        this.setUser(new RA().setUsername(username));
    }

    public Dorm getDorm() {
        RA user = (RA) this.getUser();
        return user.getDorm();
    }

    public void addSingleEventListener(String ref, ValueEventListener e) {
        this.getUser().addSingleEvent(ref, e);
    }

    //TODO this should be in authentication?
    public void setRAInfo(DataSnapshot dataSnapshot) {
        this.setUser(this.getUser().read(RA.class, dataSnapshot, this.getUser().getUsername()));
        this.getDormController().setDormName(this.getDorm());
    }

    public void initRAs(DataSnapshot dataSnapshot) {
        for(DataSnapshot data : dataSnapshot.getChildren()) {
            RA c = (RA) this.getUser().read(RA.class, data);
            RA user = (RA) this.getUser();
            if(c.getDorm().equals(user.getDorm())) {
                this.getCalendarView().putRAColor(c.getUsername());
            }
        }
        this.getCalendarView().initRAAdapter();
    }

    public void addGridHandler(DataSnapshot dormSnap) {
        this.getCalendarView().getGridview().setOnItemClickListener(new Listener(dormSnap));
    }

    private class Listener implements OnItemClickListener {
        private DataSnapshot dormSnap;

        private Listener(DataSnapshot dormSnap) {
            this.dormSnap = dormSnap;
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            ((CalendarAdapter) parent.getAdapter()).setSelected(v, position);
            String selectedGridDate = CalendarAdapter.day_string
                    .get(position);

            String[] separatedTime = selectedGridDate.split("-");
            String gridvalueString = separatedTime[2].replaceFirst("^0*", "");
            int gridvalue = Integer.parseInt(gridvalueString);

            //wot
            if ((gridvalue > 10) && (position < 8)) {
                getCalendarView().setPreviousMonth();
            }
            else if ((gridvalue < 7) && (position > 28)) {
                getCalendarView().setNextMonth();
            }

            //TODO MOVE metjod OUTSIDE- for some reason the gridview has null views before event handler triggers
            populateCalendar(this.dormSnap);

            ((CalendarAdapter) parent.getAdapter()).setSelected(v, position);
            //this should be in GR, RC controllers, not RA controllers, since RAs cant modify calendar
//                if (RA != null) {
//                    v.setBackgroundColor(RAColors.get(RA));
//                    dormController.insertCallDate(selectedGridDate, new RA().setUsername(RA));
//                }
        }
    }

}
