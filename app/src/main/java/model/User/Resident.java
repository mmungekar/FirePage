package model.User;


import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Created by Bill Xiong on 3/3/17.
 * Class for residents
 */

public class Resident extends User{

    public Resident(String name) {
        super(name);
    }

    public boolean insert() {
        return false;
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
    public boolean addSubordinate(User u) {
        //residents have no subordinates
        return false;
    }

    @Override
    public boolean addToDormSet(String dorm) {
        return (this.getDorms().size() < 1) && super.addToDormSet(dorm);
    }
}
