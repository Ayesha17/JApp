package com.example.japp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.japp.models.helper.NavigationModel;

public class BaseViewModel extends ViewModel {
    public SingleLiveEvent<Boolean> showLoader = new SingleLiveEvent<Boolean>();
    public SingleLiveEvent<Boolean> hideLoader = new SingleLiveEvent<Boolean>();
    private SingleLiveEvent<NavigationModel> _navigateTo = new SingleLiveEvent<NavigationModel>();

    LiveData<NavigationModel> navigateTo() {
        return _navigateTo;
    }

    public void setNavigateTo(NavigationModel model) {
        _navigateTo.setValue(model);
    }

    private SingleLiveEvent<Boolean> _navigateBack = new SingleLiveEvent<Boolean>();

    private SingleLiveEvent<Boolean> navigateBack = new SingleLiveEvent<Boolean>();

    LiveData<Boolean> navigateBack() {
        return _navigateBack;
    }

    public void setNavigateBack(Boolean value) {
        _navigateBack.setValue(value);
    }
}
