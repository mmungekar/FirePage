package model.User;

import model.Privilege.Privilege;

/**
 * Created by Bill Xiong on 3/3/17.
 * Class for residents
 */

public class Resident extends User{

    private Dorm dorm;
    public Resident(String name, Dorm dorm) {
        super(name);
        this.dorm = dorm;
    }

    public void addPrivileges() {
        //no PRIVILEGES :(
    }

}
