package model.User;

import com.google.firebase.database.Exclude;

import model.Privilege.Privilege;
import model.Privilege.PrivilegeFactory;


/**
 * Created by Bill Xiong on 3/3/17.
 * Defines RA abilities, privileges, etc.
 */

public class RA extends User {


    public RA(String name) {
        super(name);
        this.addPrivilege(Privilege.Privileges.SWITCH, PrivilegeFactory.getPrivilege(Privilege.Privileges.SWITCH));
        this.addPrivilege(Privilege.Privileges.READ_CALENDAR, PrivilegeFactory.getPrivilege(Privilege.Privileges.READ_CALENDAR));
        this.addPrivilege(Privilege.Privileges.PAGE, PrivilegeFactory.getPrivilege(Privilege.Privileges.PAGE));
    }


    @Exclude
    public boolean insert() {
        return false;
    }

    @Exclude
    public boolean addSubordinate(User u) {
        return (u instanceof Resident) && this.addToSubSet(u);
    }

}
