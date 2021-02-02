package com.example.submission2.adapter;

import android.content.Intent;

import androidx.lifecycle.ViewModel;

import com.example.submission2.model.WatchModel;

import java.util.ArrayList;

public class TvViewModel extends ViewModel {
    ArrayList<WatchModel> list = new ArrayList<>();

    public void addTvModel(String judul, String desc, Integer poster){
        this.list.add(new WatchModel(judul, desc, poster));
    }

    public ArrayList<WatchModel> getList(){
        return list;
    }
}
