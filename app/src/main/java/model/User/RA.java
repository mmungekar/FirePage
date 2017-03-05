package model.User;

import model.Privilege.Privilege;
import model.Privilege.PrivilegeFactory;


/**
 * Created by Bill Xiong on 3/3/17.
 * Defines RA abilities, privileges, etc.
 */

public class RA extends User {

    private Dorm dorm;

    public RA(String name, Dorm dorm) {
        super(name);
        this.dorm = dorm;
        this.addPrivilege(Privilege.Privileges.SWITCH, PrivilegeFactory.getPrivilege(Privilege.Privileges.SWITCH));
        this.addPrivilege(Privilege.Privileges.READ_CALENDAR, PrivilegeFactory.getPrivilege(Privilege.Privileges.READ_CALENDAR));
        this.addPrivilege(Privilege.Privileges.PAGE, PrivilegeFactory.getPrivilege(Privilege.Privileges.PAGE));
    }

    public boolean insert() {
        return false;
    }

    public boolean addSubordinate(User u) {
        return (u instanceof Resident) && this.addToSubSet(u);
    }

}
