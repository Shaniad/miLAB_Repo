package e.shaniadir.myapplication;

import android.app.AlarmManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by shaniadir on 11/21/17.
 */

public class QuoteReceiver extends ResultReceiver{
    public QuoteReceiver(Handler handler) {
        super(handler);
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData){
        final String result = (String)resultData.get(MyIntentService.EXTRA_PARAM_RESULT_STRING);


    }

    private void setAlarm(int minutes){
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    }
}
