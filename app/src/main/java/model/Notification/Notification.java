package model.Notification;

import java.util.Collections;
import java.util.Set;

import model.User.UserX;

/**
 * Created by Bill Xiong on 3/3/17.
 * Class for managing notifications, such as private and public notifications
 * Add methods and parameters as needed
 */

public abstract class Notification {

    private String text;
    private UserX sender;
    private Set<UserX> receivers;


    public Notification(String text, UserX sender) {
        this.sender = sender;
        this.text = text;
    }

    public Set<UserX> getReceivers() {
        return Collections.unmodifiableSet(receivers);
    }

    public boolean addReceiver(UserX rec) {
        return this.receivers.add(rec);
    }

    public String getText() {
        return this.text;
    }

    public UserX getSender() {
        return this.sender;
    }

    /* Add notification to firebase, user can call this method */
    public abstract void addNotification();

}
