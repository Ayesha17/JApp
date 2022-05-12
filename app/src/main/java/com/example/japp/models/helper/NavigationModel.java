package com.example.japp.models.helper;

import static androidx.core.os.BundleKt.bundleOf;

import android.os.Bundle;

import androidx.navigation.fragment.FragmentNavigator;

public class NavigationModel {

    private int id;
    private Bundle bundle = bundleOf();
    private FragmentNavigator.Extras fragNavigatorExtras=null;

    public Bundle getBundle() {
        return bundle;
    }

    public FragmentNavigator.Extras getFragNavigatorExtras() {
        return fragNavigatorExtras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBundle(Bundle bundle) {
        this.bundle = bundle;
    }

    public void setFragNavigatorExtras(FragmentNavigator.Extras fragNavigatorExtras) {
        this.fragNavigatorExtras = fragNavigatorExtras;
    }
}
