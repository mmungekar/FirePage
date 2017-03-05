package model.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Bill Xiong on 3/4/17.
 * Manages RC functions
 */

public class RC extends User {

    private Set<Dorm> dorms;
    public RC(String name) {
        super(name);
        this.dorms = new HashSet<>();
    }

    public RC(String name, Set<Dorm> dorms) {
        super(name);
        this.dorms = dorms;
    }

    public boolean insert() {
        return false;
    }

    public boolean addSubordinate(User u) {
        return (u instanceof GR) && this.addToSubSet(u);
    }
}
