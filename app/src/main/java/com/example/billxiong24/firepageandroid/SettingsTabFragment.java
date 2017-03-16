package com.example.billxiong24.firepageandroid;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Ritler on 3/8/17.
 */

public class SettingsTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_settings, container, false);
    Button nameButton =  (Button)findViewById(R.id.nameButton);
        nameButton.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {
                                                rootView.setContentView(R.layout.tab_settings_name);
                                                      addFields();
                                                  }
                                              });
        Button numberButton =  (Button) findViewById(R.id.numberButton);
        numberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootView.setContentView(R.layout.tab_settings_number);
                addFields();
            }
        });
        Button passwordButton =  (Button) findViewById(R.id.passwordButton);
        passwordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootView.setContentView(R.layout.tab_settings_password);
                addFields();
            }
        });
        Button logoutButton =  (Button) findViewById(R.id.logoutButton);

        return rootView;
    }

    private void addFields(){
        EditText t1 = (EditText)findViewById(R.id.editText4);
        EditText t2 = (EditText)findViewById(R.id.editText5);
        Button enterButton =(Button)findViewById(R.id.button4);
        enterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if password and other fields are valid
                rootView.setContentView(R.layout.tab_settings);
            }
        });
    }

}
