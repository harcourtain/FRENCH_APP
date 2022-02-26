package com.example.miwok_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openNumberList(View view) {
        Intent i = new Intent(getApplicationContext(),NumbersActivity.class);
        startActivity(i);
    }
    public void openFamilyList(View view) {
        Intent i = new Intent(getApplicationContext(),FamilyActivity.class);
        startActivity(i);
    }
    public void openColorList(View view) {
        Intent i = new Intent(getApplicationContext(), ColorsActivity.class);
        startActivity(i);
    }
    public void openPhraseList(View view) {
        Intent i = new Intent(getApplicationContext(), PhrasesActivity.class);
        startActivity(i);
    }
}