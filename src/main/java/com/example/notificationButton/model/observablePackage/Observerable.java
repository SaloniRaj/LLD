package com.example.notificationButton.model.observablePackage;

import com.example.notificationButton.model.observerPackage.Observer;

public interface Observerable {
    String add(Observer observer);
    String delete(Observer observer);
    void notification();
    String setData(int quantity);
    Product getData();

}
