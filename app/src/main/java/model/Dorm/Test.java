package model.Dorm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by billxiong24 on 3/11/17.
 */

public class Test {

    public static void main(String args[]) {
        Date date = new Date();
        SimpleDateFormat dt = new SimpleDateFormat("yyyy-MM-dd");
        String stringdate = dt.format(date);

        try {
            Date temp = dt.parse(stringdate);
            System.out.println(temp.toString());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(stringdate);

    }
}
