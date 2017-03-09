package model.User;


import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Bill Xiong on 3/3/17.
 * Class for residents
 */

public class Resident extends User{

    public Resident() {
        super();
    }

    public Resident(String name, String username, String udid, String password, String phone_number) {
        super(name, username, udid, password, phone_number);
    }

    public boolean insert() {
        this.addToDatabase();
        return false;
    }

    public boolean addToDormSet(Dorm dorm) {
        return (this.getDorms().size() < 1) && super.addToDormSet(dorm);
    }
}
