package com.bogsnebes.mtstetajava.ui.movie_details;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bogsnebes.mtstetajava.R;

public class FragmentMovieDetails extends Fragment {

    private FragmentMovieDetailsViewModel mViewModel;

    public static FragmentMovieDetails newInstance() {
        return new FragmentMovieDetails();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_details_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentMovieDetailsViewModel.class);
        // TODO: Use the ViewModel
    }

}