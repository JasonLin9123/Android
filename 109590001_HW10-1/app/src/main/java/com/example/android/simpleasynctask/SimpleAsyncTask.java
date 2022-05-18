/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.android.simpleasynctask;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.Random;

public class SimpleAsyncTask extends AsyncTask<Void, Integer, String> {

    // The TextView where we will show results
    private WeakReference<TextView> mTextView;
    private ProgressBar mPBar;
    // Constructor that provides a reference to the TextView from the MainActivity
    SimpleAsyncTask(TextView tv) {
        mTextView = new WeakReference<>(tv);
    }
    public void setProgressBar(View view) {
        mPBar = (ProgressBar) view;
    }

    @Override
    protected String doInBackground(Void... voids) {

        // Generate a random number between 0 and 10.
        Random r = new Random();
        int n = r.nextInt(11);

        // Make the task take long enough that we have
        // time to rotate the phone while it is running.
        int s = n * 200;
        int delta = s / 20;
        // Sleep for the random amount of time.
        for (int i = 0; i < 20; i++) {
            try {
                //Thread.sleep(s);
                Thread.sleep(delta);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            publishProgress((i+1) * 5);
        }

        // Return a String result.
        return "Awake at last after sleeping for " + s + " milliseconds!";
    }
    protected void onPostExecute(String result) {
        mTextView.get().setText(result);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        mPBar.setProgress(values[0]);
    }
}
