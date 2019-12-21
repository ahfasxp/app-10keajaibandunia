package com.ahfasxp.kd;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_IMG = "extra_img";
    public static final String EXTRA_NAME = "extra_name" ;
    public static final String EXTRA_DETAIL = "extra_detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imgPhoto = findViewById(R.id.img_photo);
        TextView tvName = findViewById(R.id.tv_name);
        TextView tvDetail = findViewById(R.id.tv_detail);

        int photo = getIntent().getIntExtra(EXTRA_IMG, 0);
        String name = getIntent().getStringExtra(EXTRA_NAME);
        String detail = getIntent().getStringExtra(EXTRA_DETAIL);

        imgPhoto.setImageResource(photo);
        tvName.setText(name);
        tvDetail.setText(detail);
    }
}
