package com.neonsec.ctftime.ctf_timemobile;

/**
 * Created by psn on 3/4/18.
 */

import android.content.Context;
import android.icu.util.Calendar;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Alhaytham Alfeel on 10/10/2016.
 */

public class CardsAdapter extends ArrayAdapter<CardModel> {
    public CardsAdapter(Context context) {
        super(context, R.layout.card_item);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = inflater.inflate(R.layout.card_item, parent, false);
            holder = new ViewHolder(convertView);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        CardModel model = getItem(position);
        holder.title.setText(model.getTitle());
        holder.type.setText(model.getType());
        holder.url.setText(model.getUrl());
        holder.start.setText(model.getStart());
        try {
            Picasso.get().load(model.getImageURL()).into(holder.imageView);
        }catch (Exception e){
            holder.imageView.setImageResource(R.drawable.ic_future);
        }
        if(model.getOnsite()){
            holder.onsite.setText("OnSite");
        }else{
            holder.onsite.setText("OnLine");
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView title,type,url,onsite,start;


        ViewHolder(View view) {
            imageView = (ImageView) view.findViewById(R.id.image);
            title = (TextView) view.findViewById(R.id.title);
            type = (TextView) view.findViewById(R.id.type);
            onsite = (TextView) view.findViewById(R.id.onsite);
            url = (TextView) view.findViewById(R.id.url);
            start = (TextView) view.findViewById(R.id.start);

        }
    }
}