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
    public RC(String name) {
        super(name);
    }

    public boolean insert() {
        return false;
    }

    public boolean addSubordinate(User u) {
        return (u instanceof GR) && this.addToSubSet(u);
    }
}
