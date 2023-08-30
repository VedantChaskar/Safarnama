package com.company.vacationtourapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.company.vacationtourapp.R;
import com.company.vacationtourapp.model.GuideData;

import java.util.List;

public class GuideAdapter extends RecyclerView.Adapter<GuideAdapter.GuideViewHolder> {

    Context context;
    List<GuideData> GuideDataList;

    public GuideAdapter(Context context, List<GuideData> GuideDataList) {
        this.context = context;
        this.GuideDataList = GuideDataList;
    }

    @NonNull
    @Override
    public GuideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.guide_row_item, parent, false);

        return new GuideViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuideViewHolder holder, int position) {

        holder.guide_name.setText(GuideDataList.get(position).getGuideName());
        holder.guide_number.setText(GuideDataList.get(position).getGuideNumber());
        holder.guide_location.setText(GuideDataList.get(position).getGuideLocation());
    }

    @Override
    public int getItemCount() {
        return GuideDataList.size();
    }

    public static final class GuideViewHolder extends RecyclerView.ViewHolder{

        TextView guide_name, guide_number, guide_location;

        public GuideViewHolder(@NonNull View itemView) {
            super(itemView);

            guide_name = itemView.findViewById(R.id.guide_name);
            guide_number = itemView.findViewById(R.id.guide_number);
            guide_location = itemView.findViewById(R.id.guide_location);

        }
    }
}
