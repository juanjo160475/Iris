package com.vasallo.iris.ui.diagnostico;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.vasallo.iris.R;
import com.vasallo.iris.databinding.FragmentDiagnosticoBinding;
import com.vasallo.iris.databinding.FragmentFotosBinding;
import com.vasallo.iris.ui.fotos.FotosFragment;

import java.util.Timer;
import java.util.TimerTask;

public class DiagnosticoFragment extends Fragment {

    private DiagnosticoViewModel mViewModel;
    private FragmentDiagnosticoBinding binding;
    private  int counter=0;
    private ProgressBar progressUno, progressDos, progressTres ;

    private TextView textViewP1,textViewP2,textViewP3;



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentDiagnosticoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();




        Button continuar = binding.continuar;

        continuar.setOnClickListener(view -> NavHostFragment.findNavController(DiagnosticoFragment.this)
                .navigate(R.id.action_diagnosticoFragment_to_modeloIridiologicoFragment));

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        textViewP1=binding.porcentajeProgress1;
        textViewP2=binding.porcentajeProgress2;
        textViewP3=binding.porcentajeProgress3;
        progressUno =binding.progressBar1;
        progressDos=binding.progressBar2;
        progressTres=binding.progressBar3;
        progressUno.setProgress(0);
        progressDos.setProgress(0);
        progressTres.setProgress(0);
        progress(progressUno,progressDos , progressTres,textViewP1, textViewP2,textViewP3);


    }

    public void progress(ProgressBar p , ProgressBar p2, ProgressBar p3, TextView t, TextView t2, TextView t3){

        final Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                counter++;
               if(counter<=100){
                   p.setProgress(counter);
                   t.setText(""+counter+"%");
               }else if (counter>100 && counter<=200){
                   p2.setProgress(counter-100);
                   t2.setText(""+(counter-100)+"%");
               }else if (counter>200 && counter<=300){
                   p3.setProgress(counter-200);
                   t3.setText(""+(counter-200)+"%");
               }
                else
                if (counter==300){
                    timer.cancel();
                }
            }
        };
        timer.schedule(timerTask,0,100);
    }



}