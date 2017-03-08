package model.Notification;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import model.User.UserX;

/**
 * Created by Bill Xiong on 3/6/17.
 * Public notification- anyone can see these, based on some restrictions,
 * i.e. dorms
 */

public class PublicNotification extends Notification{


    public PublicNotification(String text, UserX sender) {
        super(text, sender);
    }


    public void addNotification() {

    }
}
