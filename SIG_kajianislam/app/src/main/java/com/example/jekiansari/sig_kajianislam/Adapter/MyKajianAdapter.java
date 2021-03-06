package com.example.jekiansari.sig_kajianislam.Adapter;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jekiansari.sig_kajianislam.DetailMyKajianActivity;
import com.example.jekiansari.sig_kajianislam.Model.LocationModel;
import com.example.jekiansari.sig_kajianislam.R;

import java.util.ArrayList;

public class MyKajianAdapter extends RecyclerView.Adapter<MyKajianAdapter.MyKajianViewHolder> {

    private ArrayList<LocationModel> datas;

    public MyKajianAdapter(ArrayList<LocationModel> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public MyKajianViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_row_mykajian, parent, false);
        return new MyKajianViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyKajianViewHolder holder, final int position) {
        holder.txtKajian.setText(datas.get(position).getNamakajian());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailMyKajianActivity.class);
                intent.putExtra("id_kajian",datas.get(position).getIdkajian());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    public class MyKajianViewHolder extends RecyclerView.ViewHolder {

        public TextView txtKajian;

        public MyKajianViewHolder(View itemView) {
            super(itemView);
            txtKajian = itemView.findViewById(R.id.txtNamaKajian);
        }
    }
}
