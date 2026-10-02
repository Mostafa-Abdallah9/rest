//package com.pioneers.rest.function_programming.rules;
//
//import com.pioneers.rest.function_programming.models.dtos.OrderReceipt;
//import com.pioneers.rest.function_programming.models.dtos.ProductItem;
//import com.pioneers.rest.function_programming.utils.Category;
//import com.pioneers.rest.function_programming.utils.SubCategory;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.junit.jupiter.api.extension.Extension;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//
//import java.math.BigDecimal;
//import java.util.List;
//
//@ExtendWith(Extension.class)
//public class DiscountEngineTest {
//    @InjectMocks
//    private DiscountEngine discountEngine;
//
//    @Mock
//    private List<DiscountRule> discountRules;
//
//    @Test
//    void testApplyDiscount(){
//        //Arrange
//        //Arrange
//        final List<ProductItem> productItems = List.of(
//                new ProductItem(Category.ELECTRONICS, SubCategory.LAPTOP, "LP123", 1, BigDecimal.valueOf(40000)));
//        final OrderReceipt orderReceipt = new OrderReceipt(productItems);
//    }
//}
