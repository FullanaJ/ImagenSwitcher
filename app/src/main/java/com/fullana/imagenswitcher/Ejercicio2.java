package com.fullana.imagenswitcher;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fullana.imagenswitcher.databinding.ActivityEjercicio2Binding;

import java.util.ArrayList;

public class Ejercicio2 extends AppCompatActivity {

    protected ActivityEjercicio2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEjercicio2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.recycler.setLayoutManager(new GridLayoutManager(this,2,GridLayoutManager.VERTICAL,false));
        Ejercicio2Adapter ejercicio2Adapter = new Ejercicio2Adapter();
        ejercicio2Adapter.setManager(getSupportFragmentManager());
        binding.recycler.setAdapter(ejercicio2Adapter);
        binding.toolbar2.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                startActivity(new Intent(getApplication(),ComparaPlanetas.class));
                return false;
            }
        });

    }

}

class Ejercicio2Adapter extends RecyclerView.Adapter<Ejercicio2Adapter.ViewHolderEjercicio2> {

    FragmentManager manager;
    private ArrayList<Soles> lista = RepoEje2.lista();
    final static int id[]={R.id.renombrar,R.id.eliminar,R.id.mover,R.id.copiar,R.id.cortar};

    @NonNull
    @Override
    public ViewHolderEjercicio2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_ejercicio2, parent, false);

        return new ViewHolderEjercicio2(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderEjercicio2 holder, int position) {

        holder.toolbar.setTitle(lista.get(position).getDescripcion());
        holder.imageView.setBackgroundResource(lista.get(position).getImagen());
        holder.toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int ids = item.getItemId();
                if(ids == id[0]) {
                    FragmentTransaction transaction = manager.beginTransaction();
                    Popup miFragmento = new Popup(holder.toolbar);
                    transaction.replace(R.id.fragmentContainerView, miFragmento);
                    transaction.commit();
                    return true;
                }
                if (ids == id[1]) {
                    lista.remove(holder.getAdapterPosition());
                    notifyItemRemoved(holder.getAdapterPosition());
                    return true;
                }
                if (ids == id[3]) {
                    lista.add(lista.get(holder.getAdapterPosition()));
                    notifyItemInserted(holder.getAdapterPosition());
                    return true;
                }
                return true;
            }
        });
    }

    public void setManager(FragmentManager manager) {
        this.manager = manager;
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolderEjercicio2 extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private Toolbar toolbar;

        public ViewHolderEjercicio2(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
            toolbar = itemView.findViewById(R.id.toolbar3);
        }
    }
}

class RepoEje2 {
    public static ArrayList<Soles> lista() {
        ArrayList<Soles> lista = new ArrayList<>();
        lista.add(new Soles(R.drawable.corona_solar, "Corona Solar"));
        lista.add(new Soles(R.drawable.magnetosfera, "Magnetosfera"));
        lista.add(new Soles(R.drawable.erupcionsolar, "Erupcion Solar"));
        lista.add(new Soles(R.drawable.filamentos, "Filamentos"));

        return lista;
    }
}

class Soles {
    private int imagen;
    private String descripcion;

    public Soles(int imagen, String descripcion) {
        this.imagen = imagen;
        this.descripcion = descripcion;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}