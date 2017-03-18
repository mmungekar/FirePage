package view;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.billxiong24.firepageandroid.R;
import com.example.billxiong24.firepageandroid.RAListAdapter;

import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Utilities.Colors;
import customcalendar.CalendarAdapter;
import customcalendar.CalendarCollection;

/**
 * Created by Bill Xiong on 3/18/17.
 *
 * manages view operations for calendar
 */

public class CalendarView {

    private GregorianCalendar cal_month;
    private CalendarAdapter cal_adapter;
    private RAListAdapter ra_adapter;
    private TextView tv_month;
    private Colors colorMaker = new Colors();
    private HashMap<String, Integer> RAColors = new HashMap<>();
    private String currRA;
    private ImageButton previous;
    private ImageButton next;
    private GridView gridview, raGrid;
    private Context context;


    public CalendarView(Context context, View rootView) {
        this.context = context;
        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
        cal_adapter = new CalendarAdapter(context, cal_month, CalendarCollection.date_collection_arr);
        ra_adapter = null;
        tv_month = (TextView) rootView.findViewById(R.id.tv_month);
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
        this.initPrevNext(rootView);
        gridview = (GridView) rootView.findViewById(R.id.gv_calendar);
        raGrid = (GridView) rootView.findViewById(R.id.ra_list);
        gridview.setAdapter(cal_adapter);
        raGrid.setAdapter(ra_adapter);
        this.addRaGridHandler();
    }

    public Context getContext() {
        return this.context;
    }
    public Map<String, Integer> getRAColors() {
        return Collections.unmodifiableMap(this.RAColors);
    }


    public GridView getGridview() {
        return this.gridview;
    }

    public GridView getRaGrid() {
        return this.raGrid;
    }

    public CalendarAdapter getCalAdapter() {
        return this.cal_adapter;
    }
    public String getCurrRA() {
        return this.currRA;
    }

    public void setNextMonth() {
        this.nextMonth();
        this.refreshCalendar();
    }

    public void setPreviousMonth() {
        this.previousMonth();
        this.refreshCalendar();
    }

    public void putRAColor(String username) {
        this.RAColors.put(username, colorMaker.getColor());
    }

    public void initRAAdapter() {
        ra_adapter = new RAListAdapter(this.context, this.RAColors);
        raGrid.setAdapter(ra_adapter);
    }


    private void initPrevNext(View rootView) {
        this.previous = (ImageButton) rootView.findViewById(R.id.ib_prev);
        this.addPreviousHandler();
        this.next = (ImageButton) rootView.findViewById(R.id.Ib_next);
        this.addNextHandler();

    }

    private void addNextHandler() {
        this.next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextMonth();
            }
        });
    }

    private void addPreviousHandler() {
        this.previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreviousMonth();
            }
        });
    }

    private void addRaGridHandler() {
        raGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                ((RAListAdapter) parent.getAdapter()).setSelected(v, position);
                currRA = ((TextView) v.findViewById(R.id.name)).getText().toString();
            }
        });
    }

    private void nextMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMaximum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1),
                    cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) + 1);
        }
    }

    private void previousMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month
                .getActualMinimum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1),
                    cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) - 1);
        }

    }

    private void refreshCalendar() {
        cal_adapter.refreshDays();
        cal_adapter.notifyDataSetChanged();
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
    }
}
