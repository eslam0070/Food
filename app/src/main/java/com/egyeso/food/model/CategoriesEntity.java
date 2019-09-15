package com.egyeso.food.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CategoriesEntity implements Serializable {
    @SerializedName("strCategoryDescription")
    private String strcategorydescription;
    @SerializedName("strCategoryThumb")
    private String strcategorythumb;
    @SerializedName("strCategory")
    private String strcategory;
    @SerializedName("idCategory")
    private String idcategory;

    public String getStrcategorydescription() {
        return strcategorydescription;
    }

    public void setStrcategorydescription(String strcategorydescription) {
        this.strcategorydescription = strcategorydescription;
    }

    public String getStrcategorythumb() {
        return strcategorythumb;
    }

    public void setStrcategorythumb(String strcategorythumb) {
        this.strcategorythumb = strcategorythumb;
    }

    public String getStrcategory() {
        return strcategory;
    }

    public void setStrcategory(String strcategory) {
        this.strcategory = strcategory;
    }

    public String getIdcategory() {
        return idcategory;
    }

    public void setIdcategory(String idcategory) {
        this.idcategory = idcategory;
    }
}
