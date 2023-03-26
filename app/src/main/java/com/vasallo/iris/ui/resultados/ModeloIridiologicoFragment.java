package com.vasallo.iris.ui.resultados;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vasallo.iris.R;
import com.vasallo.iris.databinding.FragmentFotosBinding;
import com.vasallo.iris.databinding.FragmentModeloIridiologicoBinding;
import com.vasallo.iris.ui.fotos.FotosFragment;
import com.vasallo.iris.ui.fotos.FotosViewModel;
import com.vasallo.iris.ui.home.HomeFragment;

public class ModeloIridiologicoFragment extends Fragment {

    private ModeloIridiologicoViewModel mViewModel;
    private FotosViewModel fotoViewModel;
    private FragmentModeloIridiologicoBinding binding;
    private ImageView fotografia;

    public static ModeloIridiologicoFragment newInstance() {
        return new ModeloIridiologicoFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding =  FragmentModeloIridiologicoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        fotografia = binding.imagenOjo;
        Button continuar = binding.continuar;
        continuar.setOnClickListener(view -> NavHostFragment.findNavController(ModeloIridiologicoFragment.this)
                .navigate(R.id.action_modeloIridiologicoFragment_to_resultadosIaFragment));


        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fotoViewModel = new ViewModelProvider(getActivity()).get(FotosViewModel.class);

        fotoViewModel.getmBitmapDer().observe(getActivity(),fotoBitMap -> {

            fotografia.setImageBitmap(fotoBitMap);
        });

    }
}