package com.example.notificationButton.controller;

import com.example.notificationButton.model.NotificationRequest;
import com.example.notificationButton.model.ProductRequest;
import com.example.notificationButton.model.Response;
import com.example.notificationButton.service.RequestService;
import jdk.jfr.ContentType;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;
//@NoArgsConstructor
@RestController
public class RequestController {
    RequestService requestService = new RequestService();

    @PostMapping(value="/post/addNotify")
    public Response postAdd(@RequestBody NotificationRequest notificationRequest){
        Response response = requestService.addNotify(notificationRequest);
        return response;
    }
    @PostMapping(value="/post/removeNotify")
    public Response postRemove(@RequestBody NotificationRequest notificationRequest){
        Response response = requestService.removeNotify(notificationRequest);
        return response;
    }
    @PostMapping(value="/post/setProduct")
    public Response postSet(@RequestBody ProductRequest productRequest){
        Response response = requestService.updateProduct(productRequest);
        return response;
    }
}
