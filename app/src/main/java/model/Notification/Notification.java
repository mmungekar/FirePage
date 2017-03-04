package model.Notification;

/**
 * Created by Bill Xiong on 3/3/17.
 * Class for managing notifications, such as private and public notifications
 * Add methods and parameters as needed
 */

public abstract class Notification {

    private String text;

    public Notification(String text) {
        this.text = text;
    }

    /* Add notification to firebase, user can call this method */
    public abstract void addNotification(Notification notif);

}
