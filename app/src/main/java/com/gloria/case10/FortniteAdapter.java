package com.gloria.case10;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.request.RequestOptions;


import java.text.SimpleDateFormat;
import java.util.List;

public class FortniteAdapter extends RecyclerView.Adapter<FortniteAdapter.JobsViewHolder> {


    private List<StatsData> dataList;


    public FortniteAdapter(List<StatsData> dataList) {
        this.dataList = dataList;
    }

    @Override
    public JobsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.content_main, viewGroup, false);
        return new JobsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(JobsViewHolder jobsViewHolder, int i) {
        jobsViewHolder.setScore(dataList.get(i));

    }



    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class JobsViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNoticeTitle, txtNoticeValue, txtNoticeRank;

        public JobsViewHolder(View item) {
            super(item);
            txtNoticeTitle = item.findViewById(R.id.title);
            txtNoticeValue = item.findViewById(R.id.value);
            txtNoticeRank = item.findViewById(R.id.rank);
        }
        void setScore(StatsData item){
            txtNoticeTitle.setText(item.getLabel());
            txtNoticeValue.setText(item.getValue());
            txtNoticeRank.setText(item.getRank());
        }

    }
}