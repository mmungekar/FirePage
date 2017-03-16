package controller;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Dorm.DormObj;
import model.User.Dorm;
import model.User.RA;
import model.User.User;

/**
 * Created by Bill Xiong on 3/15/17.
 * Controller for RA- this is a parallel inheritance with User class,
 * dont care enough to fix it
 */

public class RAController extends UserController {

    private RA ra;
    private DormObj dormObj;
    private Set<RA> set = new HashSet<>();
    public RAController(String username) {
        this.ra = (RA) new RA().setUsername(username);
        this.dormObj = new DormObj();
        //this.getRAData(username);
    }

    //TODO remove these getters im too lazy right now
    public RA getRA() {
        return this.ra;
    }

    public DormObj getDormObj() {
        return this.dormObj;
    }

    /**
     * gets all ra objects that are in this.ra's dorm
     * @return a set of RA's in this.ra's dorm
     */
    public Set<RA> getRAsInDorm() {
        final Set<RA> set = new HashSet<>();
        final Dorm dorm = this.ra.getDorm();
        User ra = new RA();

        //TODO fix this garbage, should not be in controller
        ra.addSingleEvent("RA", new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot d : dataSnapshot.getChildren()) {
                    RA used = new RA();
                    used = (RA) used.read(RA.class, d);
                    if(used.getDorms().contains(dorm)) {
                        set.add(used);
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });

        return set;
    }

    public RA getRAData(String username) {
        this.ra.addSingleEvent("RA", new CustomValueEventListener());
        return this.ra;
    }

    public void setRAInfo(DataSnapshot dataSnapshot) {
        this.ra = (RA) this.ra.read(RA.class, dataSnapshot, this.ra.getUsername());
    }

    public List<String> getRAInDorm(DataSnapshot dataSnapshot) {
        List<String> usernames = new ArrayList<>();
        for(DataSnapshot data : dataSnapshot.getChildren()) {
            RA c = (RA) this.ra.read(RA.class, data);
            if(c.getDorm().equals(this.ra.getDorm())) {
                usernames.add(c.getUsername());
            }
        }
        return usernames;
    }

    public Set<RA> getSet() {
        return this.set;
    }

    private void setRA(RA ra) {
        this.ra = ra;
    }

    private class CustomValueEventListener implements com.google.firebase.database.ValueEventListener{
        public void onDataChange(DataSnapshot dataSnapshot) {
            RA temp = (RA) new RA().read(RA.class, dataSnapshot, getRA().getUsername());
            System.out.println("PRINTING temp INFO -----" + temp.getName());
            System.out.println(temp.getUsername());
            System.out.println(temp.getDorms());
            System.out.println(temp.getPassword());
            ra = temp;

        }

        public void onCancelled(DatabaseError databaseError) {

        }

    }
}
