package model.User;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Privilege.Privilege;
import model.User.Pojo.UserPojo;

/**
 * Created by Bill Xiong on 3/3/17.
 * Abstract class for all users- residents, RAs, GR, RC, admin, etc.
 */

public abstract class User {

    private final String PHONE_NUMBER = "";
    private Set<Privilege.Privileges> privileges;
    private Set<Dorm> dorms;
    private Set<User> subordinates;
    private String name;

    public User(String name) {
        this.name = name;
        privileges = new HashSet<>();
        subordinates = new HashSet<>();
        dorms = new HashSet<>();
    }
    //maps Privilege.Privileges to Privilege obect- pojo must be String to Object
    public User() {
        privileges = new HashSet<>();
        subordinates = new HashSet<>();
        dorms = new HashSet<>();
        this.name = null;
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
    public Set<Privilege.Privileges> getPrivileges() {
        return Collections.unmodifiableSet(this.privileges);
    }
    public Set<Dorm> getDorms() {
        return Collections.unmodifiableSet(this.dorms);
    }

    public Set<User> getSubordinates() {
        return Collections.unmodifiableSet(this.subordinates);
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
    public void addPrivilege(Privilege.Privileges a) {
        this.privileges.add(a);
    }
    protected boolean addToSubSet(User u) {
        return (u != null) && this.subordinates.add(u);
    }

    public boolean addToDormSet(Dorm dorm) {
        return this.dorms.add(dorm);
    }

    /**
     * method for inserting object into database, each subclass has different implementation
     * @return true on success, else false
     */
    public abstract boolean insert();

    /**
     * method for adding subordinates, i.e. RAs have residents, GRs have RAs, etc.
     * @param u user to add
     * @return true if added successfully, else false
     */
    public abstract boolean addSubordinate(User u);

    public UserPojo toPojo() {
        UserPojo pojo = new UserPojo(this.name);

        return null;
    }

    @Exclude
    protected boolean getDorm(String str) {
        Dorm d = null;
        try {
            d = Dorm.valueOf(str);
        }
        catch(IllegalArgumentException e) {
            //TODO something better than this
            e.printStackTrace();
        }
        return d != null;
    }
}
