package com.example.rartamonov.restlife;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements DateBornFragment.OnYearsFragmentInteractionListener, YearsFragment.OnMonthsFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v4.app.Fragment dateBornFragment = new DateBornFragment();
        android.support.v4.app.Fragment yearsFragment = new YearsFragment();
        android.support.v4.app.Fragment monthsFragment = new MonthsFragment();

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.date_born, dateBornFragment);
        fragmentTransaction.add(R.id.years, yearsFragment);
        fragmentTransaction.add(R.id.months, monthsFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onYearsFragmentInteraction(String[] link) {
        YearsFragment yearsFragment = (YearsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.years);
        if (yearsFragment != null) {
            yearsFragment.showGrid(link);
        }
    }

    @Override
    public void onMonthsFragmentInteraction() {
        MonthsFragment monthsFragment = (MonthsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.months);
        if (monthsFragment != null){
            monthsFragment.showGrid();
        }
    }
}
