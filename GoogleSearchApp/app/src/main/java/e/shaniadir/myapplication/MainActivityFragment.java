package e.shaniadir.myapplication;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("debug", "success0000");
        View main_view = inflater.inflate(R.layout.fragment_main, container, false);
        final RequestQueue queue = Volley.newRequestQueue(getContext());
        final String url = "http://www.google.com/search?q=";
        final EditText query = (EditText)main_view.findViewById(R.id.query_editText);
        final TextView showResults = (TextView)main_view.findViewById(R.id.search_results_textView);
        Button search = (Button)main_view.findViewById(R.id.search_button);
        Log.d("debug", "success0");
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("debug", "success1");
                StringRequest req = new StringRequest(Request.Method.GET, url + query.getText(), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("MainActivityFragment", "Response - " + response);
                        showResults.setText(Functionality.getFirstResult(response));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("MainActivityFragment", "Encountered error - " + error);
                    }
                /*
                Log.d("afterclick", "success1");
                Toast.makeText(getActivity(), query.getText().toString(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.il/search?q=" + query.getText())));
                Log.d("search", "success2");
                */
                });
                queue.add(req);
                Log.d("debug", "success2");
            }
        });
        return main_view;
    }
}
