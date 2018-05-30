package com.example.dp.exercise1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button_activity).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Main2Activity.start(v.getContext(), findViewById(R.id.edit_text));
            }
        });

        findViewById(R.id.button_email).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO);

                intent
                        .setData(Uri.parse("mailto:"))
                        .putExtra(Intent.EXTRA_EMAIL, "test@examplel.com")
                        .putExtra(Intent.EXTRA_SUBJECT, "From App")
                        .putExtra(Intent.EXTRA_TEXT, "ALL GOOD!!!");

                if (intent.resolveActivity(getPackageManager()) != null) {
                    v.getContext().startActivity(intent);
                    Toast.makeText(v.getContext(), "Email app started", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(v.getContext(), "Email app not found", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
