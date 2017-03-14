package model.Dorm;

import com.google.firebase.database.DataSnapshot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import model.CRUD;
import model.Calendar.RACalendar;
import model.Convertable;
import model.Converted;
import model.Database.DataBase;
import model.Notification.Notification;
import model.Notification.NotificationX;
import model.Notification.Page;
import model.Notification.PublicNotification;
import model.User.Dorm;
import model.User.User;

/**
 * Created by Bill Xiong on 3/7/17.
 * Manages operations of the dorm
 */

public class DormObj implements CRUD, Convertable {


    public static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    private Dorm name;
    private String phone_number;
    private Set<PublicNotification> notifications;
    private Set<Page> pages;
    private RACalendar calendar;

    public DormObj(Dorm dorm, RACalendar c) {
        this.name = dorm;
        this.calendar = c;
        this.notifications = new TreeSet<>();
        this.pages = new TreeSet<>();
    }

    public DormObj(Dorm dorm) {
        this.name = dorm;
        this.calendar = new RACalendar();
        this.notifications = new TreeSet<>();
        this.pages = new TreeSet<>();

    }

    public DormObj() {
        this.calendar = new RACalendar();
        this.notifications = new TreeSet<>();
        this.pages = new TreeSet<>();
    }

    public Date formatDate(String str) {
        Date temp = null;

        try {
            temp = formatter.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return temp;
    }

    public String getPhone_number() {
        return this.phone_number;
    }

    public void setPhone_number(String num) {
        this.phone_number = num;
    }

    public Dorm getName() {
        return this.name;
    }

    public void setName(Dorm d) {
        this.name = d;
    }

    public Set<PublicNotification> getNotifications() {
        return Collections.unmodifiableSet(this.notifications);
    }

    public Set<Page> getPages() {
        return Collections.unmodifiableSet(this.pages);
    }

    public boolean addPage(Page page) {
        return this.pages.add(page);
    }

    public boolean addCalendarDate(Date d, User user) {
       return this.calendar.addUser(d, user);
    }

    public Map<Date, User> getCalendarDates() {
        return this.calendar.getDates();
    }

    public boolean insert() {
        DataBase.insert(this.getUserKey(""), this.convert());
        return false;
    }

    public boolean update(String key, Object value) {
       return false;
    }

    public DormObj read(Class<?> name, DataSnapshot snapshot) {
        DormX dormx = (DormX) DataBase.read(DormX.class, snapshot);
        return dormx.convertBack(name, snapshot);
    }

    public DormObj read(Class<?> name, DataSnapshot snapshot, String key) {
        DormX dormx = (DormX) DataBase.read(DormX.class, snapshot.child(key));
        return dormx.convertBack(name, snapshot);
    }

    public boolean delete(String key) {
        return false;
    }

    public Converted convert() {
        DataBase.getInstance();
        DormX dormx = new DormX();
        dormx.setName(this.name.toString());
        dormx.setPhone_number(this.phone_number);
        dormx.setDates(this.convertMap());
        //dormx.setNotifications(this.convertNotifs());
        //dormx.setPages(this.convertPages());

        return dormx;
    }

    private String getUserKey(String key) {
        return "Dorms/" + this.name + "/" + key;
    }

    private Map<String, Object> convertMap() {
        Map<Date, User> map = calendar.getDates();
        Map<String, Object> translate = new HashMap<>();
        for(Date d : map.keySet()) {
            translate.put(formatter.format(d), map.get(d).getUsername());
        }
        return translate;
    }

    private List<NotificationX> convertNotifs() {
        List<NotificationX> notifs = new ArrayList<>();
        for(Notification n : this.notifications) {
            notifs.add(n.convert());
        }
        return notifs;
    }

    private List<NotificationX> convertPages() {
        List<NotificationX> notifs = new ArrayList<>();
        for(Notification n : this.pages) {
            notifs.add(n.convert());
        }
        return notifs;
    }
}
