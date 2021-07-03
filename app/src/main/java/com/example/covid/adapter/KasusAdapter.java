package com.example.covid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.covid.R;
import com.example.covid.model.kasus.KasusContentItem;

import java.util.ArrayList;


public class KasusAdapter extends RecyclerView.Adapter<KasusAdapter.viewHolder> {

    private ArrayList<KasusContentItem> kasusContentItems = new ArrayList<>();

    public KasusAdapter(Context context){
    }

    public void setData(ArrayList<KasusContentItem> items){
        kasusContentItems.clear();
        kasusContentItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public KasusAdapter.viewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_kasus, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull KasusAdapter.viewHolder holder, int position) {
        holder.tv_tanggal.setText(kasusContentItems.get(position).getTanggal());
        holder.tv_konfirmasi.setText(String.valueOf(kasusContentItems.get(position).getConfirmationDiisolasi()));
        holder.tv_sembuh.setText(String.valueOf(kasusContentItems.get(position).getConfirmationSelesai()));
        holder.tv_meninggal.setText(String.valueOf(kasusContentItems.get(position).getConfirmationMeninggal()));
    }

    @Override
    public int getItemCount() {
        return kasusContentItems.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView tv_tanggal, tv_konfirmasi, tv_sembuh, tv_meninggal;
        CardView cvItem;
        public viewHolder(@NonNull  View itemView) {
            super(itemView);
            tv_tanggal = itemView.findViewById(R.id.itemlist_kasus_tanggal);
            tv_konfirmasi = itemView.findViewById(R.id.itemlist_kasus_konfirmasi);
            tv_sembuh = itemView.findViewById(R.id.itemlist_kasus_sembuh);
            tv_meninggal = itemView.findViewById(R.id.itemlist_kasus_meninggal);

            cvItem = itemView.findViewById(R.id.itemlist_kasus_cv);
        }
    }
}
