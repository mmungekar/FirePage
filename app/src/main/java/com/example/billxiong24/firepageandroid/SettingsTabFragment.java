package com.example.billxiong24.firepageandroid;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Ritler on 3/8/17.
 */

public class SettingsTabFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab_settings, container, false);
    Button nameButton =  (Button) findViewById(R.id.nameButton);
        nameButton.setOnClickListener(new View.OnClickListener() {
                                                  @Override
                                                  public void onClick(View view) {

                                                  }
                                              });
        Button numberButton =  (Button) findViewById(R.id.numberButton);
        Button logoutButton =  (Button) findViewById(R.id.logoutButton);
        Button passwordButton =  (Button) findViewById(R.id.passwordButton);

        return rootView;
    }

}
