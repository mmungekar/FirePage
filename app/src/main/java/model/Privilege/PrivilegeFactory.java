package model.Privilege;

import android.support.annotation.Nullable;

import model.Calendar.Calendar;
import model.Calendar.RACalendar;

/**
 * Created by Bill Xiong on 3/4/17.
 * Factory for generating privilege objects
 */

public class PrivilegeFactory {

    /**
     * factory method for getting privilege object based on enum passed in
     * @param p enum of privilege
     * @return corresponding privilege object
     */
    @Nullable
    public static Privilege getPrivilege(Privilege.Privileges p) {
        switch (p) {
            case PAGE:
                return new PagePrivilege();
            case READ_CALENDAR:
                return new ReadCalendarPrivilege(new RACalendar());
            case UPDATE_CALENDAR:
                return new UpdateCalendarPrivilege(new RACalendar());
            case SWITCH:
                return new SwitchPrivilege(new RACalendar());
            default:
                return null;
        }
    }
}
