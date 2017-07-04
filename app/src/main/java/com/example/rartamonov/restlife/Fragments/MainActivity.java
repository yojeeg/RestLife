package com.example.rartamonov.restlife.Fragments;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.rartamonov.restlife.R;

public class MainActivity extends AppCompatActivity implements DateBornFragment.OnYearsFragmentInteractionListener, YearsFragment.OnMonthsFragmentInteractionListener, MonthsFragment.OnDaysFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v4.app.Fragment dateBornFragment = new DateBornFragment();
        android.support.v4.app.Fragment yearsFragment = new YearsFragment();
        android.support.v4.app.Fragment monthsFragment = new MonthsFragment();
        android.support.v4.app.Fragment daysFragment = new DaysFragments();
        android.support.v4.app.Fragment tasksFragment = new TasksFragment();

        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.years, yearsFragment);
        fragmentTransaction.add(R.id.months, monthsFragment);
        fragmentTransaction.add(R.id.days, daysFragment);
        fragmentTransaction.add(R.id.date_born, dateBornFragment); // в данном фрагменте при запуске
        // происходит заполнение фрагментов years, months и days, поэтому в списке он стоит ПОСЛЕ них
        fragmentTransaction.add(R.id.tasks, tasksFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onYearsFragmentInteraction(String[] link) {
        YearsFragment yearsFragment = (YearsFragment) getSupportFragmentManager()
                .findFragmentById(R.id.years);
        if (yearsFragment != null) {
            //yearsFragment.showGrid(link);
            yearsFragment.showTableYears(link);
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

    @Override
    public void onDaysFragmentInteraction() {
        DaysFragments daysFragments = (DaysFragments) getSupportFragmentManager()
                .findFragmentById(R.id.days);
        if(daysFragments != null){
            daysFragments.showTableDays();
        }
    }
}
