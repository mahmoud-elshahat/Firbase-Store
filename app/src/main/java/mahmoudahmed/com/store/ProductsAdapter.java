package mahmoudahmed.com.store;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by MahmoudAhmed on 4/9/2018.
 */

public class ProductsAdapter extends ArrayAdapter<Product> {

    public ProductsAdapter(Context context, ArrayList<Product> products) {
        super(context, 0, products);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Product product = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_product, parent, false);
        }

        TextView name,price , quantity;

        name = convertView.findViewById(R.id.product_name);
        price = convertView.findViewById(R.id.product_price);
        quantity = convertView.findViewById(R.id.product_quantity);


        name.setText(product.getName());
        price.setText("Price = "+product.getPrice());
        quantity.setText("Quantity = "+product.getQuantity());


        return convertView;
    }

}
