package e.shaniadir.myapplication;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {
    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_ShowQuote = "e.shaniadir.myapplication.action.ShowQuote";

    // TODO: Rename parameters
    private static final String EXTRA_MINUTES = "e.shaniadir.myapplication.extra.MINUTES";
    private static final String EXTRA_PARAM2 = "e.shaniadir.myapplication.extra.PARAM2";

    String[] quotes = new String[]{"The best preparation for tomorrow is doing your best today",
            "Life isn't about finding yourself, Life is about creating yourself",
            "Whoever is happy will make others happy too",
            "A leader is one who knows the way, goes the way, and shows the way",
            "Everything has beauty, but not everyone sees it",
            "Believe you can and you're halfway there", "Do all things with love",
            "Where there is love there is life", "Try to be a rainbow in someone's cloud",
            "Learning never exhausts the mind"};

    int index = 0;

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionShowQuote(Context context, String minutes) {
        Intent intent = new Intent(context, MyIntentService.class);
        Log.d("Debug", "service1");
        intent.setAction(ACTION_ShowQuote);
        intent.putExtra(EXTRA_MINUTES, minutes);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_ShowQuote.equals(action)) {
                final String minutes = intent.getStringExtra(EXTRA_MINUTES);
                final String quote = intent.getStringExtra(quotes[index]);
                handleActionShowQuote(minutes, quote);
            }
        }
        index++;
        if (index == quotes.length){
            index = 0;
        }
    }

    private void handleActionShowQuote(String minutes, String quote) {
        // TODO: Handle action Foo
        Notification quoteNotify = new NotificationCompat.Builder(this)
                .setAutoCancel(true)
                .setDefaults(Notification.DEFAULT_ALL)
                .setWhen(System.currentTimeMillis())
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Quote Notification!")
                .setContentText(quotes[index])
                .setDefaults(Notification.DEFAULT_LIGHTS | Notification.DEFAULT_SOUND)
                .build();
        NotificationManagerCompat manager = NotificationManagerCompat.from(this);
        manager.notify(0, quoteNotify);
    }
}