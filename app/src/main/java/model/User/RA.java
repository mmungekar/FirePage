package model.User;

import com.google.firebase.database.Exclude;

import model.Privilege.Privilege;


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
        this.addPrivilege(Privilege.Privileges.SWITCH);
        this.addPrivilege(Privilege.Privileges.READ_CALENDAR);
        this.addPrivilege(Privilege.Privileges.PAGE);
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
}
