package com.fullana.imagenswitcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.fullana.imagenswitcher.databinding.ActivityEjercicio3Binding;

import java.util.ArrayList;

public class Ejercicio3 extends AppCompatActivity {
    ActivityEjercicio3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEjercicio3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        binding.recycler.setAdapter(new RecyclerAdapter());
    }
}
class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolderEj> {

    ArrayList<Resenya> list = repo();

    private ArrayList<Resenya> repo() {
        ArrayList<Resenya> list = new ArrayList<>();
        list.add(new Resenya(R.drawable.image1,"Antico Caffè Greco","St.Italy,Rome"));
        list.add(new Resenya(R.drawable.image2,"Antico Caffè Greco","St.Italy,Rome"));
        return list;
    }

    @NonNull
    @Override
    public ViewHolderEj onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_ejercicio3, parent, false);
        return new ViewHolderEj(view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEj holder, int position) {
        crearResnya(list.get(position),holder);
    }

    private void crearResnya(Resenya resenya, ViewHolderEj holder) {
        holder.imageView.setImageResource(resenya.imagen);
        holder.titulo.setText(resenya.titulo);
        holder.location.setText(resenya.localizacion);
    }

    static class ViewHolderEj extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titulo,rating,location;
        RatingBar ratingBar;
        public ViewHolderEj(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView4);
            titulo = itemView.findViewById(R.id.titulo);
            rating = itemView.findViewById(R.id.puntuacion);
            location = itemView.findViewById(R.id.location);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            ratingBar.setRating(5);
            ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float r, boolean fromUser) {
                    rating.setText(String.valueOf(r));
                }
            });
        }
    }
}
class Resenya{
    int imagen;
    String titulo,localizacion;

    public Resenya(int imagen, String titulo, String localizacion) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.localizacion = localizacion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }
}