package com.example.submission2.fragmen;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.submission2.Detail;
import com.example.submission2.R;
import com.example.submission2.adapter.ListMovieAdapter;
import com.example.submission2.adapter.MovieViewModel;
import com.example.submission2.model.ListMovie;
import com.example.submission2.model.WatchModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {
    private ListMovieAdapter listMovieAdapter;
    private MovieViewModel movieViewModel;

    public static MovieFragment newInstance(){
        return new MovieFragment();
    }


    public MovieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recMov);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        movieViewModel = ViewModelProviders.of(this).get(MovieViewModel.class);
        movieViewModel.addMovieModel(getResources().getString(R.string.i_want_to_eat_your_pankreas), getString(R.string.desc_pankreas),R.drawable.poster_pankreas);
        movieViewModel.addMovieModel(getResources().getString(R.string.naruto), getString(R.string.desc_naruto),R.drawable.poster_naruto);
        movieViewModel.addMovieModel(getResources().getString(R.string.kimi_no_nawa), getString(R.string.desc_kimi_no_nawa),R.drawable.poster_yourname);
        movieViewModel.addMovieModel(getResources().getString(R.string.boruto), getString(R.string.desc_boruto),R.drawable.poster_boruto);
        movieViewModel.addMovieModel(getResources().getString(R.string.frozen_ii), getString(R.string.desc_frozen),R.drawable.poster_frozen);
        movieViewModel.addMovieModel(getResources().getString(R.string.ralph), getString(R.string.desc_ralph),R.drawable.poster_ralph);
        movieViewModel.addMovieModel(getResources().getString(R.string.httyd), getString(R.string.desc_httyd),R.drawable.poster_how_to_train);
        movieViewModel.addMovieModel(getResources().getString(R.string.spiderman), getString(R.string.desc_spderman),R.drawable.poster_spiderman);
        movieViewModel.addMovieModel(getResources().getString(R.string.lego), getString(R.string.desc_lego),R.drawable.poster_lego_movie);

        listMovieAdapter = new ListMovieAdapter(view.getContext(),movieViewModel.getModels());
        recyclerView.setAdapter(listMovieAdapter);
        recyclerView.setHasFixedSize(true);

        listMovieAdapter.SetOnItemClickListener(new ListMovieAdapter.OnitemClicklistener(){
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent intnya = new Intent(view.getContext(), Detail.class);
                intnya.putExtra(ListMovie.SELECTED_MOVIE,model);
                startActivity(intnya);
            }
        });


    }

//    @Override
//    public void onClick(View v) {
//        switch (v.getId()){
//            /*case*/
//        }
//    }
}
