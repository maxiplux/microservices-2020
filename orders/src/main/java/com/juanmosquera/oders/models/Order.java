package com.juanmosquera.oders.models;


import com.juanmosquera.oders.utils.OrderPaymentStatus;
import com.juanmosquera.oders.utils.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.util.Date;
import java.util.List;

@Document(collection = "Order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends CommonEntity {
    @Id

    private String orderId;



    private OrderStatus status;

    private String accountId;


    private Double totalAmount;


    private Double totalTax;


    private Double totalAmountTax;


    private OrderPaymentStatus paymentStatus;


    private Date transactionDate;


    private List<OrderDetail> details;
}
