package com.antique.heritage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MunicipalityAdapter extends RecyclerView.Adapter<MunicipalityAdapter.ViewHolder> {

    private List<MainActivity.Municipality> municipalityList;
    private OnMunicipalityClickListener listener;

    public MunicipalityAdapter(List<MainActivity.Municipality> municipalityList, OnMunicipalityClickListener listener) {
        this.municipalityList = municipalityList;
        this.listener = listener;
    }

    public interface OnMunicipalityClickListener {
        void onMunicipalityClick(int position);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_location, parent, false);
        return new ViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainActivity.Municipality municipality = municipalityList.get(position);
        holder.logoImageView.setImageResource(municipality.getLogoResId());
        holder.nameTextView.setText(municipality.getName());
    }

    @Override
    public int getItemCount() {
        return municipalityList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView logoImageView;
        public TextView nameTextView;

        public ViewHolder(View itemView, OnMunicipalityClickListener listener) {
            super(itemView);
            logoImageView = itemView.findViewById(R.id.locationLogo);
            nameTextView = itemView.findViewById(R.id.locationName);
            itemView.setOnClickListener(v -> listener.onMunicipalityClick(getAdapterPosition()));
        }
    }
}
