package e.shaniadir.myapplication;

import android.content.Context;
import android.view.View;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

/**
 * Created by shaniadir on 11/13/17.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    String[] mplacesValues;
    Context mcontext;
    View mview;
    ViewHolder mviewHolder;
    TextView mtextView;

    public RecyclerViewAdapter(Context context, String[] placesValues) {

        mplacesValues = placesValues;
        mcontext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public ViewHolder(View view) {

            super(view);

            textView = (TextView) view.findViewById(R.id.places_textview);
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        mview = LayoutInflater.from(mcontext).inflate(R.layout.recyclerview_items, parent, false);

        mviewHolder = new ViewHolder(mview);

        return mviewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.textView.setText(mplacesValues[position]);
    }

    @Override
    public int getItemCount() {

        return mplacesValues.length;
    }
}
