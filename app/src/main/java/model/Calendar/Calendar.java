package model.Calendar;

import java.util.Date;

import model.User.User;

/**
 * Created by Bill Xiong on 3/3/17.
 * Manages calendar functions... maybe find wrap calendar api
 * Add methods and parameters as needed
 */

public interface Calendar {

    /**
     *  Add user to calendar, for example add user to be on call
     *  @param d date to add user on
     *  @param u user to add
     *  @return true if present, else false
     */
    boolean addUser(Date d, User u);

    /**
     *  Get user on a specific day, for example get the user on call
     *  @param date to get info on
     *  @return user on specific date
     */
    User getInfo(Date date);

    /**
     * Switch users for on call
     * @param a first user
     * @param b second user
     * @param date date to switch
     */
    void switchUser(User a, User b, Date date);

}
