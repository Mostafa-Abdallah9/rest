package com.pioneers.rest.function_programming.rules;

import com.pioneers.rest.function_programming.models.dtos.OrderReceipt;

import java.math.BigDecimal;

public interface DiscountRule {

    BigDecimal applyDiscount(OrderReceipt orderReceipt, BigDecimal totalPrice);
}