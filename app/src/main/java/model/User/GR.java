package model.User;

import java.util.Set;

/**
 * Created by Bill Xiong on 3/4/17.
 * Manages actions for graduate resident
 */

public class GR extends User {

    private Dorm dorm;

    public GR(String name, Dorm dorm) {
        super(name);
        this.dorm = dorm;
    }

    public boolean insert() {
        return false;
    }

    public boolean addSubordinate(User u) {
        return (u instanceof RA) && this.addToSubSet(u);
    }

}
