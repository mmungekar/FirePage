package model.Notification;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Convertable;
import model.User.UserInfo;
import model.User.UserX;

/**
 * Created by Bill Xiong on 3/3/17.
 * Class for managing notifications, such as private and public notifications
 * Add methods and parameters as needed
 */

public abstract class Notification implements Convertable {

    private String text;
    private Date date;
    private UserInfo sender;
    private Set<UserInfo> receivers;


    public Notification(String text, UserInfo sender, Date date) {
        this.sender = sender;
        this.text = text;
        this.date = date;
        receivers = new HashSet<>();
    }

    public Set<UserInfo> getReceivers() {
        return Collections.unmodifiableSet(receivers);
    }

    public boolean addReceiver(UserX rec) {
        return this.receivers.add(rec);
    }

    public String getText() {
        return this.text;
    }

    public UserInfo getSender() {
        return this.sender;
    }

    /* Add notification to firebase, user can call this method */
    public NotificationX convert() {
        NotificationX notifx = new NotificationX();
        notifx.setText(this.text);
        notifx.setDate(this.date.toString());
        notifx.setSender((UserX) this.sender);

        List<UserX> users = new ArrayList<>();

        for(UserInfo u : this.receivers) {
            users.add((UserX) u);
        }
        notifx.setReceivers(users);

        return notifx;
    }
}
