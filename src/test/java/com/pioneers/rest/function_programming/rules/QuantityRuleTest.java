package com.pioneers.rest.function_programming.rules;


import com.pioneers.rest.function_programming.models.dtos.OrderReceipt;
import com.pioneers.rest.function_programming.models.dtos.ProductItem;
import com.pioneers.rest.function_programming.utils.Category;
import com.pioneers.rest.function_programming.utils.SubCategory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

public class QuantityRuleTest {
    private static QuantityRule quantityRule;

    @BeforeAll
    static void beforeAll() {
        quantityRule = new QuantityRule();
    }

    @Test
    void testApplyDiscount_whenQuantitiesGreaterThan5_thenReturnDiscountPrice() {
        // Arrange
        final List<ProductItem> productItems = List.of(
                new ProductItem(Category.CLOTHES, SubCategory.PANT, "PT123", 6, BigDecimal.valueOf(500)));

        final OrderReceipt orderReceipt = new OrderReceipt(productItems);

        //Action
        final BigDecimal actual = quantityRule.applyDiscount(orderReceipt,orderReceipt.totalPrice());

        //Assertion
        Assertions.assertEquals(new BigDecimal("2850.00"),actual);
    }

    @Test
    void testApplyDiscount_whenQuantitiesLessThan5_thenReturnOriginPrice() {
        // Arrange
        final List<ProductItem> productItems = List.of(
                new ProductItem(Category.CLOTHES, SubCategory.PANT, "PT123", 4, BigDecimal.valueOf(500)));

        final OrderReceipt orderReceipt = new OrderReceipt(productItems);

        //Action
        final BigDecimal actual = quantityRule.applyDiscount(orderReceipt,orderReceipt.totalPrice());

        //Assertion
        Assertions.assertEquals(new BigDecimal("2000"),actual);
    }
}
