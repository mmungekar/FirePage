package model.User;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Bill Xiong on 3/4/17.
 * Manages actions for graduate resident
 */

public class GR extends User {


    public GR() {
       super();
    }
    public GR(String name, String username, String udid, String password, String phone_number) {
        super(name, username, udid, password, phone_number);
    }

    public boolean insert() {
        this.addToDatabase();
        return false;
    }


}
