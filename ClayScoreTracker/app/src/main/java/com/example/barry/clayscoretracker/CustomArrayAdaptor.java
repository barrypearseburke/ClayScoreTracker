package com.example.barry.clayscoretracker;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import org.w3c.dom.Text;
//references https://www.thenewboston.com/videos.php?cat=6&video=16740

/**
 * Created by Barry on 24/11/2015.
 */
public class CustomArrayAdaptor extends ArrayAdapter<String> {
    public static int checkAccumulator; //static var to count true checkboxes.

    public CustomArrayAdaptor(Context context, String[] Pairs) {
        super(context, R.layout.row_layout1, Pairs);
        checkAccumulator = 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //inflates view
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View CustomView = inflater.inflate(R.layout.row_layout1, parent, false);
        final String stringelement = getItem(position);
        final TextView Text = (TextView) CustomView.findViewById(R.id.textelement);
        Text.setText(stringelement);

// several references  from http://stackoverflow.com/questions/33928979/how-to-count-the-number-of-checkboxes-ticked-which-is-inside-a-listview/33929416?
        //inflates checkboxes
        CheckBox checkBox1 = (CheckBox) CustomView.findViewById(R.id.Checkbox1);
        CheckBox checkBox2 = (CheckBox) CustomView.findViewById(R.id.Checkbox2);


        CompoundButton.OnCheckedChangeListener checkListener = new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //on checkbox state changed.
                countCheck(isChecked);

                Log.i("CustomArray", checkAccumulator + "");


            }

        };

        checkBox1.setOnCheckedChangeListener(checkListener);
        checkBox2.setOnCheckedChangeListener(checkListener);

        Text.setText(stringelement);

        return CustomView;
    }



    private void countCheck(boolean isChecked) {
    //checks to see the new state of checkbox is.if it is false or true. If true add one to counter. If false ,-1 to counter
        checkAccumulator += isChecked ? 1 : -1 ;
    }//stackoverflow references end
    public static int returnvalueofchecks(){

        return checkAccumulator;
    }

}
