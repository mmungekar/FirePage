package model.Notification;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;
import java.util.List;

import model.Converted;
import model.User.UserX;

/**
 * Created by Bill Xiong on 3/10/17.
 * Pojo object to add to database
 */

public class NotificationX implements Converted {

    private String text;
    private String date;
    private UserX sender;
    private List<UserX> receivers;

    public NotificationX() {
       this.receivers = new ArrayList<>();
    }

    public Notification convertBack(Class<?> name, DataSnapshot snapShot) {
        return null;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public UserX getSender() {
        return sender;
    }

    public void setSender(UserX sender) {
        this.sender = sender;
    }

    public List<UserX> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<UserX> receivers) {
        this.receivers = receivers;
    }
}
