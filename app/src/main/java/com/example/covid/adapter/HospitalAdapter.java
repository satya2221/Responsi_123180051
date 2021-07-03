package com.example.covid.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.R;
import com.example.covid.model.hospital.HospitalDataItem;

import java.util.ArrayList;

public class HospitalAdapter extends RecyclerView.Adapter<HospitalAdapter.viewHolder> {

    private ArrayList<HospitalDataItem> hospitalDataItems = new ArrayList<>();

    public HospitalAdapter(Context context){}

    public void setData(ArrayList<HospitalDataItem> items){
        hospitalDataItems.clear();
        hospitalDataItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HospitalAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_hospital, parent, false);
        return new HospitalAdapter.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalAdapter.viewHolder holder, int position) {
        holder.tv_name.setText(hospitalDataItems.get(position).getNama());
        holder.tv_alamat.setText(hospitalDataItems.get(position).getAlamat());

        holder.btn_maps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri gmmIntentUri = Uri.parse("geo:" + hospitalDataItems.get(position).getLongitude() + "," + hospitalDataItems.get(position).getLatitude() + "?q=" + Uri.encode(hospitalDataItems.get(position).getNama()));
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                mapIntent.setPackage("com.google.android.apps.maps");
                v.getContext().startActivity(mapIntent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return hospitalDataItems.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_alamat;
        Button btn_maps;
        CardView cvItem;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.itemlist_hospital_name);
            tv_alamat = itemView.findViewById(R.id.itemlist_hospital_alamat);
            btn_maps = itemView.findViewById(R.id.itemlist_hospital_maps);

            cvItem = itemView.findViewById(R.id.itemlist_hospital_cv);
        }
    }
}
