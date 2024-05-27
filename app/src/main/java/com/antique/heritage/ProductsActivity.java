package com.antique.heritage;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Product> productList;
    private String municipalityName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        recyclerView = findViewById(R.id.recyclerView);
        productList = new ArrayList<>();

        municipalityName = getIntent().getStringExtra("municipality_name");

        // Adding products based on the municipality name
        addProductsForMunicipality(municipalityName);

        // Set up RecyclerView
        ProductAdapter adapter = new ProductAdapter(productList);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(adapter);
    }

    private void addProductsForMunicipality(String municipalityName) {
        if (municipalityName.equals("San Jose")) {
            productList.add(new Product(R.drawable.patadyong, "Patadyong"));
        } else if (municipalityName.equals("Tobias Fornier")) {
            productList.add(new Product(R.drawable.buri, "Buri"));
        } else if (municipalityName.equals("Sibalom")) {
            productList.add(new Product(R.drawable.bamboo_crafting, "Bamboo Crafting"));
        } else if (municipalityName.equals("Tibiao")) {
            productList.add(new Product(R.drawable.traditional_pottery, "Traditional Pottery"));
        } else if (municipalityName.equals("Patnongon")) {
            productList.add(new Product(R.drawable.abaca_products, "Abaca Products"));
        }
    }
}
