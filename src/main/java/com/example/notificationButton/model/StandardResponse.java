package com.example.notificationButton.model;

import lombok.*;

@Data
//@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StandardResponse {
    String status;
    String message;

    public StandardResponse(String status, String message) {
        this.status = status;
        this.message = message;
    }
}
