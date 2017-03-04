package model.User;

import model.Privilege.Privilege;

/**
 * Created by Bill Xiong on 3/3/17.
 * Defines RA abilities, privileges, etc.
 */

public class RA extends User {

    private Dorm dorm;

    public RA(String name, Dorm dorm) {
        super(name);
        this.dorm = dorm;
    }

    public void addPrivileges() {
        this.getPrivileges().put(Privilege.Privileges.ANSWER_PAGES, null);
        this.getPrivileges().put(Privilege.Privileges.SWITCH, null);
        this.getPrivileges().put(Privilege.Privileges.READ_CALENDAR, null);
        this.getPrivileges().put(Privilege.Privileges.RESOLVE_PAGES, null);
    }

}
