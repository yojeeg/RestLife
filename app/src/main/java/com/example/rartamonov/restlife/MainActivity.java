package com.example.rartamonov.restlife;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment dateBornFragment = new DateBornFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.date_born, dateBornFragment);
        fragmentTransaction.commit();
    }

//    public void onClick(View v) {
//        DialogFragment dateDialog = new DatePicker();
//        dateDialog.show(getSupportFragmentManager(), "datePicker");
//    }

}
