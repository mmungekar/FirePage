package model.User;

import java.util.ArrayList;
import java.util.List;
import model.Converted;
import model.Convertable;

/**
 * Created by Bill Xiong on 3/6/17.
 * Object to add to database
 */

public class UserX implements Converted {

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

    public Convertable convertBack() {
        return null;
    }

}
