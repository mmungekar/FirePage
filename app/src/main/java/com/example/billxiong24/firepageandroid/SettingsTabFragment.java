package com.example.billxiong24.firepageandroid;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;

/**
 * Created by Ritler on 3/8/17.
 */

public class SettingsTabFragment extends Fragment {
    View rootView;
    PopupWindow myWindow;
    View popupView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.tab_settings, container, false);
    Button nameButton =  (Button)rootView.findViewById(R.id.nameButton);
        addListener(nameButton,inflater.inflate(R.layout.tab_settings_name,null));
       Button numberButton =  (Button) rootView.findViewById(R.id.numberButton);
        addListener(numberButton,inflater.inflate(R.layout.tab_settings_number,null));
        Button passwordButton =  (Button) rootView.findViewById(R.id.passwordButton);
       addListener(passwordButton,inflater.inflate(R.layout.tab_settings_password,null));
        Button logoutButton =  (Button) rootView.findViewById(R.id.logoutButton);

        return rootView;
    }

    private void addFields(View myView){
       EditText t1 = (EditText)myView.findViewById(R.id.editText4);
        EditText t2 = (EditText)myView.findViewById(R.id.editText5);
        Button enterButton =(Button)myView.findViewById(R.id.button4);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if password and other fields are valid
               myWindow.dismiss();
            }
        });
    }

    private void addListener(Button b, View v){
        final View myView = v;
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myWindow = new PopupWindow(myView, ViewGroup.LayoutParams.WRAP_CONTENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT);
                myWindow.setFocusable(true);
                myWindow.showAtLocation(myView, Gravity.CENTER, 0, 0);
                addFields(myView);
            }
        });
    }

}
