package com.pioneers.rest.function_programming.services;

import com.pioneers.rest.function_programming.models.dtos.OrderReceipt;

import java.math.BigDecimal;

public interface DiscountService {

    BigDecimal applyDiscount(OrderReceipt orderReceipt);
}
