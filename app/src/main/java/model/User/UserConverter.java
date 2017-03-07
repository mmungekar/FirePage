package model.User;

import java.util.ArrayList;
import java.util.Set;

import model.Privilege.Privilege;

/**
 * Created by Bill Xiong on 3/6/17.
 */

public class UserConverter {
    public static UserX convertToUserX(User user) {
        UserX userx = new UserX();
        userx.name = user.getName();
        userx.password = user.getPassword();
        userx.phone_number = user.getPhone_number();
        userx.udid = user.getUdid();
        userx.username = user.getUsername();

        userx.dorms = new ArrayList<>();
        userx.privileges = new ArrayList<>();

        Set<Privilege.Privileges> priv = user.getPrivileges();
        Set<Dorm> dorms = user.getDorms();

        for(Privilege.Privileges p : priv) {
            userx.privileges.add(p.toString());
        }

        for(Dorm d : dorms) {
            userx.dorms.add(d.toString());
        }

        return userx;
    }

    public static User convertToUser(UserX userx) {
        return null;
    }
}
