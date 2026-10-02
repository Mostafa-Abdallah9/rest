package com.pioneers.rest.function_programming.controllers;

import com.pioneers.rest.function_programming.models.dtos.OrderReceipt;
import com.pioneers.rest.function_programming.services.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
@RequestMapping("discount")
public class DiscountController {

    private final DiscountService discountService;

    @PostMapping("apply")
    public BigDecimal applyDiscountApi(@RequestBody OrderReceipt orderReceipt) {
        return discountService.applyDiscount(orderReceipt);
    }
}

