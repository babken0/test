package com.example.babken.test;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    final String SAVE_TEXT = "saved_text";

    EditText editText;
    CheckBox box;
    SharedPreferences sPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.saveText);

        box = findViewById(R.id.checkbox);


    }

    @Override
    protected void onPause() {
        super.onPause();
        if(box.isChecked()){
            save();
        }
    }

    private void save() {
        sPref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVE_TEXT,editText.getText().toString());
        ed.commit();

    }

    private void load() {
        sPref = getPreferences(MODE_PRIVATE);
        String savedText = sPref.getString(SAVE_TEXT,"");
        editText.setText(savedText);
    }


}
