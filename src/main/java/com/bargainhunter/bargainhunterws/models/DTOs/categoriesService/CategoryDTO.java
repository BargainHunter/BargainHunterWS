package com.bargainhunter.bargainhunterws.models.DTOs.categoriesService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class CategoryDTO implements Serializable {
    private Long categoryId;
    private String description;

    private Collection<SubcategoryDTO> subcategories;

    {
        subcategories = new ArrayList<>();
    }

    public CategoryDTO() {
    }

    public CategoryDTO(Long categoryId, String description, Collection<SubcategoryDTO> subcategories) {
        this.categoryId = categoryId;
        this.description = description;
        this.subcategories = subcategories;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<SubcategoryDTO> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Collection<SubcategoryDTO> subcategories) {
        this.subcategories = subcategories;
    }
}
