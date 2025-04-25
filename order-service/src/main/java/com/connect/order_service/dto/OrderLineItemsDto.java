package com.connect.order_service.dto;

import lombok.*;

import java.math.BigDecimal;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItemsDto {
    private Long id;
    private String skucode;
    private BigDecimal price;
    private Integer quantity;
}