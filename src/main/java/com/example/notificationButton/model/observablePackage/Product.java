package com.example.notificationButton.model.observablePackage;

import com.example.notificationButton.model.observerPackage.Observer;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product implements Observerable {
    String name;
    int quantity;
    List<Observer> observerList = new ArrayList<>();

    public Product(String name) {
        this.name = name;
        this.quantity = 0;
    }

    @Override
    public String add(Observer observer) {
        if(observerList.contains(observer)){
            return "User already in notification list";
        }
        observerList.add(observer);
        return "User added in notification list";
    }

    @Override
    public String delete(Observer observer) {
        System.out.println(observerList);
        if(observerList.contains(observer)){
            observerList.remove(observer);
            System.out.println(observerList);
            return "User removed from notification list";
        }
        return "User not in notification list";
    }

    @Override
    public void notification() {
        String message;
        if(this.quantity == 0) {
            message = this.name +" not available";
        } else{
            message = this.name+" is available at quantity " +this.quantity;
        }
        for(Observer observer: observerList){
            observer.update(message);
        }
    }

    @Override
    public String setData(int quantity) {
        this.quantity = quantity;
        notification();
        return "quantity updated successfully.";
    }

    @Override
    public Product getData() {
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Observer> getObserverList() {
        return observerList;
    }

    public void setObserverList(List<Observer> observerList) {
        this.observerList = observerList;
    }
}
