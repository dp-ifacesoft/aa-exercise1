package com.example.dp.exercise1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private static final String TEXT_KEY = "TEXT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ((TextView) findViewById(R.id.text_view)).setText(getIntent().getStringExtra(TEXT_KEY));
    }

    public static void start(Context context, View view) {
        Intent intent = new Intent(context, new Object() {
        }.getClass().getEnclosingClass());

        intent.putExtra(TEXT_KEY, ((EditText) view).getText().toString());

        context.startActivity(intent);
    }
}
