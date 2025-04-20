package com.example.assignment1;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class Cart_Activity extends AppCompatActivity {
    private ListView cartList;
    private Button btnCheckout;
    private TextView txtTotalPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartList = findViewById(R.id.cartListView);
        btnCheckout = findViewById(R.id.checkoutButton);
        txtTotalPrice = findViewById(R.id.txtTotalPrice);

        List<Item> cartItems = SharedPrefManager.loadCart(this);

        // Build display list and calculate total
        List<String> displayList = new ArrayList<>();
        double totalPrice = 0;

        for (Item item : cartItems) {
            displayList.add(item.toDisplayString());
            try {
                totalPrice += Double.parseDouble(item.getPrice());
            } catch (NumberFormatException e) {
                e.printStackTrace(); // skip invalid prices
            }
        }

        txtTotalPrice.setText(String.format("Total: $%.2f", totalPrice));

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayList);
        cartList.setAdapter(adapter);

        btnCheckout.setOnClickListener(v -> {
            SharedPrefManager.clearCart(this);
            Toast.makeText(this, "Order placed!", Toast.LENGTH_SHORT).show();
            displayList.clear();
            adapter.notifyDataSetChanged();
            txtTotalPrice.setText("Total: $0.00");
        });
    }
}
