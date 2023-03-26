package com.vasallo.iris.ui.fotos;

import android.graphics.Bitmap;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FotosViewModel extends ViewModel {
    private final MutableLiveData<Bitmap> mBitmapDer;



    public FotosViewModel() {
        mBitmapDer = new MutableLiveData<>();


    }

    public MutableLiveData<Bitmap> getmBitmapDer() {
        return mBitmapDer;
    }

    public void setBitmapImageDer ( Bitmap imagen){
        mBitmapDer.setValue(imagen);
    }




}