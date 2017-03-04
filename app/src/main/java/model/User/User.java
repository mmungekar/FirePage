package model.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import model.Privilege.Privilege;

/**
 * Created by Bill Xiong on 3/3/17.
 * Abstract class for all users- residents, RAs, GR, RC, admin, etc.
 */

public abstract class User {

    private final String PHONE_NUMBER = "";
    private HashMap<Privilege.Privileges, Privilege> privileges;
    private String name;

    public User(String name) {
        this.name = name;
        privileges = new HashMap<>();
        this.addPrivileges();
    }

    /* users can call the pager with this method. Will call number and record call */
    public void call() {
        //TODO something with PHONE_NUMBER and stuff
    }



    /**
     *  Should this be a string
     *  @param pass password to change to
     *  @return true if successful, else false
     */
    public boolean updatePassword(String pass) {
        //TODO SOME fire base stuff
        return false;
    }

    /** Should we allow users to change name
     * @param name name to change to
     * @return true if successful, else false
     */
    public boolean updateName(String name) {
        this.name = name;
        //TODO some firebase stuff
        return false;
    }


    /**
     * A getter to return a map of privileges
     * @return a map of privileges owned by a specific user
     */
    Map<Privilege.Privileges, Privilege> getPrivileges() {
        return Collections.unmodifiableMap(this.privileges);
    }

    /**
     * get user's name
     * @return a string containing user's name
     */
    public String getName() {
        return this.name;
    }

    /**
     *  Allow to dynamically add privileges based on information given
     */
    public abstract void addPrivileges();

}
