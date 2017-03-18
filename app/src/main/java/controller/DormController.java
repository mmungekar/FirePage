package controller;

import com.google.firebase.database.DataSnapshot;

import model.Dorm.DormObj;
import model.User.Dorm;
import model.User.User;

/**
 * Created by BIll XIong on 3/13/17.
 * Controller for dorm related stuff
 */

public class DormController {
    private DormObj dormObj;

    public DormController() {
        this.dormObj = new DormObj();
    }

    public void setDormName(Dorm dorm) {
        this.dormObj.setName(dorm);
    }

    public DormObj read(DataSnapshot snapshot) {
        return this.dormObj.read(DormObj.class, snapshot, this.dormObj.getName().toString());
    }

    public void insertCallDate(String date, User user) {
        this.dormObj.insertNewDate(date, user);
    }
}
