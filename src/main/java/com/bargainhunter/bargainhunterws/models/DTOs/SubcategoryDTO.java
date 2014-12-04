package com.bargainhunter.bargainhunterws.models.DTOs;

public class SubcategoryDTO {
    private Long subcategoryId;
    private String description;
    private Long categoryId;

    public SubcategoryDTO() {}

    public SubcategoryDTO(Long subcategoryId, String description, Long categoryId) {
        this.subcategoryId = subcategoryId;
        this.description = description;
        this.categoryId = categoryId;
    }

    public Long getSubcategoryId() {
        return subcategoryId;
    }

    public void setSubcategoryId(Long subcategoryId) {
        this.subcategoryId = subcategoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}
