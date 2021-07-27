package com.example.e_workmanager_2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import java.util.concurrent.TimeUnit;

public class WorkReboot extends BroadcastReceiver {
    WorkManager mWorkManager;

    @Override
    public void onReceive(Context context, Intent intent) {

        PeriodicWorkRequest.Builder myWorkBuilder =
                new PeriodicWorkRequest.Builder(BackgroundTask.class,
                        PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS,
                        TimeUnit.MILLISECONDS);

        PeriodicWorkRequest myWork = myWorkBuilder.build();
        mWorkManager = WorkManager.getInstance(context);
        mWorkManager.enqueue(myWork);

    }
}
