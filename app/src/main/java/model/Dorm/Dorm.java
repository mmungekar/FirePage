package model.Dorm;

import android.app.Notification;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import model.CRUD;
import model.Convertable;
import model.Converted;
import model.Database.DataBase;

/**
 * Created by Bill Xiong on 3/7/17.
 * Manages operations of the dorm
 */

public class Dorm implements CRUD, Convertable {


    private Dorm name;
    private Set<Notification> notifications;
    private Calendar calendar;

    public Dorm(Dorm dorm, Calendar c) {
        this.name = dorm;
        this.calendar = c;
        this.notifications = new TreeSet<>();
    }

    public Set<Notification> getNotifications() {
        return Collections.unmodifiableSet(this.notifications);
    }

    public void addPage(String text) {

    }

    public void addCalendarDate(Date d, String text) {

    }

    public boolean insert() {
        return false;
    }

    public boolean update(String key, Object value) {
       return false;
    }

    public Object read(String key) {
        return null;
    }

    public boolean delete(String key) {
        return false;
    }

    public Converted convert() {
        DataBase.getInstance();

        return null;
    }
}
