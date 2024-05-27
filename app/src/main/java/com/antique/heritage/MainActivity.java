package com.antique.heritage;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MunicipalityAdapter.OnMunicipalityClickListener {

    private RecyclerView recyclerView;
    private List<Municipality> municipalities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Create a list of municipalities
        municipalities = new ArrayList<>();
        addMunicipality(R.drawable.san_jose, "San Jose");
        addMunicipality(R.drawable.tobias_fornier, "Tobias Fornier");
        addMunicipality(R.drawable.sibalom, "Sibalom");
        addMunicipality(R.drawable.tibiao, "Tibiao");
        addMunicipality(R.drawable.patnongon, "Patnongon");

        // Set up the adapter
        MunicipalityAdapter adapter = new MunicipalityAdapter(municipalities, this);
        recyclerView.setAdapter(adapter);
    }

    private void addMunicipality(int logoResId, String name) {
        municipalities.add(new Municipality(logoResId, name));
    }

    @Override
    public void onMunicipalityClick(int position) {
        Municipality municipality = municipalities.get(position);

        // Start ProductActivity and pass the clicked municipality data
        Intent intent = new Intent(this, ProductsActivity.class);
        intent.putExtra("municipality_name", municipality.getName());
        startActivity(intent);
    }

    public static class Municipality {
        private int logoResId;
        private String name;

        public Municipality(int logoResId, String name) {
            this.logoResId = logoResId;
            this.name = name;
        }

        public int getLogoResId() {
            return logoResId;
        }

        public String getName() {
            return name;
        }
    }
}
