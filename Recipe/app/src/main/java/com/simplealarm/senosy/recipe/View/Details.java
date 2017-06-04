package com.simplealarm.senosy.recipe.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.simplealarm.senosy.recipe.Adapter.IngredientListAdapter;
import com.simplealarm.senosy.recipe.Model.Ingredients;
import com.simplealarm.senosy.recipe.Model.RecipeDetails;
import com.simplealarm.senosy.recipe.Presenter.Data;
import com.simplealarm.senosy.recipe.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Details extends AppCompatActivity {

    TextView mTitle,mDescription,mCategory,mSubCategory,mInstructions;

    ImageView mImgDetails;

    RatingBar rating;

    ListView mIngredientLV;

    IngredientListAdapter ingredientListAdapter;

    Data data;

    int post_id;

    RecipeDetails recipeDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent i=getIntent();

        post_id=i.getIntExtra("post_id",0);

        mTitle=(TextView)findViewById(R.id.txt_title_details);
        mDescription=(TextView)findViewById(R.id.txt_desc_details);
        mCategory=(TextView)findViewById(R.id.txt_category_details);
        mSubCategory=(TextView)findViewById(R.id.txt_instructions_details);
        mInstructions=(TextView)findViewById(R.id.txt_instructions_details);

        rating=(RatingBar)findViewById(R.id.rating_details);

        mImgDetails=(ImageView)findViewById(R.id.img_details);

        mIngredientLV=(ListView)findViewById(R.id.ingredient_lv);

        ingredientListAdapter=new IngredientListAdapter(this,new ArrayList<Ingredients>());

        data=new Data(this);

        recipeDetails=new RecipeDetails();

    }

    private void fetchData()
    {
        recipeDetails=data.getDetails(post_id);
    }

    private void updateUI()
    {
        mTitle.setText(recipeDetails.getTitle());
        mDescription.setText(recipeDetails.getDescription());
        mCategory.setText(recipeDetails.getCategory());
        mSubCategory.setText(recipeDetails.getSubCategory());
        mInstructions.setText(recipeDetails.getInstruction());

        Picasso.with(this)
                .load(recipeDetails.getImageUrl())
                .centerCrop()
                .placeholder(R.drawable.noimage)
                .into(mImgDetails);
        ingredientListAdapter.addAll(recipeDetails.getIngredientses());

        mIngredientLV.setAdapter(ingredientListAdapter);

    }

    @Override
    protected void onStart() {
        super.onStart();
        fetchData();
        updateUI();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
