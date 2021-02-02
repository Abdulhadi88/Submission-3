package com.example.submission2.adapter;

import androidx.lifecycle.ViewModel;

import com.example.submission2.model.WatchModel;

import java.util.ArrayList;

public class MovieViewModel extends ViewModel {
    private ArrayList<WatchModel> models = new ArrayList<>();

    public void addMovieModel(String judul, String desc, Integer poster){
        this.models.add(new WatchModel(judul,desc,poster));
    }

    public ArrayList<WatchModel> getModels(){
        return models;
    }
}
