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
    public GR(String name) {
        super(name);
    }

    public boolean insert() {
        return false;
    }

    public boolean addSubordinate(User u) {
        return (u instanceof RA) && this.addToSubSet(u);
    }

}
