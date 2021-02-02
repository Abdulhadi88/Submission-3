package com.example.submission2.fragmen;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
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
import com.example.submission2.adapter.TvViewModel;
import com.example.submission2.model.ListMovie;
import com.example.submission2.model.WatchModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class TvFragment extends Fragment {
    private ListMovieAdapter mTvAdapter;
    private TvViewModel mtvViewModel;

    public static TvFragment newInstance(){
        return new TvFragment();
    }


    public TvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tv, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.recTv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(view.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        mtvViewModel = ViewModelProviders.of(this).get(TvViewModel.class);
        mtvViewModel.addTvModel(getResources().getString(R.string.one_punch),getString(R.string.desc_one_punch),R.drawable.poster_saitama);
        mtvViewModel.addTvModel(getResources().getString(R.string.kny),getString(R.string.desc_kny),R.drawable.poster_demon_slayer);
        mtvViewModel.addTvModel(getResources().getString(R.string.dragon),getString(R.string.desc_dragon),R.drawable.poster_dragon_ball);
        mtvViewModel.addTvModel(getResources().getString(R.string.bnha),getString(R.string.desc_bnha),R.drawable.poster_mha);
        mtvViewModel.addTvModel(getResources().getString(R.string.narutosh),getString(R.string.desc_narutosh),R.drawable.poster_naruto_shipudden);
        mtvViewModel.addTvModel(getResources().getString(R.string.fairy_tail),getString(R.string.desc_fairy_tail),R.drawable.poster_fairytail);
        mtvViewModel.addTvModel(getResources().getString(R.string.gumbal),getString(R.string.desc_gumbal),R.drawable.poster_gumbal);
        mtvViewModel.addTvModel(getResources().getString(R.string.phineas),getString(R.string.desc_phineas),R.drawable.poster_phineas);
        mtvViewModel.addTvModel(getResources().getString(R.string.gravity_falls),getString(R.string.desc_gravity_falls),R.drawable.poster_gravity_falls);
        mtvViewModel.addTvModel(getResources().getString(R.string.regular_show),getString(R.string.desc_regular_show),R.drawable.poster_regular);
        mtvViewModel.addTvModel(getResources().getString(R.string.adventure),getString(R.string.desc_adventure),R.drawable.poster_adventure_time);



        mTvAdapter = new ListMovieAdapter(view.getContext(), mtvViewModel.getList());
        recyclerView.setAdapter(mTvAdapter);
        recyclerView.setHasFixedSize(true);

        mTvAdapter.SetOnItemClickListener(new ListMovieAdapter.OnitemClicklistener() {
            @Override
            public void onItemClick(View view, int position, WatchModel model) {
                Intent intnya2 = new Intent(view.getContext(), Detail.class);
                intnya2.putExtra(ListMovie.SELECTED_MOVIE,model);
                startActivity(intnya2);
            }
        });
    }
}
