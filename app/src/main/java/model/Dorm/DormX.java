package model.Dorm;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.Exclude;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Convertable;
import model.Converted;
import model.Notification.NotificationX;
import model.User.Dorm;
import model.User.RA;
import model.User.User;

/**
 * Created by Bill Xiong on 3/7/17.
 * Dorm object to be stored in the database
 */

public class DormX implements Converted {


    private String name;
//    private List<NotificationX> notifications;
//    private List<NotificationX> pages;
    private Map<String, Object> dates;

    public DormX() {
//        notifications = new ArrayList<>();
//        pages = new ArrayList<>();
        dates = new HashMap<>();
    }

    public String getName() {
        return name;
    }

//    public List<NotificationX> getNotifications() {
//        return notifications;
//    }
//
//    public List<NotificationX> getPages() {
//        return pages;
//    }

    public Map<String, Object> getDates() {
        return dates;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void setNotifications(List<NotificationX> notifications) {
//        this.notifications = notifications;
//    }
//
//    public void setPages(List<NotificationX> pages) {
//        this.pages = pages;
//    }

    public void setDates(Map<String, Object> dates) {
        this.dates = dates;
    }



    @Exclude
    public DormObj convertBack(Class<?> className, DataSnapshot snapshot) {

        DormObj ret = null;
        try {
            ret = (DormObj) className.getConstructor().newInstance();
            ret.setName(Dorm.valueOf(this.name));
            for(String str : this.dates.keySet()) {

                User ra = new RA();
                ra.setUsername((String) this.dates.get(str));
                ret.addCalendarDate(ret.formatDate(str), ra);
            }
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return ret;
    }
}
