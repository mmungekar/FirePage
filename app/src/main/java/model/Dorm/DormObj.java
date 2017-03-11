package model.Dorm;

import android.app.Notification;

import com.google.firebase.database.DataSnapshot;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import model.CRUD;
import model.Convertable;
import model.Converted;
import model.Database.DataBase;
import model.User.Dorm;
/**
 * Created by Bill Xiong on 3/7/17.
 * Manages operations of the dorm
 */

public class DormObj implements CRUD, Convertable {


    private model.User.Dorm name;
    private Set<Notification> notifications;
    private Calendar calendar;

    public DormObj(model.User.Dorm dorm, Calendar c) {
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

    public Object read(Class<?> name, DataSnapshot snapshot) {
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
