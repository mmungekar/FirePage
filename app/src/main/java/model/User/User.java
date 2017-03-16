package model.User;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ValueEventListener;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import model.Convertable;
import model.CRUD;
import model.Database.DataBase;
import model.Privilege.Privilege;

/**
 * Created by Bill Xiong on 3/3/17.
 * Abstract class for all users- residents, RAs, GR, RC, admin, etc.
 * follows builder pattern
 */

public abstract class User implements CRUD, Convertable {

    private Set<Dorm> dorms;
    private String className;

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
        dorms = new HashSet<>();
        this.className = this.getClass().getSimpleName();
    }
    //maps Privilege.Privileges to Privilege obect- pojo must be String to Object
    public User() {
        dorms = new HashSet<>();
        this.name = this.username = this.udid = this.password = this.phone_number = null;
        this.className = this.getClass().getSimpleName();
    }

    /* users can call the pager with this method. Will call number and record call */
    public void call() {
        //TODO something with PHONE_NUMBER and stuff
    }

    public void addSingleEvent(String reference, ValueEventListener e) {
        DataBase.getRoot().getReference(reference).addListenerForSingleValueEvent(e);
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

    public String getClassName() {
        return this.className;
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

    public Set<Dorm> getDorms() {
        return Collections.unmodifiableSet(this.dorms);
    }

    public boolean addToDormSet(Dorm dorm) {
        return this.dorms.add(dorm);
    }

    public boolean removeFromDormSet(Dorm dorm) {
        return this.dorms.remove(dorm);
    }


    public boolean update(String key, Object value) {
        DataBase.getInstance();
        DataBase.updateValue(this.getUserKey(key), value);

        return false;
    }

    public void updateAllValues(Map<String, Object> map) {
        DataBase.getInstance();
        DataBase.update(map);
    }

    public boolean delete(String key) {
        return false;
    }

    public User read(Class<?> name, DataSnapshot snapshot) {
        UserX userx = (UserX) DataBase.read(UserX.class, snapshot);
        return userx.convertBack(name, snapshot);
    }

    /**
     * retrieves from database a specific user with a specific username
     * @param name class name to use
     * @param snapshot data snapshot of particular table
     * @param username username of user to retrieve from database
     * @return User object containing the information
     */
    public User read(Class<?> name, DataSnapshot snapshot, String username) {
        UserX userx = (UserX) DataBase.read(UserX.class, snapshot.child(username));
        return userx.convertBack(name, snapshot.child(username));
    }

    public Object readField(Class<?> name, String field, DataSnapshot snapshot) {
//        Field f = null;
//        Class name = this.getClass();
//        try {
//            f = name.getDeclaredField(field);
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }

        return DataBase.read(name, snapshot.child(this.username).child(field));
    }


    public UserInfo convert() {
        UserX userx = new UserX();
        userx.setName(this.name);
        userx.setPassword (this.password);
        userx.setPhone_number (this.phone_number);
        userx.setUdid(this.udid);
        userx.setUsername(this.username);

        Set<Dorm> dorms = this.dorms;

        for(Dorm d : dorms) {
            userx.getDorms().add(d.toString());
        }
        return userx;
    }

    /**
     * Check if a username exists within a DataSnapshot
     * @param username username to be checked
     * @param snapshot snapshot to iterate through
     * @return true if exists, else false
     */
    public boolean checkUsernameExists(String username, DataSnapshot snapshot) {

        for(DataSnapshot d : snapshot.getChildren()) {
            if(d.child(username).exists()) {
                return false;
            }
        }
        return true;
    }

    public abstract boolean insert();

    protected void addToDatabase() {
        DataBase.getInstance();
        DataBase.insert(this.getUserKey(""), this.convert());
    }

    private String getUserKey(String key) {
        return this.className + "/" + this.username + "/" + key;
    }
}
