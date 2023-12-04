package com.fullana.imagenswitcher;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class Popup extends Fragment {

    protected EditText editText;
    protected ConstraintLayout constraintLayout;
    protected Button button;
    protected androidx.appcompat.widget.Toolbar toolbar;
    public Popup(Toolbar toolbar) {
        this.toolbar = toolbar;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        editText = view.findViewById(R.id.nuevoNombre);
        constraintLayout = view.findViewById(R.id.frameLayout);
        button = view.findViewById(R.id.cambia);
        constraintLayout.setOnClickListener((l)->{
            if (getActivity() != null) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.remove(this); // "this" hace referencia al fragmento actual
                transaction.commit();
            }
        });
        button.setOnClickListener((l)->{
            String s = editText.getText().toString();
            if (!s.equals(""))
                toolbar.setTitle(s);
            if (getActivity() != null) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.remove(this); // "this" hace referencia al fragmento actual
                transaction.commit();
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_popup, container, false);
    }
}