package umn.ac.id.sangjuara_uas.TampilanMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import umn.ac.id.sangjuara_uas.ProfilActivity;
import umn.ac.id.sangjuara_uas.R;
import umn.ac.id.sangjuara_uas.TampilanProduct.TampilanProductActivity;
import umn.ac.id.sangjuara_uas.payment.CheckoutActivity;

public class TampilanKeduaActivity extends AppCompatActivity {
    private ImageView setKursi,setLemari,setSofa,setProfil,setShop,btnSwipe;
    private ViewPager2 viewPager2;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilan_kedua);


        btnSwipe = findViewById(R.id.btnswipe);
        viewPager2 = findViewById(R.id.viewPagerImageSlider);
        setKursi = findViewById(R.id.setKursi);
        setLemari = findViewById(R.id.setLemari);
        setSofa = findViewById(R.id.setSofa);
        setProfil = findViewById(R.id.setProfil);
        setShop = findViewById(R.id.setShop);


        List<SliderItem> sliderItems = new ArrayList<>();
        sliderItems.add(new SliderItem(R.drawable.item_meja));
        sliderItems.add(new SliderItem(R.drawable.item_meja_2));
        sliderItems.add(new SliderItem(R.drawable.item_meja_3));

        btnSwipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.btnswipe:
                        startActivity(new Intent(TampilanKeduaActivity.this, CheckoutActivity.class));
                        break;

                }
            }
        });

        setKursi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.setKursi:
                        startActivity(new Intent(TampilanKeduaActivity.this, TampilanPertamaActivity.class));
                        break;

                }
            }
        });
        setSofa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.setSofa:
                        startActivity(new Intent(TampilanKeduaActivity.this, TampilanKeempatActivity.class));
                        break;

                }
            }
        });
        setProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.setProfil:
                        startActivity(new Intent(TampilanKeduaActivity.this, ProfilActivity.class));
                        break;

                }
            }
        });
        setShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.setShop:
                        startActivity(new Intent(TampilanKeduaActivity.this, TampilanProductActivity.class));
                        break;

                }
            }
        });
        setLemari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.setLemari:
                        startActivity(new Intent(TampilanKeduaActivity.this, TampilanKeempatActivity.class));
                        break;

                }
            }
        });


        viewPager2.setAdapter(new SliderAdapter(sliderItems, viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);











        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
    }
}




