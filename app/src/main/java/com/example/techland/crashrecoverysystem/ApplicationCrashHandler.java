    package com.example.techland.crashrecoverysystem;

    import android.app.Activity;
    import android.app.ActivityManager;
    import android.app.AlarmManager;
    import android.app.PendingIntent;
    import android.content.Context;
    import android.content.Intent;
    import android.os.Build;
    import android.support.annotation.RequiresApi;
    import android.support.v4.app.ActivityCompat;
    import android.support.v4.content.LocalBroadcastManager;
    import android.util.Log;

    public class ApplicationCrashHandler implements Thread.UncaughtExceptionHandler {

        private Activity activity;
        private Thread.UncaughtExceptionHandler defaultHandler;
        public static Class topActivity;

        private static final String TAG = "ApplicationCrashHandler";

        public ApplicationCrashHandler(Activity activity) {
            this.activity = activity;
            Log.i(TAG, "ApplicationCrashHandler: ");
            //activity.moveTaskToBack(true);
            //showActivities();
        }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        Intent intent = new Intent(activity, CustomErrorActivity.class);
        intent.putExtra("crash", true);

        intent.addFlags(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        activity.overridePendingTransition(0,0);

        PendingIntent pendingIntent = PendingIntent.getActivity(CrashRecoveryApplication.getInstance().getBaseContext(), 0, intent, intent.getFlags());
        AlarmManager mgr = (AlarmManager) CrashRecoveryApplication.getInstance().getBaseContext().getSystemService(Context.ALARM_SERVICE);
        mgr.set(AlarmManager.RTC, System.currentTimeMillis()+10 , pendingIntent);

        activity.onBackPressed();


        activity.finish();
        //ActivityCompat.finishAfterTransition(activity);
        //activity.finishAfterTransition();
        //activity.finishActivity(1);
        System.exit(2);


//        Intent intent = new Intent();
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        activity.finish();
//        activity.startActivity(intent);
    }


    }

