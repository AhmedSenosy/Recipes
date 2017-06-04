package com.simplealarm.senosy.recipe.View;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.simplealarm.senosy.recipe.Adapter.ListAdapter;
import com.simplealarm.senosy.recipe.Manifest;
import com.simplealarm.senosy.recipe.Model.Recipes;
import com.simplealarm.senosy.recipe.Presenter.Data;
import com.simplealarm.senosy.recipe.R;
import com.simplealarm.senosy.recipe.Util.Util;

import java.util.ArrayList;

public class ViewRecipes extends AppCompatActivity  {

    ListView mRecipes;
    ListAdapter adapter;
    Data data;

    static final int MY_PERMISSIONS_REQUEST_INTERNET_ACCESSS=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_recipes);
        //getActionBar().hide();
        mRecipes=(ListView) findViewById(R.id.list_recipes);

        data=new Data(this);

        adapter=new ListAdapter(this,new ArrayList<Recipes>());

        CheckNetwork();


    }




    private void CheckNetwork()
    {

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.INTERNET)) {



            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.INTERNET},
                        MY_PERMISSIONS_REQUEST_INTERNET_ACCESSS);

                // MY_PERMISSIONS_REQUEST_ACCESS_INTERNET is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }

        if(Util.isNetworkAvailable(this))
        {
            Toast.makeText(this," YOU ARE CONNECTED",Toast.LENGTH_LONG).show();
        }
        else
        {
            DialogInterface.OnClickListener discard=new DialogInterface.OnClickListener(){

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent=getIntent();
                    finish();
                    startActivity(intent);

                }
            };
            ShowWarningDialogue(discard);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_INTERNET_ACCESSS: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void ShowWarningDialogue(DialogInterface.OnClickListener discardButtonClickListener)
    {
        // Create an AlertDialog.Builder and set the message, and click listeners
        // for the positive and negative buttons on the dialog.
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.no_internet_connection);
        builder.setPositiveButton(R.string.retry, discardButtonClickListener);
        builder.setNegativeButton(R.string.discard, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked the "Keep editing" button, so dismiss the dialog
                // and continue editing the pet.
                if (dialog != null) {
                    dialog.dismiss();
                    finish();
                }
            }
        });
        // Create and show the AlertDialog
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void fetchList()
    {
        adapter.addAll(data.getRecipes());

    }

    protected void onStart() {
        super.onStart();
        fetchList();
        mRecipes.setAdapter(adapter);
        mRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent detailsIntent=new Intent(ViewRecipes.this,Details.class);
                detailsIntent.putExtra("post_id",adapter.getItemId(position));
                startActivity(detailsIntent);
            }
        });

    }


   /* @Override
    public void onRefresh() {
        swipeRefreshLayout.setRefreshing(true);
        fetchList();
        adapter.notifyDataSetChanged();
        swipeRefreshLayout.setRefreshing(false);
    }*/
}
