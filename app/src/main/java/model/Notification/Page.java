package model.Notification;

import java.util.Date;

import model.User.UserInfo;

/**
 * Created by Bill Xiong on 3/10/17.
 * Page is a type of notification
 */

public class Page extends Notification {

    public Page(String text, UserInfo sender, Date date) {
        super(text, sender, date);
    }

}
