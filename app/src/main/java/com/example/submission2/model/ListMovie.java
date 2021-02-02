package com.example.submission2.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.submission2.R;
import com.example.submission2.adapter.ListMovieAdapter;

import java.util.ArrayList;

public class ListMovie extends AppCompatActivity {
    private RecyclerView recyclerViewc;
    private ListMovieAdapter movieAdapter;

    private ArrayList<WatchModel> list = new ArrayList<>();
    public static final String SELECTED_MOVIE = "selected_movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_movie);
        findView();
        setAdapter();
    }

    private void setAdapter() {
        list.add(new WatchModel(getResources().getString(R.string.i_want_to_eat_your_pankreas), getString(R.string.desc_pankreas),R.drawable.poster_pankreas));
        list.add(new WatchModel(getResources().getString(R.string.naruto), getString(R.string.desc_naruto),R.drawable.poster_naruto));
        list.add(new WatchModel(getResources().getString(R.string.boruto), getString(R.string.desc_boruto),R.drawable.poster_boruto));
        list.add(new WatchModel(getResources().getString(R.string.kimi_no_nawa), getString(R.string.desc_kimi_no_nawa),R.drawable.poster_yourname));

    }

    private void findView() {
        recyclerViewc = findViewById(R.id.rescycler);

    }
}
