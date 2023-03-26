package com.vasallo.iris.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vasallo.iris.MainActivityLogin;
import com.vasallo.iris.R;
import com.vasallo.iris.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        Button btnFotos = binding.btnFotos;
        Button btnDiagnostico= binding.btnDiagnostico;
        Button btnHistorial =binding.btnHistorial;

       btnFotos.setOnClickListener(view -> NavHostFragment.findNavController(HomeFragment.this)
               .navigate(R.id.action_navigation_home_to_fotosFragment));

        btnDiagnostico.setOnClickListener(view -> NavHostFragment.findNavController(HomeFragment.this)
                .navigate(R.id.diagnosticoFragment));

        btnHistorial.setOnClickListener(view -> NavHostFragment.findNavController(HomeFragment.this)
                .navigate(R.id.action_navigation_home_to_historialFragment));




        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}