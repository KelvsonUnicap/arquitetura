package com.kelvson.orchestration.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AppConstants {
    public static final String ORDER_BASE_PATH = "/orders";
    public static final String EXIST_ENDPOINT = "/exists";
    public static final String CONFIRM_ENDPOINT = "/confirm";
    public static final String CANCEL_ENDPOINT = "/cancel";

    public static final String ORDER_SERVICE_URL = "http://localhost:8082/orders";
//    public static final String PAYMENT_SERVICE_URL = "http://payment-service:8083/payments";
    public static final String RESTAURANT_SERVICE_URL = "http://localhost:8084/restaurants";

    public static String buildOrderUrl(Long orderId, String endpoint){
        return String.format("%s/%d%s", ORDER_SERVICE_URL, orderId, endpoint);
    }

    public static String buildOrderUrl(Long orderId){
        return String.format("%s/%d", ORDER_SERVICE_URL, orderId);
    }

    public static String buildRestaurantUrl(Long restaurantId){
        return String.format("%s/%d", RESTAURANT_SERVICE_URL, restaurantId);
    }
}
