package com.simplealarm.senosy.recipe.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.simplealarm.senosy.recipe.Model.Ingredients;
import com.simplealarm.senosy.recipe.R;

import java.util.ArrayList;

/**
 * Created by senosy on 04/06/2017.
 */

public class IngredientListAdapter extends ArrayAdapter<Ingredients>
{
    public IngredientListAdapter(@NonNull Context context, ArrayList<Ingredients> ingredientses) {
        super(context, 0,ingredientses);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View ingredientList=convertView;

        TextView mID,mIsHeading,mName,mHtmlName,mQuantity,
                mDisplayQuantity,mUnit,mMetricQuantity,mMetricDisplayQuantity,
                mMetricUnit,mPreparedNotes,mIngredientInfoName,mmIngredientInfoDepartment,
                mIngredientInfoMasterIngredientID,mIngredientInfoUsuallyOnHand,mIsLinked;

        mID=(TextView)ingredientList.findViewById(R.id.txt_ingredient_id);
        mIsHeading=(TextView)ingredientList.findViewById(R.id.txt_heading_details);
        mName=(TextView)ingredientList.findViewById(R.id.txt_ingredient_name);
        mHtmlName=(TextView)ingredientList.findViewById(R.id.txt_html_name);
        mQuantity=(TextView)ingredientList.findViewById(R.id.txt_ingredient_quantity);
        mDisplayQuantity=(TextView)ingredientList.findViewById(R.id.txt_ingredient_display_quantity);
        mUnit=(TextView)ingredientList.findViewById(R.id.txt_ingredient_unit);
        mMetricQuantity=(TextView)ingredientList.findViewById(R.id.txt_ingredient_metric_quantity);
        mMetricDisplayQuantity=(TextView)ingredientList.findViewById(R.id.txt_metric_display_quantity);
        mMetricUnit=(TextView)ingredientList.findViewById(R.id.txt_metric_unit);
        mPreparedNotes=(TextView)ingredientList.findViewById(R.id.txt_prepared_note);
        mIngredientInfoName=(TextView)ingredientList.findViewById(R.id.txt_ingredient_info_name);
        mmIngredientInfoDepartment=(TextView)ingredientList.findViewById(R.id.txt_ingredient_info_department);
        mIngredientInfoMasterIngredientID=(TextView)ingredientList.findViewById(R.id.txt_ingredient_info_ingredient_id);
        mIngredientInfoUsuallyOnHand=(TextView)ingredientList.findViewById(R.id.txt_ingredient_info_usually_in_hand);
        mIsLinked=(TextView)ingredientList.findViewById(R.id.txt_ingredient_isLinked);

        Ingredients ingredients=getItem(position);


        if (ingredientList==null)
        {
            ingredientList= LayoutInflater.from(getContext()).inflate(R.layout.ingredient_list_item,parent,false);
        }

        mID.setText(String.valueOf(ingredients.getIngredientId()));
        mIsHeading.setText(String.valueOf(ingredients.isHeading()));
        mName.setText(ingredients.getName());
        mHtmlName.setText(ingredients.getHtmlName());
        mQuantity.setText(String.valueOf(ingredients.getQuantity()));
        mDisplayQuantity.setText(String.valueOf(ingredients.getDisplayQuantity()));
        mUnit.setText(ingredients.getUnit());
        mMetricQuantity.setText(String.valueOf(ingredients.getMetricQuantitty()));
        mMetricDisplayQuantity.setText(String.valueOf(ingredients.getMetricDisplayQuantity()));
        mMetricUnit.setText(ingredients.getMetricUnit());
        mPreparedNotes.setText(ingredients.getPreparationNotes());
        mIngredientInfoName.setText(ingredients.getIngredientInfo().getName());
        mmIngredientInfoDepartment.setText(ingredients.getIngredientInfo().getDepartment());
        mIngredientInfoMasterIngredientID.setText(String.valueOf(ingredients.getIngredientInfo().getMasterIngredientId()));
        mIngredientInfoUsuallyOnHand.setText(String.valueOf(ingredients.getIngredientInfo().isUsuallyOnHand()));
        mIsLinked.setText(String.valueOf(ingredients.isLinked()));

        return ingredientList;
    }
}
