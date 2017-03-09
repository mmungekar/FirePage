package model.Dorm;

import com.google.firebase.database.DataSnapshot;

import model.Convertable;
import model.Converted;

/**
 * Created by Bill Xiong on 3/7/17.
 * Dorm object to be stored in the database
 */

public class DormX implements Converted {

    public Convertable convertBack(Class<?> className, DataSnapshot snapshot) {
        return null;
    }
}
