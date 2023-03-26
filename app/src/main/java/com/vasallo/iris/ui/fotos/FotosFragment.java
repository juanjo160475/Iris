package com.vasallo.iris.ui.fotos;

import static android.app.Activity.RESULT_OK;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vasallo.iris.R;
import com.vasallo.iris.databinding.FragmentFotosBinding;
import com.vasallo.iris.ui.home.HomeFragment;

public class FotosFragment extends Fragment {

    private FotosViewModel fotoViewModel;
    private FragmentFotosBinding binding;
    private ImageView imagenDer;
    private Button btnDiagnos;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentFotosBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        FloatingActionButton tomarFoto = binding.camara;
        btnDiagnos = binding.diagnosticar;
        imagenDer = binding.imagenDer;
        imagenDer.setTag("imagen");



        btnDiagnos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (imagenDer.getTag().equals("imagen")){
                    Toast.makeText( getContext(),"Antes debes tomar una foto", Toast.LENGTH_SHORT).show();
                }else {
                    NavHostFragment.findNavController(FotosFragment.this)
                            .navigate(R.id.action_fotosFragment_to_diagnosticoFragment);
                }
            }
        });


        fotoViewModel =
                new ViewModelProvider(getActivity()).get(FotosViewModel.class);
        fotoViewModel.getmBitmapDer().observe(getViewLifecycleOwner(),imagenDer::setImageBitmap);


        tomarFoto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // do something when the button is clicked

                dispatchTakePictureIntent();
            }
        });




        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }





    private static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bitmap imageBitmap;
            Bundle extras = data.getExtras();

            if( extras != null) {
                imageBitmap = (Bitmap) extras.get("data");
                fotoViewModel.setBitmapImageDer(imageBitmap);
                imagenDer.setImageBitmap(imageBitmap);
                imagenDer.setTag("foto");

            }


        }

    }






}