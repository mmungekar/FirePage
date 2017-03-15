package com.example.billxiong24.firepageandroid;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.HashMap;

import Utilities.Colors;
import customcalendar.CalendarAdapter;
import customcalendar.CalendarCollection;


/**
 * Created by Ritler on 3/8/17.
 */

public class CalendarTabFragment extends Fragment {
    /*View rootView;
    CalendarView calendar;
    Context c;
    HashMap<Integer, Integer> monthLength = new HashMap<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        monthLength.put(0, 31);

        rootView = inflater.inflate(R.layout.tab_calendar, container, false);

        calendar = (CalendarView) rootView.findViewById(calendarView);

        Calendar current = Calendar.getInstance();
        System.out.println(current.getTime().getYear());

        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(current.get(Calendar.YEAR), current.get(Calendar.MONTH), 1);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(current.get(Calendar.YEAR), current.get(Calendar.MONTH), current.getActualMaximum(Calendar.DAY_OF_MONTH));

        calendar.setMinDate(calendar1.getTimeInMillis());
        calendar.setMaxDate(calendar2.getTimeInMillis());
        c = (Context) this.getContext();
        calendar.setOnDateChangeListener(new OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                Toast.makeText(c, "Selected date " + dayOfMonth + "/" + month + "/" + year, Toast.LENGTH_SHORT);
            }
        });


        return rootView;
    }*/
    public GregorianCalendar cal_month, cal_month_copy;
    private CalendarAdapter cal_adapter;
    private RAListAdapter ra_adapter;
    private TextView tv_month;
    private Colors colorMaker = new Colors();
    HashMap<String, Integer> RAColors = new HashMap<>();
    String RA;
    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        rootView = inflater.inflate(R.layout.tab_calendar, container, false);
        String[] array = {"Hashirama", "Tobirama", "Madara", "Izuna", "Naruto", "Sasuke"};
        addRAs(new ArrayList<String>(Arrays.asList(array)));



        cal_month = (GregorianCalendar) GregorianCalendar.getInstance();
        cal_month_copy = (GregorianCalendar) cal_month.clone();
        cal_adapter = new CalendarAdapter(this.getContext(), cal_month, CalendarCollection.date_collection_arr);
        ra_adapter = new RAListAdapter(this.getContext(), RAColors);


        tv_month = (TextView) rootView.findViewById(R.id.tv_month);
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));

        ImageButton previous = (ImageButton) rootView.findViewById(R.id.ib_prev);

        previous.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                setPreviousMonth();
                refreshCalendar();
            }
        });

        ImageButton next = (ImageButton) rootView.findViewById(R.id.Ib_next);
        next.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                setNextMonth();
                refreshCalendar();

            }
        });

        GridView gridview = (GridView) rootView.findViewById(R.id.gv_calendar);
        GridView raGrid = (GridView) rootView.findViewById(R.id.ra_list);
        System.out.println(gridview.getChildAt(0));
        for(int i=0; i< gridview.getChildCount(); i++) {
            View child = (View) gridview.getChildAt(i);
            System.out.println(child.getId());
            System.out.println(i);
        }
        gridview.setAdapter(cal_adapter);
        raGrid.setAdapter(ra_adapter);
        gridview.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                ((CalendarAdapter) parent.getAdapter()).setSelected(v,position);
                String selectedGridDate = CalendarAdapter.day_string
                        .get(position);

                String[] separatedTime = selectedGridDate.split("-");
                String gridvalueString = separatedTime[2].replaceFirst("^0*","");
                int gridvalue = Integer.parseInt(gridvalueString);

                if ((gridvalue > 10) && (position < 8)) {
                    setPreviousMonth();
                    refreshCalendar();
                } else if ((gridvalue < 7) && (position > 28)) {
                    setNextMonth();
                    refreshCalendar();
                }
                System.out.println(v.getId() + " " + position);
                ((CalendarAdapter) parent.getAdapter()).setSelected(v,position);
                if(RA != null) {
                    v.setBackgroundColor(RAColors.get(RA));
                }

                // ((CalendarAdapter) parent.getAdapter()).getPositionList(selectedGridDate, this.getClass());
            }

        });
        raGrid.setOnItemClickListener(new OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                ((RAListAdapter) parent.getAdapter()).setSelected(v,position);
                RA = ((TextView) v.findViewById(R.id.name)).getText().toString();




                // ((CalendarAdapter) parent.getAdapter()).getPositionList(selectedGridDate, this.getClass());
            }

        });

        return rootView;

    }
    public void addRAs(ArrayList<String> RAs){
        for(String RA: RAs){
            RAColors.put(RA, colorMaker.getColor());
        }
    }


    protected void setNextMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month.getActualMaximum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) + 1),
                    cal_month.getActualMinimum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) + 1);
        }

    }

    protected void setPreviousMonth() {
        if (cal_month.get(GregorianCalendar.MONTH) == cal_month
                .getActualMinimum(GregorianCalendar.MONTH)) {
            cal_month.set((cal_month.get(GregorianCalendar.YEAR) - 1),
                    cal_month.getActualMaximum(GregorianCalendar.MONTH), 1);
        } else {
            cal_month.set(GregorianCalendar.MONTH,
                    cal_month.get(GregorianCalendar.MONTH) - 1);
        }

    }

    public void refreshCalendar() {
        cal_adapter.refreshDays();
        cal_adapter.notifyDataSetChanged();
        tv_month.setText(android.text.format.DateFormat.format("MMMM yyyy", cal_month));
    }

}
