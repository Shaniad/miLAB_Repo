package e.shaniadir.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

public class MainParisActivity extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    LinearLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    String[] parisPlacesDataset =
            {"Eiffel Tower", "Louvre Museum", "Tuileries Garden", "Montmartre", "Arc de Triomphe",
                    "Conciergerie", "Grand Palais", "Seine River", "Notre-Dame Cathedral",
                    "Centre Pompidou", "Pantheon", "Disneyland"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_paris);

        context = getApplicationContext();
        relativeLayout = (LinearLayout) findViewById(R.id.paris_linearlayout);
        recyclerView = (RecyclerView) findViewById(R.id.paris_recyclerView);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(context, parisPlacesDataset);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}
