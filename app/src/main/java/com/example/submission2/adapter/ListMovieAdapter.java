package com.example.submission2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.submission2.R;
import com.example.submission2.model.WatchModel;

import java.util.ArrayList;

public class ListMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mcontext;
    private ArrayList<WatchModel> modelList;

    private OnitemClicklistener mItemClickListener;

    public ListMovieAdapter(Context mcontext, ArrayList<WatchModel> modelList){
        this.modelList = modelList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_layout,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            final WatchModel model = getitem(position);
            ViewHolder genericViewHolder = (ViewHolder) holder;

            genericViewHolder.judul.setText(model.getJudul());

            if (model.getDesc().length()>50){
                genericViewHolder.desc.setText(model.getDesc().substring(0,49)+"...");
            }else {
                genericViewHolder.desc.setText(model.getJudul());
            }

            genericViewHolder.poster.setImageResource(model.getPoster());
        }
    }

    private WatchModel getitem(int position) {
        return modelList.get(position);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public void SetOnItemClickListener(OnitemClicklistener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }


    public interface OnitemClicklistener{
        void onItemClick(View view, int position, WatchModel model);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       private TextView judul, desc;
       private ImageView poster;

        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            judul = itemView.findViewById(R.id.judul_flm);
            desc = itemView.findViewById(R.id.deskripsi_flm);
            poster = itemView.findViewById(R.id.poster_flm);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mItemClickListener.onItemClick(itemView,getAdapterPosition(), modelList.get(getAdapterPosition()));
                }
            });
        }
    }

}
