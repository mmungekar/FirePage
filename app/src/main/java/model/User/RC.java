package model.User;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Bill Xiong on 3/4/17.
 * Manages RC functions
 */

public class RC extends User {

    public RC() {
       super();
    }
    public RC(String name, String username, String udid, String password, String phone_number) {
        super(name, username, udid, password, phone_number);
    }

    public boolean insert() {
        return false;
    }

}
