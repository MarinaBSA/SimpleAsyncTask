package com.example.simpleasynctask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TEXT_STATE = "currentText";

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView1);

        // Restore the state of the TextView
        if(savedInstanceState != null) {
            textView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        textView.setText(R.string.napping);
        new SimpleAsyncTask(textView).execute();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        // this is called right before the activity gets destroyed
        super.onSaveInstanceState(outState);
        // Save the state of the TextView which gets lost if we rotate the device
        outState.putString(TEXT_STATE, textView.getText().toString());
    }
}
