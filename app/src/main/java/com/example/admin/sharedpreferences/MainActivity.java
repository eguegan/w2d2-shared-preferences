package com.example.admin.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText = (EditText) findViewById(R.id.am_et_1);
    }

    public void saveValue(View v){
        SharedPreferences sp = getSharedPreferences("SP_KEY", MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("SP_KEY", mEditText.getText().toString());
        editor.apply();
    }

    public void loadValue(View v){
        SharedPreferences sp = getSharedPreferences("SP_KEY", MODE_PRIVATE);

        String string = sp.getString("SP_KEY", "DEFAULT_VALUE");

        Log.d("TAG", "loadValue: " + string);
    }
}
