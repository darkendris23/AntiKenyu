package com.antique.heritage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Item> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Initialize item list
        itemList = new ArrayList<>();
        // Add items to the list (drawable and string)
        itemList.add(new Item(R.drawable.tobias_fornier, "Tobias Fornier"));
        itemList.add(new Item(R.drawable.san_jose, "San Jose"));
        itemList.add(new Item(R.drawable.sibalom, "Sibalom"));
        itemList.add(new Item(R.drawable.tibiao, "Tibiao"));
        itemList.add(new Item(R.drawable.patnongon, "Patnongon"));

        // Add more items...

        MunicipalityAdapter adapter = new MunicipalityAdapter(itemList);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MunicipalityAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, ProductsActivity.class);
                String mun_str = itemList.get(position).getText();
                intent.putExtra("sel_mun", mun_str);
                startActivity(intent);
            }
        });
    }
}
