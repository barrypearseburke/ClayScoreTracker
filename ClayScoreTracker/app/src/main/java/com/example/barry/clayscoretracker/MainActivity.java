//Project navbar references - Basic android studio template and
//https://mega.nz/#!6ZtFlCrY!rgucXgxwi456O6LZbWe8XDNPZJ1fTVV7SWzu2FZEEJk to get fragments working

package com.example.barry.clayscoretracker;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.barry.clayscoretracker.Fragments.MainFragment;
import com.example.barry.clayscoretracker.Fragments.Stand1;
import com.example.barry.clayscoretracker.R;

import java.security.PublicKey;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
        DrawerLayout mDrawerLayout;
        public static DatabaseHelper myDb;
        public static long Courseid;

        public static String title ="";


        //converts the Courseid which is an long to a string ,so it can be sent to db
        //CourseID = Long.toString(Courseid);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

         myDb = new DatabaseHelper(this); //db helper class created.
        Courseid= myDb.newCourseDBInstert();//This will add an insert and return the id for the user in this session
        Log.i("Main long", Courseid + "");
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }



    @Override

    public boolean onNavigationItemSelected(MenuItem item) {
        FragmentManager fm = getFragmentManager();
        int id = item.getItemId();

        if (id == R.id.Stand1) {
            fm.beginTransaction().replace(R.id.content_frame, new Stand1()).commit();
            title ="STAND1";
            setTitle("Stand 1");

        } else if (id == R.id.Stand2) {
            fm.beginTransaction().replace(R.id.content_frame, new Stand1()).commit();
            title ="STAND2";
            setTitle("Stand 2");

        } else if (id == R.id.Stand3) {

            title ="STAND3";
            setTitle("Stand 3");

        } else if (id == R.id.Stand4) {

            title ="STAND4";
            setTitle("Stand 4");

        } else if (id == R.id.Stand5) {

            title ="STAND5";
            setTitle("Stand 5");

        } else if (id == R.id.ViewScores) {

        }
        else if (id == R.id.New) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
