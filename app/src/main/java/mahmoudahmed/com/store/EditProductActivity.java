package mahmoudahmed.com.store;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class EditProductActivity extends AppCompatActivity {

    String priceValue,quantityValue,nameValue,id;

    private DatabaseReference mDatabase;


    TextInputEditText price,quantity,name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_product);


        mDatabase = FirebaseDatabase.getInstance().getReference();



        nameValue=getIntent().getExtras().getString("name");
        quantityValue=getIntent().getExtras().getString("quantity");
        priceValue=getIntent().getExtras().getString("price");

        id=getIntent().getExtras().getString("id");


        name=(TextInputEditText) findViewById(R.id.update_name);
        price=(TextInputEditText)findViewById(R.id.update_price);
        quantity=(TextInputEditText)findViewById(R.id.update_quantity);


        name.setText(nameValue);
        quantity.setText(quantityValue);
        price.setText(priceValue);


    }




    public void update(View view) {
        String nameText,priceText,quantityText;

        nameText=name.getText().toString();
        priceText=price.getText().toString();
        quantityText=quantity.getText().toString();

        Product product=new Product(nameText,priceText,quantityText);
        product.setId(id);

        mDatabase.child("products").child(id).setValue(product);

        onBackPressed();
    }
}
