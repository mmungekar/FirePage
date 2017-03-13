package model.User;

import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Convertable;
import model.Converted;
import model.Privilege.Privilege;

/**
 * Created by Bill Xiong on 3/6/17.
 * Filters uncessary information when passing to pojo object
 * Provides ability to restore object to previous state without exposing
 * unecessary internal state
 *
 */

public interface UserInfo extends Converted {

    /**
     * getter for dorms a user is related to
     * @return list of dorm enums converted to strings
     */
    List<String> getDorms();

    /**
     * getter for user name
     * @return string containing user name
     */
    String getName();

    /**
     * getter for username
     * @return username
     */
    String getUsername();

    /**
     * getter for phone number
     * @return phone number
     */
    String getPhone_number();

    /**
     * getter for udid
     * @return udid
     */
    String getUdid();


}
