package model.User;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.GenericTypeIndicator;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import model.Converted;
import model.Convertable;
import model.Database.DataBase;
import model.Privilege.Privilege;

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

    public User convertBack(Class<?> className, DataSnapshot snapshot) {
        User user = null;

        try {
            user = (User) className.getConstructor(String.class, String.class, String.class, String.class, String.class)
                    .newInstance(this.name, this.username, this.udid, this.password, this.phone_number);
            for(String d : dorms) {
                //TODO error handling
                user.addToDormSet(Dorm.valueOf(d));
            }

            for(String p : privileges) {
                //TODO error handling for valueOf
                user.addPrivilege(Privilege.Privileges.valueOf(p));
            }

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return user;
    }

}
