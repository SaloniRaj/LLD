package com.example.notificationButton.service;

import com.example.notificationButton.model.*;
import com.example.notificationButton.model.observablePackage.Observerable;
import com.example.notificationButton.model.observablePackage.Product;
import com.example.notificationButton.model.observerPackage.Observer;
import com.example.notificationButton.model.observerPackage.UserEmailNotification;

import java.util.HashMap;
import java.util.Map;

//@AllArgsConstructor
//@NoArgsConstructor
public class RequestService {
    static Map<String, Observerable> productList = new HashMap();
    static Map<String, Observer> userList = new HashMap<>();

    public Response addNotify(NotificationRequest notificationRequest) {
        Response response = new Response();
        response.setStandardResponse(new StandardResponse("200", "Success"));
        String product = notificationRequest.getProduct();
        String user = notificationRequest.getUser();
        productList.putIfAbsent(product, new Product(product));
        userList.putIfAbsent(user+":"+product, new UserEmailNotification(new User(user)));
        response.setData(productList.get(product).add(userList.get(user+":"+product)));
        System.out.println(productList+" \n"+userList);
        return response;
    }

    public Response removeNotify(NotificationRequest notificationRequest) {
        System.out.println(productList+" \n"+userList);
        Response response = new Response();
        response.setStandardResponse(new StandardResponse("200", "Success"));
        String product = notificationRequest.getProduct();
        String user = notificationRequest.getUser();
        if(!productList.containsKey(product) || !userList.containsKey(user+":"+product)){
            response.setData("Product or user not in list");
            return response;
        }
        response.setData(productList.get(product).delete(userList.get((user+":"+product))));
        return response;
    }

    public Response updateProduct(ProductRequest productRequest) {
        Response response = new Response();
        response.setStandardResponse(new StandardResponse("200", "Success"));
        String product = productRequest.getProduct();
        productList.putIfAbsent(product, new Product(product));
        productList.get(product).setData(productRequest.getNewQuantity());
        response.setData(" new product= "+ productList.get(product));
        System.out.println(productList+" \n"+userList);
        return response;
    }
}
