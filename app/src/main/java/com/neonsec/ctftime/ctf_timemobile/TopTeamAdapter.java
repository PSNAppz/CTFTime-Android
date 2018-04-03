package com.neonsec.ctftime.ctf_timemobile;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by psn on 3/4/18.
 */

public class TopTeamAdapter extends RecyclerView.Adapter<TopTeamAdapter.MyViewHolder> {

    private Context mContext;
    private List<TopTeams> teamList;
    public TopTeamAdapter(Context mContext, List<TopTeams> teamList) {
        this.mContext = mContext;
        this.teamList = teamList;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_top_ten_teams, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TopTeams team = teamList.get(position);
        holder.teamName.setText("Team : "+team.getName());
        holder.teamPoint.setText("Points : "+team.getPoints());
        holder.card.setCardBackgroundColor(Color.parseColor(team.getColor()));

    }

    @Override
    public int getItemCount() {
        return teamList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView teamName, teamPoint;
        public CardView card;

        public MyViewHolder(View view) {
            super(view);
            teamName = (TextView) view.findViewById(R.id.tname);
            teamPoint = (TextView) view.findViewById(R.id.tpoints);
            card = (CardView) view.findViewById(R.id.card_view);
        }
    }
}
