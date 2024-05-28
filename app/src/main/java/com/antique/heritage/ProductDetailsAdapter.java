package com.antique.heritage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductDetailsAdapter extends RecyclerView.Adapter<ProductDetailsAdapter.ViewHolder> {

    private List<ProductDetailItem> productDetailList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public ProductDetailsAdapter(List<ProductDetailItem> productDetailList) {
        this.productDetailList = productDetailList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProductDetailItem item = productDetailList.get(position);
        holder.imageView.setImageResource(item.getImageResId());
        holder.titleTextView.setText(item.getTitle());
        holder.quantityTextView.setText(String.valueOf(item.getQuantity()));
        holder.descriptionTextView.setText(item.getDescription());
    }

    @Override
    public int getItemCount() {
        return productDetailList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleTextView;
        TextView quantityTextView;
        TextView descriptionTextView;

        ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.prodImage);
            titleTextView = itemView.findViewById(R.id.prodName);
            quantityTextView = itemView.findViewById(R.id.prodPrice);
            descriptionTextView = itemView.findViewById(R.id.prodHist);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
