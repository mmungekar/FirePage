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
    /**
     * A getter to return a map of privileges
     * @return a map of privileges owned by a specific user
     */
    public Map<String, Object> getPrivileges() {
        return Collections.unmodifiableMap(this.privileges);
    }

    public List<Object> getDorms() {
        return Collections.unmodifiableList(this.dorms);
    }

    public List<Object> getSubordinates() {
        return Collections.unmodifiableList(this.subordinates);
    }


    /**
     * get user's name
     * @return a string containing user's name
     */
    public String getName() {
        return this.name;
    }

    public boolean insert() {
        return false;
    }

    public boolean addSubordinate(User u) {
        return (u instanceof RA) && this.addToSubSet(u);
    }

}
