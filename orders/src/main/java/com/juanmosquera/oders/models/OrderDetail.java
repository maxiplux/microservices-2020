package com.juanmosquera.oders.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;



@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class OrderDetail extends CommonEntity {

    private Long id;


    private Integer quantity;


    private Double price;


    private Double tax;


    private String upc;


    private Double totalAmount;


    private Order order;
}
