package e.shaniadir.myapplication;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View main_view =  inflater.inflate(R.layout.fragment_main, container, false);

        Button london_button = (Button)main_view.findViewById(R.id.london_button);
        london_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainLondonActivity.class);
                startActivity(intent);
            }
        });

        Button paris_button = (Button)main_view.findViewById(R.id.paris_button);
        paris_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainParisActivity.class);
                startActivity(intent);
            }
        });

        return main_view;
    }
}
