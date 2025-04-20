package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class home_Activity extends AppCompatActivity {

    String FOOD_TITLE = "Food";
    String DRINKS_TITLE = "Drinks";
    private TextView txtFoodTitle, txtDrinksTitle;
    private CardView  CrdFoodHomeActivity, CrdDrinksHomeActivity;
    private Button btnCart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        setupViews();
    }
    private void setupViews(){
        btnCart = findViewById(R.id.btnCart);
        txtFoodTitle = findViewById(R.id.txtFoodTitle);
        txtDrinksTitle = findViewById(R.id.txtDrinksTitle);
        CrdDrinksHomeActivity = findViewById(R.id.CrdDrinksHomeActivity);
        CrdFoodHomeActivity = findViewById(R.id.CrdFoodHomeActivity);

        txtFoodTitle.setText(FOOD_TITLE);
        txtDrinksTitle.setText(DRINKS_TITLE);
        btnCart.setOnClickListener(view -> {
            try {
                Intent intent = new Intent(home_Activity.this, Cart_Activity.class);
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(this, "Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        CrdFoodHomeActivity.setOnClickListener(view -> {
            Intent intent = new Intent(home_Activity.this, Itams_Activity.class);
            intent.putExtra("FOOD_TITLE",txtFoodTitle.getText());
            startActivity(intent);
        });

        CrdDrinksHomeActivity.setOnClickListener(view -> {
            Intent intent = new Intent(home_Activity.this, Itams_Activity.class);
            intent.putExtra("DRINKS_TITLE",txtDrinksTitle.getText());
            startActivity(intent);
        });

    }

}