package com.example.barry.clayscoretracker.Fragments;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.barry.clayscoretracker.CustomArrayAdaptor;
import com.example.barry.clayscoretracker.MainActivity;
import com.example.barry.clayscoretracker.R;

import static android.app.PendingIntent.getActivity;

//references https://www.youtube.com/watch?v=eAPFgC9URqc
//references https://www.thenewboston.com/videos.php?cat=6&video=16740
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
        String[] pair = {"Pair 1","Pair 2","Pair 3","Pair 4","Pair 5"};

        //build adapter
        ArrayAdapter<String> adapter = new CustomArrayAdaptor(getActivity(),pair);

        mList.setAdapter(adapter);
    }
}

