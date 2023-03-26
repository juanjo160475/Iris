package com.vasallo.iris.ui.historial;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vasallo.iris.adapter.HistorialAdapter;
import com.vasallo.iris.databinding.FragmentHistorialBinding;
import com.vasallo.iris.modelo.Historial;

import java.util.ArrayList;

public class HistorialFragment extends Fragment {

    private HistorialViewModel mViewModel;
    private FragmentHistorialBinding binding;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentHistorialBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        RecyclerView recyclerLista = binding.recycler;



        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerLista.setLayoutManager(manager);

        ArrayList <Historial> lista = new ArrayList<>();


        lista.add (new Historial("12/12/21","Síndrome metabolico"));
        lista.add (new Historial("1/1/22","Hernia latal"));
        lista.add (new Historial("1/10/22","Divertículos"));
        lista.add (new Historial("10/12/23","Debilidad de Tiroides"));


            HistorialAdapter adapter = new HistorialAdapter(lista);
            recyclerLista.setAdapter(adapter);

        return root;
    }



}