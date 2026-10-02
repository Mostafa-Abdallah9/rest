package com.pioneers.rest.function_programming.models.dtos;

import com.pioneers.rest.function_programming.utils.Category;
import com.pioneers.rest.function_programming.utils.SubCategory;

import java.math.BigDecimal;

public record ProductItem(Category category, SubCategory subCategory, String productCode, int quantity, BigDecimal price) {

    public BigDecimal totalPrice() {
        return price.multiply(new BigDecimal(quantity));
    }
}
