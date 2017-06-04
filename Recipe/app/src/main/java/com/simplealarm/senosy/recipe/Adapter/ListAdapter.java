package com.simplealarm.senosy.recipe.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.simplealarm.senosy.recipe.Model.Recipes;
import com.simplealarm.senosy.recipe.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by senosy on 03/06/2017.
 */

public class ListAdapter extends ArrayAdapter<Recipes> {


    public ListAdapter(@NonNull Context context, List<Recipes> recipesList) {
        super(context,0,recipesList);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View list=convertView;

        TextView mTitle,mCategory;
        ImageView mRecipeImage;
        RatingBar mrating;

        Recipes recipe=getItem(position);

        if(list==null)
        {
            list= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        mTitle=(TextView)list.findViewById(R.id.txt_title);
        mCategory=(TextView)list.findViewById(R.id.txt_category);

        mRecipeImage=(ImageView)list.findViewById(R.id.img_recipe);
        mrating=(RatingBar)list.findViewById(R.id.rate);

        mTitle.setText(recipe.getTitle());
        mCategory.setText(recipe.getCategory());

        Picasso.with(getContext())
                .load(recipe.getImageUrl())
                .placeholder(R.drawable.noimage)
                .centerCrop()
                .into(mRecipeImage);

        mrating.setRating(recipe.getRating());

        return list;
    }
}
