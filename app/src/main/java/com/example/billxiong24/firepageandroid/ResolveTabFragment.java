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
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

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
                final View popupView = inflater.inflate(R.layout.tab_resolve_details,null);
                myWindow = new PopupWindow(popupView,LayoutParams.WRAP_CONTENT,
                        LayoutParams.WRAP_CONTENT);
                myWindow.setFocusable(true);
               myWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0);
                Button enterButton = (Button) popupView.findViewById(R.id.enterButton);
                enterButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        EditText resolveField = (EditText) popupView.findViewById(R.id.editText2);
                       if(resolveField.getText().length()==0){
                            resolveField.setHint("Please Enter a Resolution");
                        }
                        else{
                           //Add more code here
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
