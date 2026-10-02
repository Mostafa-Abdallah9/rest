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

public class HighPriceRuleTest {
    private static HighPriceRule highPriceRule;

    @BeforeAll
    static void beforeAll() {
        highPriceRule = new HighPriceRule();
    }

    @Test
    void testapplyDiscount_whenTotalPriceGreaterThan50000_thenReturnDiscountPrice() {
        //Arrange
        final List<ProductItem> productItems = List.of(
                new ProductItem(Category.ELECTRONICS, SubCategory.LAPTOP, "LP123", 1, BigDecimal.valueOf(100000)));
        final OrderReceipt orderReceipt = new OrderReceipt(productItems);

        //Action
        final BigDecimal actual = highPriceRule.applyDiscount(orderReceipt,orderReceipt.totalPrice());

        //Assertion
        Assertions.assertEquals(new BigDecimal("90000.0"),actual);
    }

    @Test
    void testapplyDiscount_whenTotalPriceLessThan50000_thenReturnOriginalPrice() {
        //Arrange
        final List<ProductItem> productItems = List.of(
                new ProductItem(Category.ELECTRONICS, SubCategory.LAPTOP, "LP123", 1, BigDecimal.valueOf(40000)));
        final OrderReceipt orderReceipt = new OrderReceipt(productItems);

        //Action
        final BigDecimal actual = highPriceRule.applyDiscount(orderReceipt,orderReceipt.totalPrice());

        //Assertion
        Assertions.assertEquals(new BigDecimal("40000"),actual);
    }

}
