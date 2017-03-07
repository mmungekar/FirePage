package model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Privilege.Privilege;

/**
 * Created by Bill Xiong on 3/6/17.
 */

public class UserX {

    List<String> privileges, dorms;
    String name, username, udid, password, phone_number;

    public UserX() {
        this.privileges = new ArrayList<>();
        this.dorms = new ArrayList<>();
    }

    public List<String> getPrivileges() {
        return privileges;
    }

    public List<String> getDorms() {
        return dorms;
    }

    public String getName() {
        return name;
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

}
