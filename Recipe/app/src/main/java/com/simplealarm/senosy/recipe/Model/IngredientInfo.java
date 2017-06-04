package com.simplealarm.senosy.recipe.Model;

/**
 * Created by senosy on 02/06/2017.
 */

public class IngredientInfo {

    private String name;
    private String department;

    private int masterIngredientId;

    private boolean usuallyOnHand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getMasterIngredientId() {
        return masterIngredientId;
    }

    public void setMasterIngredientId(int masterIngredientId) {
        this.masterIngredientId = masterIngredientId;
    }

    public boolean isUsuallyOnHand() {
        return usuallyOnHand;
    }

    public void setUsuallyOnHand(boolean usuallyOnHand) {
        this.usuallyOnHand = usuallyOnHand;
    }
}
