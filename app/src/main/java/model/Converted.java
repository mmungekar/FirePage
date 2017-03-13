package model;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by Bill Xiong on 3/7/17.
 * interface for converted objects to add to database
 */

public interface Converted {
    Convertable convertBack(Class<?> className, DataSnapshot snapshot);
}
