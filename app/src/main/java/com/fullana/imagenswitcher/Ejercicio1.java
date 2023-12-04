package com.fullana.imagenswitcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.fullana.imagenswitcher.databinding.ActivityEjercicio1Binding;

import java.util.ArrayList;
import java.util.List;

public class Ejercicio1 extends AppCompatActivity {

    protected ActivityEjercicio1Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEjercicio1Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.imageSwitch.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                return imageView;
            }
        });
        binding.recycler1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        binding.recycler1.setAdapter(new AdapterEjercicio1(binding.recycler1,binding.imageSwitch,getBaseContext()));

    }

}
class AdapterEjercicio1 extends RecyclerView.Adapter<AdapterEjercicio1.ViewHolderP>{

    protected ArrayList<Integer> list;

    public AdapterEjercicio1(RecyclerView recyclerView, ImageSwitcher imageSwitcher, Context context) {
        list = ContenedorDeImagenes.container();
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(context, recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                imageSwitcher.setImageResource(list.get(position));
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    @NonNull
    @Override
    public ViewHolderP onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_ejercicio1, parent, false);
        return new ViewHolderP(view);    }

    @Override
    public void onBindViewHolder(@NonNull AdapterEjercicio1.ViewHolderP holder, int position) {
        holder.imageView.setImageResource(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolderP extends RecyclerView.ViewHolder {

        protected ImageView imageView;

        public ViewHolderP(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);


        }
    }
}
class ContenedorDeImagenes{
    public static ArrayList<Integer> container(){
        ArrayList<Integer> list = new ArrayList<>();

        list.add(R.drawable.image1);
        list.add(R.drawable.image2);
        list.add(R.drawable.image3);
        list.add(R.drawable.image4);
        list.add(R.drawable.image5);
        list.add(R.drawable.image6);
        list.add(R.drawable.image7);
        list.add(R.drawable.image8);
        list.add(R.drawable.image9);
        list.add(R.drawable.image10);

        return list;
    }
}