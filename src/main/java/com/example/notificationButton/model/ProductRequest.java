package com.example.notificationButton.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class ProductRequest {
    String product;
    @NonNull
    int newQuantity;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getNewQuantity() {
        return newQuantity;
    }

    public void setNewQuantity(int newQuantity) {
        this.newQuantity = newQuantity;
    }
}
