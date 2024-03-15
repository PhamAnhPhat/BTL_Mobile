//package com.example.oucinema.adapter;
//
//import android.content.Context;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//
//import com.example.oucinema.model.RapPhim;
//
//import java.util.ArrayList;
//
//public class TheaterAdapter extends RecyclerView.Adapter<TheaterAdapter.TheaterViewHolder> {
//    Context context;
//    ArrayList<RapPhim> danhSachRapPhim;
//
//    public TheaterAdapter(Context context, ArrayList<RapPhim> danhSachRapPhim) {
//        this.context = context;
//        this.danhSachRapPhim = danhSachRapPhim;
//    }
//
//    @Override
//    public int getCount() {
//        return danhSachRapPhim.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return danhSachRapPhim.get(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return i;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        return null;
//    }
//}
