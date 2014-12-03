package com.bargainhunter.bargainhunterws.models.DTOs;

public class CategoryDTO {
    private Long categoryId;
    private String description;

    public CategoryDTO() {}

    public CategoryDTO(Long categoryId, String description) {
        this.categoryId = categoryId;
        this.description = description;
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
}
