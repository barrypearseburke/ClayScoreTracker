package com.example.barry.clayscoretracker.Fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.barry.clayscoretracker.R;

public class Stand1 extends Fragment {
    ListView mList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.stand1,container,false);
        mList = (ListView) root.findViewById(R.id.Stand1list);
        return root;
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        populateListView();
    }

    private void populateListView() {
        String[] pair = {"Pair1","Pair2","Pair3","Pair4","Pair5"};

        //build adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), R.layout.row_layout,pair);

        mList.setAdapter(adapter);
    }}
