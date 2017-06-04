package com.simplealarm.senosy.recipe.Presenter;

import android.content.Context;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.simplealarm.senosy.recipe.Model.IngredientInfo;
import com.simplealarm.senosy.recipe.Model.Ingredients;
import com.simplealarm.senosy.recipe.Model.RecipeDetails;
import com.simplealarm.senosy.recipe.Model.Recipes;
import com.simplealarm.senosy.recipe.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by senosy on 02/06/2017.
 */

public class Data {

    private List<Recipes> recipesList;
    private RecipeDetails details;
    private Context context;

    private final static String BASE_URL="https://api2.bigoven.com/Recipe/api_key={";

    public Data(Context con) {

        recipesList=new ArrayList<>();
        context=con;
    }

    private void getListOfRecipes( final OnCallBack oncall)
    {

        RequestQueue queue= Volley.newRequestQueue(context);
        // Add Your Key in res/Strings
        String url=BASE_URL+ R.string.your_api_key +"}";

        StringRequest req=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                    Recipes recipes=new Recipes();
                    List<Recipes> resbList=new ArrayList<>();
                try {

                    JSONObject fullResponse=new JSONObject(response);
                    int count=Integer.getInteger(fullResponse.getString("ResultCount"));

                    JSONArray results=fullResponse.getJSONArray("Result");
                    for (int i=0;i<count;i++) {

                        JSONObject recipe=results.getJSONObject(i);
                        recipes.setId(Integer.valueOf(recipe.getInt("RecipeID")));
                        recipes.setTitle(recipe.getString("Title"));
                        recipes.setCategory(recipe.getString("Category"));
                        recipes.setImageUrl(recipe.getString("PhotoUrl"));
                        recipes.setRating(Integer.valueOf(recipe.getString("StarRating")));
                        resbList.add(recipes);
                    }

                }catch (JSONException e)
                {
                    Toast.makeText(context,"Error : Can't Display Recipes",Toast.LENGTH_LONG).show();
                }
                oncall.onSuccess(resbList);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(context,"Error : Can't Reach WebSite now please try again later",Toast.LENGTH_LONG).show();

            }
        });
        queue.add(req);

    }

    public List<Recipes> getRecipes()
    {

        getListOfRecipes( new OnCallBack() {
            @Override
            public List<Recipes> onSuccess(List<Recipes> recipes) {
                return recipes;
            }

            @Override
            public void onFail(String msg) {

            }
        });

        return null;
    }

    public void setRecipes(List<Recipes> recipes)
    {
        this.recipesList = recipes;
    }

    private void getRecipeDetails(final onCallRecipeDetails onCallRecipeDetails,int id)
    {
        RequestQueue queue=Volley.newRequestQueue(context);

        String Url=BASE_URL+R.string.your_api_key+"}/recipe/"+id;

                StringRequest request=new StringRequest(Request.Method.GET, Url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        JSONObject jobj=new JSONObject();
                        RecipeDetails recipeDetails=new RecipeDetails();
                        IngredientInfo ingredientInfo=new IngredientInfo();
                        Ingredients ingredients=new Ingredients();
                        List<Ingredients> ingredientsList=new ArrayList<>();
                        try {
                            jobj=new JSONObject(response);
                            recipeDetails.setTitle(jobj.getString("Title"));
                            recipeDetails.setCategory(jobj.getString("Category"));
                            recipeDetails.setDescription(jobj.getString("Description"));
                            recipeDetails.setRating(Float.valueOf(String.valueOf(jobj.getDouble("StarRating"))));
                            recipeDetails.setSubCategory(jobj.getString("Subcategory"));
                            recipeDetails.setImageUrl(jobj.getString("ImageURL"));
                            recipeDetails.setInstruction(jobj.getString("Instructions"));
                            JSONArray ingredientsArr=jobj.getJSONArray("Ingredients");
                            for(int i=0;i<ingredientsArr.length();i++)
                            {
                                JSONObject ingredient=ingredientsArr.getJSONObject(i);
                                JSONObject ingredientInfoObj=ingredient.optJSONObject("IngredientInfo");
                                ingredients.setIngredientId(ingredient.getInt("IngredientID"));
                                ingredients.setName(ingredient.getString("Name"));
                                ingredients.setDisplayIndex(ingredient.getInt("DisplayIndex"));
                                ingredients.setHeading(ingredient.getBoolean("IsHeading"));
                                ingredients.setHtmlName(ingredient.getString("HTMLName"));
                                ingredients.setQuantity(ingredient.getLong("Quantity"));
                                ingredients.setDisplayQuantity(ingredient.getString("DisplayQuantity"));
                                ingredients.setUnit(ingredient.getString("Unit"));
                                ingredients.setMetricQuantitty(ingredient.getInt("MetricQuantity"));
                                ingredients.setMetricDisplayQuantity(ingredient.getInt("MetricDisplayQuantity"));
                                ingredients.setMetricUnit(ingredient.getString("MetricUnit"));
                                ingredients.setPreparationNotes(ingredient.getString("PreparationNotes"));

                                ingredientInfo.setName(ingredientInfoObj.getString("Name"));
                                ingredientInfo.setDepartment(ingredientInfoObj.getString("Department"));
                                ingredientInfo.setMasterIngredientId(ingredientInfoObj.getInt("MasterIngredientID"));
                                ingredientInfo.setUsuallyOnHand(ingredientInfoObj.getBoolean("UsuallyOnHand"));

                                ingredients.setIngredientInfo(ingredientInfo);
                                ingredients.setLinked(ingredient.getBoolean("IsLinked"));

                                ingredientsList.add(ingredients);

                            }
                            recipeDetails.setIngredientses(ingredientsList);
                        }catch (JSONException e)
                        {
                            e.printStackTrace();
                        }finally {
                            onCallRecipeDetails.onSuccess(recipeDetails);
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        queue.add(request);

    }

    public RecipeDetails getDetails(int id) {

        getRecipeDetails(new onCallRecipeDetails() {
            @Override
            public RecipeDetails onSuccess(RecipeDetails recipeDetails) {
                return recipeDetails;
            }

            @Override
            public void onFail(String msg) {

            }
        },id);
        return null;
    }

    public void setDetails(RecipeDetails details) {
        this.details = details;
    }

    interface OnCallBack
    {
        List<Recipes> onSuccess(List<Recipes> recipes);
        void onFail(String msg);
    }

    interface onCallRecipeDetails
    {
        RecipeDetails onSuccess(RecipeDetails recipeDetails);

        void onFail(String msg);

    }

}
