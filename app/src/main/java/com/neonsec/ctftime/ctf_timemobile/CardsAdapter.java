package com.neonsec.ctftime.ctf_timemobile;

/**
 * Created by psn on 3/4/18.
 */

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.squareup.picasso.Picasso;
import net.danlew.android.joda.JodaTimeAndroid;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

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
        DateTimeFormatter parser2 = ISODateTimeFormat.dateTimeNoMillis();
        String jtdate = model.getStart();
        String dt = parser2.parseDateTime(jtdate).toString();
        SimpleDateFormat startDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX"	);
        Date date = null;
        try {
            date = startDate.parse(dt);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        holder.start.setText(date.toString());
        try {
            Picasso.get().load(model.getImageURL()).into(holder.imageView);
        }catch (Exception e){
            holder.imageView.setImageResource(R.drawable.ic_future);
        }
        if(model.getOnsite()){
            holder.onsite.setTextColor(Color.parseColor("#6200ea"));
            holder.onsite.setText("Onsite");
        }else{
            holder.onsite.setTextColor(Color.parseColor("#00c853"));
            holder.onsite.setText("Online");
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