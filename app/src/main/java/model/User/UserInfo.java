package model.User;

import java.util.Map;
import java.util.Set;

import model.Privilege.Privilege;

/**
 * Created by Bill Xiong on 3/6/17.
 * Filters uncessary information when passing to pojo object
 */

public interface UserInfo {

    /**
     * getter for dorms a user is related to
     * @return set of dorm enums
     */
    Set<Dorm> getDorms();

    /**
     * getter for subordinates, if any
     * @return set of user objects
     */
    Set<User> getSubordinates();

    /**
     * getter for user name
     * @return string containing user name
     */
    String getName();

    /**
     * getter for privileges, if any
     * @return map of enum privileges to privilege object
     */
    Map<Privilege.Privileges, Privilege> getPrivileges();
}
