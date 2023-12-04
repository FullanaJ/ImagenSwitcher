package com.fullana.imagenswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import java.util.ArrayList;

public class ComparaPlanetas extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1;
    ArrayList<Planeta> list;
    ArrayAdapter<Planeta> adapter;
    TextView diametro1,diametro2,distancia1,distancia2,densidad1,densidad2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compara_planetas);
        list = repo();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,list);
        diametro1 = findViewById(R.id.d1);
        diametro2 = findViewById(R.id.d2);
        distancia1 = findViewById(R.id.d4);
        distancia2 = findViewById(R.id.d5);
        densidad1 = findViewById(R.id.d7);
        densidad2 = findViewById(R.id.d8);
        autoCompleteTextView = findViewById(R.id.multiAutoCompleteTextView);
        autoCompleteTextView.setAdapter(adapter);
        autoCompleteTextView1 = findViewById(R.id.multiAutoCompleteTextView2);
        autoCompleteTextView1.setAdapter(adapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planeta planeta = (Planeta) autoCompleteTextView.getAdapter().getItem(position);
                diametro1.setText(planeta.getDiametro());
                distancia1.setText(planeta.getDistanciaSol());
                densidad1.setText(planeta.getDensidad());
            }
        });
        autoCompleteTextView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Planeta planeta = (Planeta) autoCompleteTextView.getAdapter().getItem(position);
                diametro2.setText(planeta.getDiametro());
                distancia2.setText(planeta.getDistanciaSol());
                densidad2.setText(planeta.getDensidad());
            }
        });
    }

    private static ArrayList<Planeta> repo(){

        ArrayList<Planeta> list1 = new ArrayList();
        list1.add(new Planeta("Mercurio","0,382","0,387","5400"));
        list1.add(new Planeta("Venus","0,949","0,723","5250"));
        list1.add(new Planeta("Tierra","1","1","5520"));
        list1.add(new Planeta("Marte","0,53","1,542","3960"));
        list1.add(new Planeta("Júpiter","11,2","5,203","1350"));
        list1.add(new Planeta("Saturno","9,41","9,539","700"));
        list1.add(new Planeta("Urano","3,38","19,81","1200"));
        list1.add(new Planeta("Neptuno","3,81","30,07","1500"));
        list1.add(new Planeta("Plutón","???","39,44","5?"));

        return list1;
    }
}
class Planeta{
    private final String nombre,diametro,distanciaSol, densidad;

    Planeta(String nombre, String diametro, String distanciaSol, String densidad) {
        this.nombre = nombre;
        this.diametro = diametro;
        this.distanciaSol = distanciaSol;
        this.densidad = densidad;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDiametro() {
        return diametro;
    }

    public String getDistanciaSol() {
        return distanciaSol;
    }

    public String getDensidad() {
        return densidad;
    }

    @Override
    public String toString() {
        return nombre;
    }
}