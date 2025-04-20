package com.example.assignment1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Cart_Activity extends AppCompatActivity {
    private ListView cartList;
    private Button btnCheckout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartList = findViewById(R.id.cartListView);
        btnCheckout = findViewById(R.id.checkoutButton);

        List<String> itemNames = SharedPrefManager.loadCart(this);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, itemNames);
        cartList.setAdapter(adapter);

        btnCheckout.setOnClickListener(v -> {
            SharedPrefManager.clearCart(this);
            Toast.makeText(this, "Order placed!", Toast.LENGTH_SHORT).show();
            itemNames.clear();
            adapter.notifyDataSetChanged();
        });
    }
}
