package model.User.Pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Privilege.Privilege;

/**
 * Created by Bill Xiong on 3/5/17.
 * Subclass of
 */

public class UserPojo {

    private Map<Privilege.Privileges, Privilege> privileges;
    private List<Object> dorms;
    private List<Object> subordinates;
    private String name;


    public UserPojo() {

        dorms = new ArrayList<>();
        subordinates = new ArrayList<>();
        privileges = new HashMap<>();
        name = null;
    }

    public UserPojo(String name) {
        this.name = name;
        dorms = new ArrayList<>();
        subordinates = new ArrayList<>();
        privileges = new HashMap<>();

    }
    public Map<Privilege.Privileges, Privilege> getPrivileges() {
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
}
