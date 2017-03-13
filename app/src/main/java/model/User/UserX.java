package model.User;

import com.google.firebase.database.DataSnapshot;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import model.Converted;

/**
 * Created by Bill Xiong on 3/6/17.
 * Object to add to database
 */

public class UserX implements Converted, UserInfo {


    private List<String> dorms;
    private String name;


    private String username;
    private String udid;
    private String password;
    private String phone_number;

    public UserX() {
        this.dorms = new ArrayList<>();
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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
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

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return user;
    }

}
