package com.antique.heritage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ProductsActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Item> productList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        Intent intent = getIntent();
        String mun_str = intent.getStringExtra("sel_mun");

        // Initialize product list
        productList = new ArrayList<>();
        // Add products to the list (drawable and string)
        switch (mun_str) {
            case "Tobias Fornier":
                productList.add(new Item(R.drawable.buri, "Buri"));
                break;
            case "San Jose":
                productList.add(new Item(R.drawable.patadyong, "patadyong"));
                break;
            case "Sibalom":
                productList.add(new Item(R.drawable.bamboo_crafting, "Bamboo Crafting"));
                break;
            case "Tibiao":
                productList.add(new Item(R.drawable.traditional_pottery, "Traditional Pottery"));
                break;
            case "Patnongon":
                productList.add(new Item(R.drawable.abaca_products, "Abaca Products"));
                break;
            default:
                break;
        }

        ProductAdapter adapter = new ProductAdapter(productList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new ProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(ProductsActivity.this, ProductDetailsActivity.class);
                String prod_name = productList.get(position).getText();
                intent.putExtra("prod_name", prod_name);
                startActivity(intent);
            }
        });
    }
}
