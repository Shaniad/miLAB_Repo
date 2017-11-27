package e.shaniadir.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    int minutes = 5;
    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final Activity activity = this.getActivity();
        View main_view = inflater.inflate(R.layout.fragment_main, container, false);
        final EditText minutes_from_user = (EditText)main_view.findViewById(R.id.minutes_from_user);
        Button service_button = (Button)main_view.findViewById(R.id.service_button);
        service_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CharSequence charMinutes = minutes_from_user.getText();
                minutes = Integer.parseInt(charMinutes.toString());
                MyIntentService.startActionShowQuote(activity, String.valueOf(minutes));
            }
        });
        return main_view;
    }
}
