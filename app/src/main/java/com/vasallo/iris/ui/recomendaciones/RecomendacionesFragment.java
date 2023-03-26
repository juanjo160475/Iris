package com.vasallo.iris.ui.recomendaciones;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vasallo.iris.R;
import com.vasallo.iris.adapter.PrestadoresAdapter;
import com.vasallo.iris.adapter.RecomendacionesAdapter;
import com.vasallo.iris.databinding.FragmentRecomendacionesBinding;
import com.vasallo.iris.modelo.Prestadores;
import com.vasallo.iris.modelo.Recomendaciones;

import java.util.ArrayList;

public class RecomendacionesFragment extends Fragment {

    private FragmentRecomendacionesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        RecomendacionesViewModel recomendacionesViewModel =
                new ViewModelProvider(this).get(RecomendacionesViewModel.class);
        setHasOptionsMenu(true);
        binding = FragmentRecomendacionesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerLista = binding.recyclerRecomendaciones;
        recyclerLista.setHasFixedSize(false);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        recyclerLista.setLayoutManager(manager);

        ArrayList<Recomendaciones> lista = new ArrayList<>();


        lista.add (new Recomendaciones("L. glandula tiroida","Htal Italiano",
                "Dr Rosseti","67549876",R.drawable.doc));
        lista.add (new Recomendaciones("Diverticulos","Htal Italiano","Dr Almodovar","67549876",R.drawable.doc2));
        lista.add (new Recomendaciones("Debilidad cardiaca","Clinica Favaloro","Dr Perez Cuello","66542332",R.drawable.doc3));

        RecomendacionesAdapter adapter = new RecomendacionesAdapter(lista);
        recyclerLista.setAdapter(adapter);


       /* final TextView textView = binding.textDashboard;
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);*/
        return root;
    }


    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_toolbar, menu);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}