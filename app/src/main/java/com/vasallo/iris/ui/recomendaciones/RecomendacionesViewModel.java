package com.vasallo.iris.ui.recomendaciones;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RecomendacionesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public RecomendacionesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is dashboard fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}