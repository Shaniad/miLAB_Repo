package e.shaniadir.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.support.v7.widget.LinearLayoutManager;


public class MainLondonActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    LinearLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    String[] londonPlacesDataset =
            {"Big Ben", "London Eye", "London Bridge", "Buckingham Palace", "Hyde Park",
                    "Madame Tussauds", "Tower of London", "River Thames", "Piccadilly Circus",
                    "Leicester Square", "Oxford Street", "Wimbledon"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_london);

        context = getApplicationContext();
        relativeLayout = (LinearLayout) findViewById(R.id.london_linearlayout);
        recyclerView = (RecyclerView) findViewById(R.id.london_recyclerView);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(context, londonPlacesDataset);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
