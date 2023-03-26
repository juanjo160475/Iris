package com.vasallo.iris.ui.resultados;

import androidx.lifecycle.ViewModelProvider;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vasallo.iris.R;

public class ResultadosIaFragment extends Fragment {

    private ResultadosIaViewModel mViewModel;

    public static ResultadosIaFragment newInstance() {
        return new ResultadosIaFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_resultados_ia, container, false);
    }
    


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ResultadosIaViewModel.class);
        // TODO: Use the ViewModel
    }

}