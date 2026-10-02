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

//@ExtendWith(Extension.class)
public class LaptopRuleTest {

    private static LaptopRule laptopRule;

    @BeforeAll
    static void beforeAll() {
        laptopRule = new LaptopRule();
    }

    @Test
    void testApplyDiscount_whenOrderContainsLaptop_thenReturnSubtract500EGP(){
        //Arrange
        final List<ProductItem> productItems = List.of(
                new ProductItem(Category.ELECTRONICS, SubCategory.LAPTOP, "LP123", 1, BigDecimal.valueOf(40000)));
        final OrderReceipt orderReceipt = new OrderReceipt(productItems);

        //Action
        final BigDecimal actual = laptopRule.applyDiscount(orderReceipt,orderReceipt.totalPrice());

        //Assert
        Assertions.assertEquals(new BigDecimal("39500"),actual);
    }


    @Test
    void testApplyDiscount_whenOrderContainsLaptop_thenReturnNotSubtract500EGP(){
        //Arrange
        final List<ProductItem> productItems = List.of(
                new ProductItem(Category.ELECTRONICS, SubCategory.LAPTOP, "LP123", 1, BigDecimal.valueOf(40000)));
        final OrderReceipt orderReceipt = new OrderReceipt(productItems);

        //Action
        final BigDecimal actual = laptopRule.applyDiscount(orderReceipt,orderReceipt.totalPrice());

        //Assert
        Assertions.assertEquals(new BigDecimal("3900"),actual);
    }

}
