package umn.ac.id.sangjuara_uas.TampilanProduct;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import umn.ac.id.sangjuara_uas.R;
import umn.ac.id.sangjuara_uas.TampilanMenu.SliderItem;
import umn.ac.id.sangjuara_uas.TampilanMenu.TampilanKeduaActivity;
import umn.ac.id.sangjuara_uas.TampilanMenu.TampilanPertamaActivity;
import umn.ac.id.sangjuara_uas.payment.CheckoutActivity;

public class TampilanProductActivity extends AppCompatActivity {
    private ImageView btnadd;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_1);


        btnadd = findViewById(R.id.btnadd);


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btnadd:
                        startActivity(new Intent(TampilanProductActivity.this, CheckoutActivity.class));
                        break;

                }
            }
        });
    }
}
