package com.kolapo.ranti;

import java.util.ArrayList;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Kolapo on 8/1/2015.
 */
public class EventRecycleViewAdapter extends RecyclerView.Adapter<EventRecycleViewAdapter.ViewHolder>{

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvDate;
        public ImageView ivEventImage;

        public ViewHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.event_name);
            this.tvDate = (TextView) itemView.findViewById(R.id.event_date);
            this.ivEventImage = (ImageView) itemView.findViewById(R.id.event_image);
        }

    }

    private ArrayList<Event> events;
    private Context context;

    // Pass in the context and event list into the constructor
    public EventRecycleViewAdapter(Context context, ArrayList<Event> events){
        this.context = context;
        this.events = events;
    }

    @Override
    public EventRecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the custom layout
        View itemView = LayoutInflater.from(context).
                inflate(R.layout.layout_event_row, parent, false);
        // Return a new holder instance
        return new EventRecycleViewAdapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Event event = events.get(position);
        // Set item views based on the data model
        holder.tvName.setText(event.name);
        holder.tvDate.setText(event.date);
        holder.ivEventImage.setImageDrawable(new RoundImage(event.bitmap));
    }

    @Override
    public int getItemCount() {
        return events.size();
    }

}
