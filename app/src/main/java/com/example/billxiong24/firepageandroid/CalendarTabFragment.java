package com.example.billxiong24.firepageandroid;

import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

/**
 * Created by Ritler on 3/8/17.
 */

public class CalendarTabFragment extends Fragment {

    private int activeButton = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = inflater.inflate(R.layout.tab_calendar, container, false);

        HashSet<Date> events = new HashSet<>();
        events.add(new Date());

        CalendarView cv = ((CalendarView)findViewById(R.id.calendar_view));
        cv.updateCalendar(events);
        Button orange = (Button) findViewById(R.id.button7);
        whenClicked(orange);
      /*  orange.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                whenClicked(v);
            }
        });*/
        Button blue = (Button) findViewById(R.id.button8);
        whenClicked(blue);

        // assign event handler
        cv.getGrid().setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> view, View cell, int position, long id)
            {
                if(activeButton!=0) {
                    Button temp = (Button) findViewById(activeButton);
                    cell.setBackgroundColor(((ColorDrawable) temp.getBackground()).getColor());
                }
            }
        });
        cv.setEventHandler(new CalendarView.EventHandler()
        {
            @Override
            public void onDayLongPress(Date date)
            {
                // show returned day
                DateFormat df = SimpleDateFormat.getDateInstance();
                Toast.makeText(MainActivity.this, df.format(date), Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
    private void whenClicked(Button b){
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                activeButton = v.getId();
            }
        });
    }

}
