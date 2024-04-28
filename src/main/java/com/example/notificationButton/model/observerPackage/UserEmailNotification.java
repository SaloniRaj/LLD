package com.example.notificationButton.model.observerPackage;

import com.example.notificationButton.model.User;
import lombok.*;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class UserEmailNotification implements Observer {
    @NonNull
    User user;

    public UserEmailNotification(User user) {
        this.user = user;
    }

    @Override
    public void update(String Message) {
        System.out.println(this.user.getUserName() + ": "+ Message);
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
