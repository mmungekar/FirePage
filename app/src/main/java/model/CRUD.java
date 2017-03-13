package model;

import com.google.firebase.database.DataSnapshot;

/**
 * Created by Bill Xiong on 3/7/17.
 * interface for objects that are CRUDable
 */

public interface CRUD {

    /**
     * Insert for the first time into database
     * @return true if successful, false else
     */
    boolean insert();

    /**
     * Return object retrieved from database with key
     * @param snapshot the snapshot corresponding to read
     * @param key the key to use
     * @return the object corresponding to the key
     */
    Object read(Class<?> name, DataSnapshot snapshot);

    /**
     * Update value at key in database
     * @param key key to update at
     * @param value value to change to
     * @return true if successful, false else
     */
    boolean update(String key, Object value);

    /**
     * Delete object with corresponding key
     * @param key the key of the object to delete
     * @return true if successful, false else
     */
    boolean delete(String key);
}
