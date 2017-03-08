package model.Notification;

import model.User.UserX;

/**
 * Created by Bill Xiong on 3/6/17.
 * Only you can see this notification- occurs when want to switch on calendar, for example
 */

public class PrivateNotification extends Notification {


    public PrivateNotification(String text, UserX sender) {
        super(text, sender);
    }

    @Override
    public boolean addReceiver(UserX rec) {
        return (this.getReceivers().size() < 1) && super.addReceiver(rec);
    }

    public void addNotification() {

    }
}
