package umn.ac.id.sangjuara_uas.payment;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import umn.ac.id.sangjuara_uas.R;

public class CheckoutActivity extends AppCompatActivity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        TextView Harga = findViewById(R.id.totalharga);

        SharedPreferences sp = getSharedPreferences("your_prefs", Activity.MODE_PRIVATE);
        int myIntValue = sp.getInt("your_int_key", 0);

        Harga.setText(myIntValue);
    }

}

