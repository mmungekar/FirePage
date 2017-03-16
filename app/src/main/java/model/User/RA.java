package model.User;

import com.google.firebase.database.Exclude;

import java.util.Date;


/**
 * Created by Bill Xiong on 3/3/17.
 * Defines RA abilities, privileges, etc.
 */

public class RA extends User {


    public RA() {
        super();
    }
    public RA(String name, String username, String udid, String password, String phone_number) {
        super(name, username, udid, password, phone_number);
    }

    /**
     * get user's name
     * @return a string containing user's name
     */
    @Exclude
    public boolean insert() {
        this.addToDatabase();
        return false;
    }

    public boolean addToDormSet(Dorm dorm) {
        return (this.getDorms().size() < 1) && super.addToDormSet(dorm);
    }

    public Dorm getDorm() {
        Dorm f = null;
        for(Dorm d : this.getDorms()) {
            f = d;
            break;
        }
        return f;
    }

    public void requestSwitch(Date date) {

    }

    public void acceptSwitch(Date date) {

    }
}
