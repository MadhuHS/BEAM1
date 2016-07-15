package com.jspiders.moblie.studentinfo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class HomeActivity extends AppCompatActivity {

    int ID;
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView =(RecyclerView)findViewById(R.id.rvstudentlist);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                ++ID;
              RealmConfiguration configuration =
                      new RealmConfiguration.Builder(HomeActivity.this).build();

                Realm.setDefaultConfiguration(configuration);
                Realm realm = Realm.getDefaultInstance();

                realm.beginTransaction();
                Student s1 = realm.createObject(Student.class);
                s1.setID(ID);
                s1.setName("ABC"+ID);
                s1.setPhone(123456);
                s1.setEmail("abc@gmail.com");
                realm.commitTransaction();

               long count = realm.where(Student.class).count();
                Snackbar.make(view, "Data Saved "+count, Snackbar.LENGTH_LONG).show();
               RealmResults<Student> results = realm.where(Student.class).findAll();

                for(int i=0;i<results.size();i++)
                {
                    Log.d("DEBUG","Student : "+i+results.get(i));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
