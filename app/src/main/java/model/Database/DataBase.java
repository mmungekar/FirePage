package model.Database;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

import model.Converted;

/**
 * Created by Bill Xiong on 3/8/17.
 * Class for managing interaction with database- singleton
 */

public class DataBase {
    private static FirebaseDatabase root = FirebaseDatabase.getInstance();
    private static DataBase database = null;

    private DataBase() {

    }

    public static DataBase getInstance() {
        if(database == null)  {
            database = new DataBase();
        }

        return database;
    }

    public static Task insert(String key, Converted convertedObject) {
        return root.getReference(key).setValue(convertedObject);
    }

    public static Task update(String key, Map<String, Object> map) {
        return root.getReference(key).updateChildren(map);
    }

    public static Converted read(Class className, DataSnapshot snapshot) {
        return (Converted) snapshot.getValue(className);
    }

    //TODO implement
    public Task delete(String key) {
        return null;
    }

}
