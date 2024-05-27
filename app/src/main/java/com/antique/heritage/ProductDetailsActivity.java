package com.antique.heritage;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView nameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        imageView = findViewById(R.id.prodImage);
        nameTextView = findViewById(R.id.prodName);

        // Get product details from intent
        int imageResId = getIntent().getIntExtra("image_res_id", 0);
        String name = getIntent().getStringExtra("name");

        // Set product details to views
        imageView.setImageResource(imageResId);
        nameTextView.setText(name);
    }
}
