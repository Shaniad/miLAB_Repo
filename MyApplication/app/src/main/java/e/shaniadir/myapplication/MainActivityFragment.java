package e.shaniadir.myapplication;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View main_view = inflater.inflate(R.layout.fragment_main, container, false);
        final EditText query = (EditText)main_view.findViewById(R.id.query_editText);
        Button search = (Button)main_view.findViewById(R.id.search_button);
        Log.d("start", "success0");
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("afterclick", "success1");
                Toast.makeText(getActivity(), query.getText().toString(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.il/search?q=" + query.getText())));
                Log.d("search", "success2");
            }
        });
        return main_view;
    }
}
