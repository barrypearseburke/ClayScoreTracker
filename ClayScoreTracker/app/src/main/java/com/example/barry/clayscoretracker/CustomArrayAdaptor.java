package com.example.barry.clayscoretracker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import org.w3c.dom.Text;
//references https://www.thenewboston.com/videos.php?cat=6&video=16740

/**
 * Created by Barry on 24/11/2015.
 */
public class CustomArrayAdaptor extends ArrayAdapter<String>{


    public CustomArrayAdaptor(Context context, String [] Pairs) {
        super(context, R.layout.row_layout1, Pairs);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View CustomView = inflater.inflate(R.layout.row_layout1, parent, false);
        String stringelement = getItem(position);
        TextView Text= (TextView)CustomView.findViewById(R.id.textelement);

        Text.setText(stringelement);
        return CustomView;
    }

}
//todo make checkboxes add up and place number in textview score
//todo put in db manager//remember update
// todo send score to db
// todo dump data to listview
//todo splash screen if time.