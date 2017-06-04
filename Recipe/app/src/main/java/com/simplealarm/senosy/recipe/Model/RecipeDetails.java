package com.simplealarm.senosy.recipe.Model;

import java.util.List;

/**
 * Created by senosy on 02/06/2017.
 */

public class RecipeDetails {

    private String title;
    private String description;
    private String category;
    private String subCategory;
    private String imageUrl;
    private String instruction;

    private float rating;

    private List<Ingredients> ingredientses;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public List<Ingredients> getIngredientses() {
        return ingredientses;
    }

    public void setIngredientses(List<Ingredients> ingredientses) {
        this.ingredientses = ingredientses;
    }
}
