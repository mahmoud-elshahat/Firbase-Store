package mahmoudahmed.com.store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    ArrayList<Product>products;
    ListView productsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        productsList=(ListView) findViewById(R.id.products_list);

        products = new ArrayList<>();

        mDatabase = FirebaseDatabase.getInstance().getReference().child("products");

        mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    Product product= postSnapshot.getValue(Product.class);
                    products.add(product);
                }
                
                //adapter
                ProductsAdapter adapter = new ProductsAdapter(HomeActivity.this, products);

                //attach
                productsList.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });





    }


    public void addProduct(View view)
    {
        Intent addProductIntent =new Intent(HomeActivity.this,AddProductActivity.class);
        startActivity(addProductIntent);
    }
}
