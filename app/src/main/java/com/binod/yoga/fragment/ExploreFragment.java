package com.binod.yoga.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.binod.yoga.R;
import com.github.barteksc.pdfviewer.PDFView;


public class ExploreFragment extends Fragment {

    PDFView book;

    public ExploreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_explore,null);
        book=view.findViewById(R.id.book);
        book.fromAsset("yoga.pdf").load();
        return view;



    }
}
