package com.vasallo.iris.ui.prestadores;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vasallo.iris.R;
import com.vasallo.iris.adapter.HistorialAdapter;
import com.vasallo.iris.adapter.PrestadoresAdapter;
import com.vasallo.iris.databinding.FragmentHistorialBinding;
import com.vasallo.iris.databinding.FragmentPrestadoresBinding;
import com.vasallo.iris.modelo.Historial;
import com.vasallo.iris.modelo.Prestadores;
import com.vasallo.iris.ui.historial.HistorialViewModel;

import java.util.ArrayList;

public class PrestadoresFragment extends Fragment {

    private PrestadoresViewModel mViewModel;
    private FragmentPrestadoresBinding binding;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentPrestadoresBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerLista = binding.recyclerPrestadores;
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerLista.setLayoutManager(manager);

        ArrayList<Prestadores> lista = new ArrayList<>();


        lista.add (new Prestadores("Analisis Clinico","IMAT","info@imat.com","45456767"));
        lista.add (new Prestadores("Analisis Clinico","HTAL ITALIANO","hital@htal.com","67549876"));
        lista.add (new Prestadores("Analisis Clinico","CENTRO GALLEGO", "info@cg.com","67545439"));
        lista.add (new Prestadores("Analisis Clinico","CEMIC","info.cemic.com","66552332"));


        PrestadoresAdapter adapter = new PrestadoresAdapter(lista);
        recyclerLista.setAdapter(adapter);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(PrestadoresViewModel.class);
        // TODO: Use the ViewModel



    }

}