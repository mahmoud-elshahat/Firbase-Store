package mahmoudahmed.com.store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    ListView productsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        productsList=(ListView) findViewById(R.id.products_list);


        //data
        ArrayList<Product> products = new ArrayList<Product>();

        Product fake=new Product("milk", "15","5");
        Product fake2=new Product("wqwqwq", "55","12");
        products.add(fake);
        products.add(fake2);

        //adapter
        ProductsAdapter adapter = new ProductsAdapter(this, products);

        //attach
        productsList.setAdapter(adapter);

    }


    public void addProduct(View view)
    {
        Intent addProductIntent =new Intent(HomeActivity.this,AddProductActivity.class);
        startActivity(addProductIntent);
    }
}
