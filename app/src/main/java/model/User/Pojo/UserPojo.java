package model.User.Pojo;

import com.google.firebase.database.Exclude;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Privilege.Privilege;
import model.User.Dorm;
import model.User.User;
import model.User.UserInfo;

/**
 * Created by Bill Xiong on 3/5/17.
 * UserPojo object to store in database- can convert User to UserPojo
 */

public class UserPojo {

    private Map<String, Object> privileges;
    private List<Object> dorms;
    private List<Object> subordinates;
    private String name;


    public UserPojo() {

        this.dorms = new ArrayList<>();
        this.subordinates = new ArrayList<>();
        this.privileges = new HashMap<>();
        name = null;
    }

    public UserPojo(String name) {
        this.name = name;
        this.dorms = new ArrayList<>();
        this.subordinates = new ArrayList<>();
        this.privileges = new HashMap<>();
    }

    public UserPojo(UserInfo user) {
        this.name = user.getName();
        this.dorms = new ArrayList<>();
        this.subordinates = new ArrayList<>();
        this.privileges = new HashMap<>();

        Set<Dorm> set = user.getDorms();
        for(Object d : set) {
            this.dorms.add(d.toString());
        }
        Set<User> subs = user.getSubordinates();
        for(Object u : subs) {
            this.subordinates.add(subs);
        }

    }
    public Map<String, Object> getPrivileges() {
        return privileges;
    }


    public List<Object> getDorms() {
        return dorms;
    }

    public List<Object> getSubordinates() {
        return subordinates;
    }


    public String getName() {
        return name;
    }

    @Exclude
    private void convert(Map<Privilege.Privileges, Privilege> map) {
        this.privileges = new HashMap<>();
        for(Privilege.Privileges key : map.keySet()) {
            this.privileges.put(key.toString(), map.get(key));
        }
    }
}
