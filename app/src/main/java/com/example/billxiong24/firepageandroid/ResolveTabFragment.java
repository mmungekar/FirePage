package com.example.billxiong24.firepageandroid;

import android.support.v4.app.Fragment;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import java.util.ArrayList;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.view.Gravity;

/**
 * Created by Ritler on 3/8/17.
 */

public class ResolveTabFragment extends Fragment {
    PopupWindow myWindow;
    ArrayList<String> myList;
    ArrayAdapter<String> adapter;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.tab_resolve, container, false);
        ListView myListView = (ListView)rootView.findViewById(R.id.myListView);
        myList=new ArrayList<String>();
        myList.add("Hi wassup");
        adapter=new ArrayAdapter<String>(this.getContext(),
                android.R.layout.simple_list_item_1,
                myList);
        myListView.setAdapter(adapter);
        Button resolveButton = (Button)rootView.findViewById(R.id.button3);
        resolveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 * TEST and figure out if syntax works
                 */
                myWindow = new PopupWindow(rootView);
                myWindow.showAtLocation(rootView, Gravity.BOTTOM, 10, 10);
                myWindow.update(50, 50, 320, 90);
                myWindow.setContentView( inflater.inflate(R.layout.tab_resolve_details, container, false));
                Button enterButton = (Button) rootView.findViewById(R.id.enterButton);
                final EditText resolveField = (EditText) rootView.findViewById(R.id.editText2);
                enterButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(resolveField.getText().toString()==null||resolveField.getText().toString().equals("Enter")){
                            resolveField.setText("Please Enter a Resolution");
                        }
                        else{
                            myWindow.dismiss();
                        }
                    }
                });
            }
        });
        //EXAMPLE OF LINKING LIST TO DATABASE QUERIES
     /*   Cursor cursor = getContentResolver().query(People.CONTENT_URI, new String[] {People._ID, People.NAME, People.NUMBER}, null, null, null);
        startManagingCursor(cursor);

        // THE DESIRED COLUMNS TO BE BOUND
        String[] columns = new String[] { People.NAME, People.NUMBER };
        // THE XML DEFINED VIEWS WHICH THE DATA WILL BE BOUND TO
        int[] to = new int[] { R.id.time_entry};

        // CREATE THE ADAPTER USING THE CURSOR POINTING TO THE DESIRED DATA AS WELL AS THE LAYOUT INFORMATION
        SimpleCursorAdapter mAdapter = new SimpleCursorAdapter(this, R.layout.tab_resolve_list_entry, cursor, columns, to);

        // SET THIS ADAPTER AS YOUR LISTACTIVITY'S ADAPTER
        this.setListAdapter(mAdapter); */
        return rootView;
    }

}
