package e.shaniadir.myapplication;

import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.support.v4.app.NotificationCompat;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View main_view = inflater.inflate(R.layout.fragment_main, container, false);
        Button start_button = (Button)main_view.findViewById(R.id.start_button);
        final EditText minutes = (EditText)main_view.findViewById(R.id.minutesPicker);
        start_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String minutes_from_user = minutes.getText().toString();
                String final_config_text = "You will receive quote every " + minutes_from_user + " minutes";
                Toast toast = Toast.makeText(view.getContext(), final_config_text, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();

                NotificationCompat.Builder builder = new NotificationCompat.Builder(main_view.getContext());
                        //.setSmallIcon(R.mipmap.img_example).setContentTitle("My notification")  .setContentText(editText.getText().toString());
                NotificationManager notificationManager = (NotificationManager)main_view.getContext()  .getSystemService(Context.NOTIFICATION_SERVICE);
                int id = 1;
                notificationManager.notify(id, builder.build());
            }
        });
        return main_view;
    }
}
