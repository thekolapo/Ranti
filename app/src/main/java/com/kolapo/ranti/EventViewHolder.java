package com.kolapo.ranti;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by fredicruz on 8/13/2015.
 */
public class EventViewHolder extends RecyclerView.ViewHolder {

    public TextView tvName;
    public TextView tvDate;
    public ImageView ivEventImage;

    public EventViewHolder(View itemView) {
        super(itemView);

        this.tvName = (TextView) itemView.findViewById(R.id.event_name);
        this.tvDate = (TextView) itemView.findViewById(R.id.event_date);
        this.ivEventImage = (ImageView) itemView.findViewById(R.id.event_image);
    }

    public void bind(EventModel event) {
        tvName.setText(event.getName());
        tvDate.setText(event.getDate());
        ivEventImage.setImageDrawable(new RoundImage(event.getBitmap()));
    }
}
