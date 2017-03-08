package model.User;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import model.Convertable;
import model.Converted;
import model.CRUD;
import model.Privilege.Privilege;

/**
 * Created by Bill Xiong on 3/3/17.
 * Abstract class for all users- residents, RAs, GR, RC, admin, etc.
 */

public abstract class User implements CRUD, Convertable {

    private Set<Privilege.Privileges> privileges;
    private Set<Dorm> dorms;

    private String name;
    private String username;
    private String udid;
    private String password;
    private String phone_number;

    //TODO make this protected or private, instantiate through builder method
    public User(String name, String username, String udid, String password, String phone_number) {
        this.name = name;
        this.username = username;
        this.udid = udid;
        this.password = password;
        this.phone_number = phone_number;
        privileges = new HashSet<>();
        dorms = new HashSet<>();
    }
    //maps Privilege.Privileges to Privilege obect- pojo must be String to Object
    public User() {
        privileges = new HashSet<>();
        dorms = new HashSet<>();
        this.name = this.username = this.udid = this.password = this.phone_number = null;
    }

    /* users can call the pager with this method. Will call number and record call */
    public void call() {
        //TODO something with PHONE_NUMBER and stuff
    }

    public String getName() {
        return this.name;
    }

    public String getUsername() {
        return username;
    }

    public String getUdid() {
        return udid;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    /**
     * Set name, and return this, implementing builder pattern
     * @param name new name
     * @return this object
     */
    public User setName(String name) {
        this.name = name;
        return this;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public User setUdid(String udid) {
        this.udid = udid;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public User setPhone_number(String phone_number) {
        this.phone_number = phone_number;
        return this;
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



    /**
     *  Allow to dynamically add privileges based on information given
     */
    public void addPrivilege(Privilege.Privileges a) {
        this.privileges.add(a);
    }


    public boolean addToDormSet(Dorm dorm) {
        return this.dorms.add(dorm);
    }


    public boolean update(String key, Object value) {
        return false;
    }

    public boolean delete(String key) {
        return false;
    }

    public  Object read(String key) {
        return null;
    }


    public Converted convert() {
        UserX userx = new UserX();
        userx.name = this.name;
        userx.password = this.password;
        userx.phone_number = this.phone_number;
        userx.udid = this.udid;
        userx.username = this.username;
        userx.dorms = new ArrayList<>();
        userx.privileges = new ArrayList<>();
        Set<Privilege.Privileges> priv = this.privileges;
        Set<Dorm> dorms = this.dorms;

        for(Privilege.Privileges p : priv) {
            userx.privileges.add(p.toString());
        }

        for(Dorm d : dorms) {
            userx.dorms.add(d.toString());
        }
        return userx;
    }

    public abstract boolean insert();
}
