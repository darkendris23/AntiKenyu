package com.antique.heritage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {

    private ImageView prodImage;
    private TextView prodName;
    private TextView prodPrice;
    private TextView prodHist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        // Initialize views
        prodImage = findViewById(R.id.prodImage);
        prodName = findViewById(R.id.prodName);
        prodPrice = findViewById(R.id.prodPrice);
        prodHist = findViewById(R.id.prodHist);

        // Get the product name from the intent
        Intent intent = getIntent();
        String prod_name = intent.getStringExtra("prod_name");

        if (prod_name == null) {
            Toast.makeText(this, "No product selected", Toast.LENGTH_LONG).show();
            return;
        }

        // Update views based on the selected product
        switch (prod_name) {
            case "Buri":
                prodImage.setImageResource(R.drawable.buri);
                prodName.setText("Buri");
                prodPrice.setText("₱850");
                prodHist.setText("It is the largest palm endemic in the Philippines. In Panay, it is abundant in Barangay Diclum, Tobias Fornier (formerly known as Dao), Antique. The busy and skillful hands of the women of Barangay Diclum capitalized on the versatility of buri palm and pursued buri weaving as a livelihood. The process of buri weaving starts when the “manugrara kang buri” strip off the large fan-shaped leaves of the buri palm. The stripped leaves are dried under the sun and colorfully dyed with different colors. The leaves will be then woven into wallets, bags and other items. The elders of the weaving community established the Buri Handicraft Association, Inc. of Antique which aims to strengthen the buri weaving industry in Antique."); // Set description if available
                break;
            case "Patadyong":
                prodImage.setImageResource(R.drawable.patadyong);
                prodName.setText("Patadyong");
                prodPrice.setText("₱270");
                prodHist.setText("It is a traditional handwoven fabric that is a staple in the Visayan region, particularly in San Jose de Buenavista, Antique. This vibrant fabric is created from cotton or abcca fibers, showcasing intricate designs and patterns. The weavers, predominantly women, use traditional looms to produce the patadyong. The process involves preparing the threads, dyeing them with natural and synthetic dyes, and meticulously weaving them into the final product. The patadyong is versatile, used as skirts, blankets, or wraps, and represents a rich cultural heritage. The community has formed cooperatives to preserve this craft, ensuring its continued significance in local traditions and economies."); // Set description if available
                break;
            case "Bamboo Crafting":
                prodImage.setImageResource(R.drawable.bamboo_crafting);
                prodName.setText("Bamboo Crafting");
                prodPrice.setText("Price: ₱370");
                prodHist.setText("It is an age-old tradition in Sibalom, Antique, where bamboo is abundant. The craft involves harvesting bamboo, treating it to prevent pests, and then skillfully shaping it into various products such as furniture, baskets, and home decor items. The artisans, often organized into cooperatives, use techniques passed down through generations. The durability and aesthetic appeal of these bamboo crafts make them highly sought after. Sibalom's bamboo products not only serve local needs but also reach broader markets, contributing to the local economy."); // Set description if available
                break;
            case "Traditional Pottery":
                prodImage.setImageResource(R.drawable.traditional_pottery);
                prodName.setText("Traditional Pottery");
                prodPrice.setText("Price: ₱340");
                prodHist.setText(""); // Set description if available
                break;
            case "Abaca Products":
                prodImage.setImageResource(R.drawable.abaca_products);
                prodName.setText("Abaca Products");
                prodPrice.setText("Price: ₱270");
                prodHist.setText("It has ancient origins, with evidence of pottery making dating back to early settlements. Local clay is harvested, shaped, and fired in kilns to produce cooking pots, jars, and decorative pieces. The pottery process involves several steps, including kneading the clay, forming the shapes, drying, and firing. These items are known for their durability and cultural significance, often used in daily life and ceremonies."); // Set description if available
                break;
            default:
                Toast.makeText(this, "Unknown product", Toast.LENGTH_LONG).show();
                break;
        }

        Button checkout = findViewById(R.id.checkout);
        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetailsActivity.this, CheckoutActivity.class);
                startActivity(intent);
            }
        });

    }
}
