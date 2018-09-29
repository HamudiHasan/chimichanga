package com.uiutesseract.nidavellir.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.uiutesseract.nidavellir.R;
import com.uiutesseract.nidavellir.model.SampleModel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private List<SampleModel> arrayList = new ArrayList<SampleModel>();
    private Context context;
    private int lastPosition = -1;


    public RecyclerAdapter(List<SampleModel> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recyler_view, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        setAnimation(holder.container, position);

        SampleModel model = arrayList.get(position);
        holder.tvName.setText(model.strName);






    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View container;
        TextView tvName;


        public ViewHolder(View itemView) {
            super(itemView);

            container = itemView.findViewById(R.id.container_item_rv);

            tvName = itemView.findViewById(R.id.tv_name_item_rv);


        }
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_up);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }



}
