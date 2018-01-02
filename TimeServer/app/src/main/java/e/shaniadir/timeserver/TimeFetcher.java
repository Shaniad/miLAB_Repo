package e.shaniadir.timeserver;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
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

        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, REQUEST_URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            TimeResponse res = new TimeResponse(
                                    response.getString("server_time"));
                            Log.d("server_time", "gettime");
                            listener.onResponse(res);
                        }
                        catch (JSONException e) {}
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

        _queue.add(req);
    }
}
