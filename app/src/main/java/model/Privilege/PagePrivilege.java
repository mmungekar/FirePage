package model.Privilege;

import model.User.User;

/**
 * Created by Bill Xiong on 3/4/17.
 * Manages all paging permissions
 */

public class PagePrivilege extends Privilege {

    public PagePrivilege() {
        super();
    }

    /**
     * when someone pages, add a notification
     * @param user user to add notification about
     * @return true if successful, else false
     */
    public boolean addNotification(User user) {
       return false;
    }
}
