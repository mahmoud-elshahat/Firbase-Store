package mahmoudahmed.com.store;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }





    public void openLogin(View view) {
        Intent login =new Intent (this , MainActivity.class);
        startActivity(login);
    }

    public void Register(View view) {

    }
}
