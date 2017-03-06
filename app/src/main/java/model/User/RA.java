package model.User;

import com.google.firebase.database.Exclude;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import model.Calendar.RACalendar;
import model.Privilege.Privilege;
import model.Privilege.PrivilegeFactory;
import model.Privilege.SwitchPrivilege;


/**
 * Created by Bill Xiong on 3/3/17.
 * Defines RA abilities, privileges, etc.
 */

public class RA extends User {


    public RA() {
        super();
    }
    public RA(String name) {
        super(name);
        this.addPrivilege(Privilege.Privileges.SWITCH.toString(), new SwitchPrivilege(new RACalendar()));
        //this.addPrivilege(Privilege.Privileges.READ_CALENDAR.toString(), PrivilegeFactory.getPrivilege(Privilege.Privileges.READ_CALENDAR));
        //this.addPrivilege(Privilege.Privileges.PAGE.toString(), PrivilegeFactory.getPrivilege(Privilege.Privileges.PAGE));
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
    @Exclude
    public boolean insert() {
        return false;
    }

    @Exclude
    public boolean addSubordinate(User u) {
        return (u instanceof Resident) && this.addToSubSet(u);
    }

}
