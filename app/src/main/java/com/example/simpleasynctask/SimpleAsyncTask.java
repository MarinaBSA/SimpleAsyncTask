package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Void, String> {
    private WeakReference<TextView> textView;

    SimpleAsyncTask(TextView textView) {
        this.textView = new WeakReference<>(textView);
    }

    @Override
    protected String doInBackground(Void... voids) {
        Random num = new Random();
        int n = num.nextInt(11);
        int s = n * 200;

        try {
            Thread.sleep(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Awake after sleeping for " + s + " milliseconds";
    }

    @Override
    protected void onPostExecute(String s) {
        // we have to use get() here because textView is a weak reference
        textView.get().setText(s);
    }
}
