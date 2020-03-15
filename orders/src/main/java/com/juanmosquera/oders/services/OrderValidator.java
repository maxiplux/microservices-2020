package com.juanmosquera.oders.services;

import com.juanmosquera.oders.exception.ExceptionMessagesEnum;
import com.juanmosquera.oders.exception.IncorrectOrderRequestException;
import com.juanmosquera.oders.models.dto.OrderRequest;

public class OrderValidator {
    public static boolean validateOrder(OrderRequest order) {
        if (order.getItems() == null || order.getItems().isEmpty()) {
            throw new IncorrectOrderRequestException(ExceptionMessagesEnum.INCORRECT_REQUEST_EMPTY_ITEMS_ORDER.getValue());
        }
        return true;
    }
}
