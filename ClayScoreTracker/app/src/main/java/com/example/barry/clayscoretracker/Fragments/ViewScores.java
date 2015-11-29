package com.example.barry.clayscoretracker.Fragments;
import android.app.AlertDialog;
import android.app.Fragment;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.barry.clayscoretracker.MainActivity;
import com.example.barry.clayscoretracker.R;
//references https://www.youtube.com/watch?v=cp2rL3sAFmI
public class ViewScores extends Fragment {

    ListView viewList;
    public View root;
    Button btnviewAll;
    EditText editId;
    Button btnviewDelete;
    Button btnviewDeleteall;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.viewscores, container, false);

//references https://www.youtube.com/watch?v=cp2rL3sAFmI
        editId = (EditText)root.findViewById(R.id.editText_ID);

        btnviewAll = (Button)root.findViewById(R.id.button_viewAll);

        btnviewDelete = (Button)root.findViewById(R.id.button_delete);

        btnviewDeleteall = (Button)root.findViewById(R.id.button_deleteall);
        viewAll();
        DeleteData();
        DeleteallData();
        DeleteallData();
        return root;


    }

    public void DeleteData(){
        btnviewDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = MainActivity.myDb.deleteData(editId.getText().toString());
                        if (deletedRows > 0) {
                            Toast.makeText(getActivity(), "Data Deleted from Row", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getActivity(), "Data not deleted- Please Try Again", Toast.LENGTH_SHORT).show();
                        }

                    }
                }
        );
    }


    public void DeleteallData(){
        btnviewDeleteall.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        MainActivity.myDb.dellall();
                        MainActivity.myDb.newCourseDBInstert();
                            Toast.makeText(getActivity(), "all rows deleted and new course set up", Toast.LENGTH_SHORT).show();


                        }

                    });
                }


    //references https://www.youtube.com/watch?v=cp2rL3sAFmI
    public void viewAll(){
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = MainActivity.myDb.getAllData();
                        if(res.getColumnCount()==0){
                            //show message if nothing there
                            showMessage("Error","Nothing found");
                            return;
                        }
                        StringBuffer buffer = new StringBuffer();
                        while(res.moveToNext()){
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Stand 1 :"+ res.getString(1)+"\n");
                            buffer.append("Stand 2 :"+ res.getString(2)+"\n");
                            buffer.append("Stand 3:"+ res.getString(3)+"\n");
                            buffer.append("Stand 4:"+ res.getString(4)+"\n");
                            buffer.append("Stand 5:"+ res.getString(5)+"\n");
                            buffer.append("date:"+ res.getString(6)+"\n\n");
                            buffer.append("--------------------------------------------------------------:"+"\n\n");
                        }

                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }//references https://www.youtube.com/watch?v=cp2rL3sAFmI
    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);

    }

}