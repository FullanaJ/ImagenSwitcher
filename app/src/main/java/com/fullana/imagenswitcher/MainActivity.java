package com.fullana.imagenswitcher;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.fullana.imagenswitcher.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    protected ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.ejercicio1.setOnClickListener((l)-> startActivity(new Intent(binding.getRoot().getContext(),Ejercicio1.class)));
        binding.ejercicio2.setOnClickListener((l)-> startActivity(new Intent(binding.getRoot().getContext(),Ejercicio2.class)));
        binding.ejercicio4.setOnClickListener((l)-> startActivity(new Intent(binding.getRoot().getContext(),Ejercicio3.class)));    }
}