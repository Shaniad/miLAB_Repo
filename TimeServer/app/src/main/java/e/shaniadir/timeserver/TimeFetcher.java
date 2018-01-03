package e.shaniadir.timeserver;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by shaniadir on 1/2/18.
 */

public class TimeFetcher {
    private RequestQueue _queue;
    private final static String REQUEST_URL = "https://milab-server.herokuapp.com/getTime";

    public class TimeResponse{
        public String time;

        public TimeResponse(String time_res){
            this.time = time_res;
        }
    }

    public interface TimeResponseListener{
        public void onResponse(TimeResponse response);
    }

    public TimeFetcher(Context context){ _queue = Volley.newRequestQueue(context); }

    public void dispatchRequest(final TimeResponseListener listener){

        StringRequest req = new StringRequest(Request.Method.GET, REQUEST_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        TimeResponse res = new TimeResponse(
                                response);
                        Log.d("server_time", "gettime");
                        listener.onResponse(res);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        _queue.add(req);
    }

}
