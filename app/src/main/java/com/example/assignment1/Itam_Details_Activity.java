package com.example.assignment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class Itam_Details_Activity extends AppCompatActivity {
    private Button btnAddToCart;
    private TextView txtActivity4ItemName, txtActivity4ItemTime, txtActivity4ItemTotalqunt, txtHowToMake, txtFromWhatIt, txtActivity4Ite;
    private ImageView imgItemLogod;
    private int selectedImageResId = R.drawable.placeholder; // default fallback image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itam_details);

        // Initialize views
        btnAddToCart = findViewById(R.id.btnAddToCart);
        txtActivity4ItemName = findViewById(R.id.txtActivity4ItemName);
        txtActivity4ItemTime = findViewById(R.id.txtActivity4ItemProtein);
        imgItemLogod = findViewById(R.id.imgItemLogod);
        txtActivity4ItemTotalqunt = findViewById(R.id.txtActivity4ItemTotalqunt);
        txtFromWhatIt = findViewById(R.id.txtFromWhatIt);
        txtHowToMake = findViewById(R.id.txtHowToMake);
        txtActivity4Ite = findViewById(R.id.txtActivity4Ite);

        Intent intent = getIntent();
        String itemName = intent.getStringExtra("ITEM_NAME");
        txtActivity4ItemName.setText(itemName);

        insertDataFromFood(itemName); // sets details + image + selectedImageResId

        btnAddToCart.setOnClickListener(view -> {
            int currentQty = Integer.parseInt(txtActivity4ItemTotalqunt.getText().toString());

            if (currentQty <= 0) {
                Toast.makeText(this, "Item is out of stock!", Toast.LENGTH_SHORT).show();
                return;
            }

            String itemNames = txtActivity4ItemName.getText().toString();
            List<String> cart = SharedPrefManager.loadCart(Itam_Details_Activity.this);
            cart.add(itemNames);
            SharedPrefManager.saveCart(Itam_Details_Activity.this, cart);
            Toast.makeText(this, "Added to cart", Toast.LENGTH_SHORT).show();

            // Save cart and reduce available quantity
            SharedPrefManager.saveCart(Itam_Details_Activity.this, cart);
            txtActivity4ItemTotalqunt.setText(String.valueOf(currentQty - 1));
            Toast.makeText(this, "Item added to cart", Toast.LENGTH_SHORT).show();
        });
    }



    private void insertDataFromFood(String name) {
        switch (name) {

            case "Avocado Toast with PoachedEgg":
                txtActivity4ItemTime.setText("65");
                txtActivity4ItemTotalqunt.setText("20 ");
                txtFromWhatIt.setText("Ingredients:\n1 slice whole-grain bread (70 calories)\n½ avocado, mashed (120 calories)\n1 poached egg (70 calories)\nSalt and pepper to taste\nOptional: sprinkle of red pepper flakes or chives");
                txtHowToMake.setText("Instructions:\n1. Toast the bread.\n2. Spread the mashed avocado on the toast.\n3. Top with a poached egg.\n4. Season with salt, pepper, and optional toppings.");
                imgItemLogod.setImageResource(R.drawable.eggsandavocado);
                break;

            case "Greek Yogurt Parfait":
                txtActivity4ItemTime.setText("25");
                txtActivity4ItemTotalqunt.setText("25");
                txtFromWhatIt.setText("Ingredients:\n1 cup Greek yogurt (plain, non-fat) (100 calories)\n½ cup mixed berries (35 calories)\n¼ cup granola (100 calories)\n1 tbsp honey (20 calories)");
                txtHowToMake.setText("Instructions:\n1. Layer Greek yogurt, berries, granola, and honey in a bowl or glass.\n2. Repeat layers if desired.");
                imgItemLogod.setImageResource(R.drawable.ugert);
                break;

            case "Oatmeal with Banana and Almonds":
                txtActivity4ItemTime.setText("10 ");
                txtActivity4ItemTotalqunt.setText("32");
                txtFromWhatIt.setText("Ingredients:\n½ cup rolled oats (150 calories)\n1 cup water or almond milk (30 calories for almond milk)\n½ banana, sliced (50 calories)\n1 tbsp almond butter (90 calories)\nOptional: sprinkle of cinnamon or chia seeds (5 calories)");
                txtHowToMake.setText("Instructions:\n1. Cook oats with water or almond milk.\n2. Top with banana slices and almond butter.\n3. Add optional toppings like cinnamon or chia seeds.");
                imgItemLogod.setImageResource(R.drawable.milkshofan);
                break;

            case "Vegetable and Cheese Omelette":
                txtActivity4ItemTime.setText("10 ");
                txtActivity4ItemTotalqunt.setText("18 ");
                txtFromWhatIt.setText("Ingredients:\n2 large eggs (140 calories)\n¼ cup chopped bell pepper (10 calories)\n¼ cup spinach (5 calories)\n1 tbsp shredded cheese (30 calories)\nSalt and pepper to taste");
                txtHowToMake.setText("Instructions:\n1. Whisk eggs with salt and pepper.\n2. Pour eggs into a heated, lightly oiled pan, and add vegetables.\n3. Cook until almost set, then add cheese and fold the omelette.");
                imgItemLogod.setImageResource(R.drawable.eggspizza);
                break;


            case "Baked Apples with Cinnamon":
                txtActivity4ItemTime.setText("20 Min");
                txtActivity4ItemTotalqunt.setText("12");
                txtFromWhatIt.setText("Ingredients:\n1 medium apple (80 calories)\n1 tsp cinnamon (0 calories)\n1 tsp honey (20 calories)\nOptional: a few chopped walnuts or almonds (20 calories)");
                txtHowToMake.setText("Instructions:\n1. Preheat oven to 350°F (175°C).\n2. Core the apple and place it in a baking dish.\n3. Sprinkle with cinnamon and drizzle with honey.\n4. Bake for 15-20 minutes until tender. Top with nuts if desired.");
                imgItemLogod.setImageResource(R.drawable.hunny);
                break;

            case "Chia Pudding with Almond Milk and Fruit":
                txtActivity4ItemTime.setText("50");
                txtActivity4ItemTotalqunt.setText("13");
                txtFromWhatIt.setText("Ingredients:\n1 tbsp chia seeds (60 calories)\n½ cup unsweetened almond milk (15 calories)\n½ cup fresh fruit (berries or sliced banana) (35 calories)\nOptional: 1 tsp maple syrup or honey (20 calories)");
                txtHowToMake.setText("Instructions:\n1. Combine chia seeds and almond milk in a bowl or jar. Stir well.\n2. Refrigerate for at least 2 hours or overnight to let the chia seeds thicken.\n3. Top with fruit and optional sweetener before serving.");
                imgItemLogod.setImageResource(R.drawable.asalmuna);
                break;

            case "Chocolate-Dipped Strawberries":
                txtActivity4ItemTime.setText("15");
                txtActivity4ItemTotalqunt.setText("11");
                txtFromWhatIt.setText("Ingredients:\n6 medium strawberries (25 calories)\n1 oz dark chocolate (70% cacao or higher) (90 calories)");
                txtHowToMake.setText("Instructions:\n1. Melt the dark chocolate in a microwave-safe bowl in 15-second intervals, stirring until smooth.\n2. Dip each strawberry halfway into the chocolate and place on a parchment-lined plate.\n3. Refrigerate for 10-15 minutes until the chocolate hardens.");
                imgItemLogod.setImageResource(R.drawable.chocomuna);
                break;

            case "Banana Nice Cream":
                txtActivity4ItemTime.setText("15");
                txtActivity4ItemTotalqunt.setText("14");
                txtFromWhatIt.setText("Ingredients:\n1 medium banana, sliced and frozen (90 calories)\n1 tsp peanut butter (30 calories)\nOptional: a dash of cinnamon or cocoa powder (5 calories)");
                txtHowToMake.setText("Instructions:\n1. Blend the frozen banana in a food processor until smooth and creamy.\n2. Add peanut butter and optional cinnamon or cocoa powder, and blend again.\n3. Serve immediately as a soft-serve ice cream.");
                imgItemLogod.setImageResource(R.drawable.cupcakemuna);
                break;


            case "Mediterranean Chickpea Salad":
                txtActivity4ItemTime.setText("35");
                txtActivity4ItemTotalqunt.setText("24");
                txtFromWhatIt.setText("Ingredients:\n1 cup canned chickpeas, drained and rinsed (120 calories)\n½ cup cucumber, diced (8 calories)\n½ cup cherry tomatoes, halved (15 calories)\n¼ cup red onion, finely chopped (10 calories)\n¼ cup crumbled feta cheese (50 calories)\n1 tbsp olive oil (40 calories)\n1 tbsp lemon juice (5 calories)\nSalt, pepper, and fresh parsley to taste");
                txtHowToMake.setText("Instructions:\n1. In a large bowl, combine chickpeas, cucumber, cherry tomatoes, red onion, and feta cheese.\n2. Drizzle with olive oil and lemon juice.\n3. Season with salt, pepper, and parsley, and toss well.");
                imgItemLogod.setImageResource(R.drawable.sonemuna);
                break;

            case "Kale and Quinoa Salad":
                txtActivity4ItemTime.setText("10");
                txtActivity4ItemTotalqunt.setText("29");
                txtFromWhatIt.setText("Ingredients:\n1 cup kale, chopped (33 calories)\n½ cup cooked quinoa (110 calories)\n¼ avocado, diced (60 calories)\n¼ cup shredded carrots (10 calories)\n1 tbsp sunflower seeds (45 calories)\n1 tbsp olive oil (40 calories)\n1 tbsp apple cider vinegar (0 calories)\nSalt and pepper to taste");
                txtHowToMake.setText("Instructions:\n1. Massage the chopped kale with a pinch of salt to soften it.\n2. In a bowl, combine kale, cooked quinoa, avocado, shredded carrots, and sunflower seeds.\n3. Drizzle with olive oil and apple cider vinegar, and toss to mix.");
                imgItemLogod.setImageResource(R.drawable.stwomuna);
                break;

            case "Spinach, Apple, and Walnut Salad":
                txtActivity4ItemTime.setText("53");
                txtActivity4ItemTotalqunt.setText("21");
                txtFromWhatIt.setText("Ingredients:\n2 cups spinach leaves (14 calories)\n½ apple, thinly sliced (30 calories)\n¼ cup walnuts, chopped (100 calories)\n1 tbsp crumbled goat cheese (30 calories)\n1 tbsp balsamic vinaigrette (40 calories)");
                txtHowToMake.setText("Instructions:\n1. In a bowl, combine spinach, apple slices, walnuts, and goat cheese.\n2. Drizzle with balsamic vinaigrette and toss to coat.");
                imgItemLogod.setImageResource(R.drawable.sthreemuna);
                break;

            case "Mexican Black Bean Salad":
                txtActivity4ItemTime.setText("23");
                txtActivity4ItemTotalqunt.setText("18");
                txtFromWhatIt.setText("Ingredients:\n½ cup black beans, drained and rinsed (60 calories)\n½ cup corn kernels (60 calories)\n½ cup diced bell pepper (10 calories)\n¼ cup cherry tomatoes, halved (8 calories)\n1 tbsp chopped cilantro (0 calories)\n1 tbsp lime juice (5 calories)\n1 tsp olive oil (40 calories)\nSalt, pepper, and chili powder to taste");
                txtHowToMake.setText("Instructions:\n1. In a bowl, combine black beans, corn, bell pepper, cherry tomatoes, and cilantro.\n2. Drizzle with lime juice and olive oil.\n3. Season with salt, pepper, and chili powder, and toss to mix.");
                imgItemLogod.setImageResource(R.drawable.sfourmuna);
                break;


            default:
                txtFromWhatIt.setText("No details available.");
                txtHowToMake.setText("");
                imgItemLogod.setImageResource(R.drawable.placeholder);
                break;
        }
    }
}
