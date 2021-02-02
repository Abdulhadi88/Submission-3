package com.example.submission2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.submission2.model.ListMovie;
import com.example.submission2.model.WatchModel;

public class Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        TextView tvjudul = findViewById(R.id.judul_dtl);
        TextView tvdetail = findViewById(R.id.deskripsi_dtl);
        ImageView imgposter = findViewById(R.id.poster_dtl);

        WatchModel watchModel = getIntent().getParcelableExtra(ListMovie.SELECTED_MOVIE);
        tvjudul.setText(watchModel.getJudul());
        tvdetail.setText(watchModel.getDesc());
        imgposter.setImageResource(watchModel.getPoster());

        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
