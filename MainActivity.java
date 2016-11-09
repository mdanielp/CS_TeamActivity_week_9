package com.example.dmoney.team_activity;

import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView viewit;
    private Button save;
    private Button advance;
    private TextView check;

    int count = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewit = (TextView) findViewById(R.id.coutit);
        save = (Button) findViewById(R.id.save);
        advance = (Button) findViewById(R.id.advance);
        loadPreference();



        advance.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                viewit.setText(Integer.toString(count));

            }
        });



        save.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences memory = PreferenceManager.getDefaultSharedPreferences((getApplicationContext()));
                memory.edit().putString("autoSave", viewit.getText().toString()).commit();

            }
        });



    }

    public void loadPreference()
    {
        SharedPreferences memory = PreferenceManager.getDefaultSharedPreferences((getApplicationContext()));
        check = (TextView) findViewById(R.id.check);

        check.setText(memory.getString("autoSave",""));

    }


    public void onSharedPreferenceChange(SharedPreferences sharedPreferences, String key)
    {
        loadPreference();
    }
}
