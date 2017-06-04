package com.simplealarm.senosy.recipe.Model;

/**
 * Created by senosy on 02/06/2017.
 */

public class Ingredients {

    private int ingredientId;
    private int displayIndex;
    private int metricQuantitty;
    private int metricDisplayQuantity;

    private String name;
    private String htmlName;
    private String DisplayQuantity;
    private String Unit;
    private String metricUnit;
    private String preparationNotes;

    private long quantity;

    private boolean isHeading;
    private boolean isLinked;

    IngredientInfo ingredientInfo;

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getDisplayIndex() {
        return displayIndex;
    }

    public void setDisplayIndex(int displayIndex) {
        this.displayIndex = displayIndex;
    }

    public int getMetricQuantitty() {
        return metricQuantitty;
    }

    public void setMetricQuantitty(int metricQuantitty) {
        this.metricQuantitty = metricQuantitty;
    }

    public int getMetricDisplayQuantity() {
        return metricDisplayQuantity;
    }

    public void setMetricDisplayQuantity(int metricDisplayQuantity) {
        this.metricDisplayQuantity = metricDisplayQuantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHtmlName() {
        return htmlName;
    }

    public void setHtmlName(String htmlName) {
        this.htmlName = htmlName;
    }

    public String getDisplayQuantity() {
        return DisplayQuantity;
    }

    public void setDisplayQuantity(String displayQuantity) {
        DisplayQuantity = displayQuantity;
    }

    public String getUnit() {
        return Unit;
    }

    public void setUnit(String unit) {
        Unit = unit;
    }

    public String getMetricUnit() {
        return metricUnit;
    }

    public void setMetricUnit(String metricUnit) {
        this.metricUnit = metricUnit;
    }

    public String getPreparationNotes() {
        return preparationNotes;
    }

    public void setPreparationNotes(String preparationNotes) {
        this.preparationNotes = preparationNotes;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public boolean isHeading() {
        return isHeading;
    }

    public void setHeading(boolean heading) {
        isHeading = heading;
    }

    public boolean isLinked() {
        return isLinked;
    }

    public void setLinked(boolean linked) {
        isLinked = linked;
    }

    public IngredientInfo getIngredientInfo() {
        return ingredientInfo;
    }

    public void setIngredientInfo(IngredientInfo ingredientInfo) {
        this.ingredientInfo = ingredientInfo;
    }
}
