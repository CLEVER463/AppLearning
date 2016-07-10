package com.three.learning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.three.learning.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .add(R.id.placeholder,new MainFragment(),"main")
                .commit();

    }
}
