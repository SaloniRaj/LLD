package com.example.notificationButton.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Response {
    String data;
    @NonNull
    StandardResponse standardResponse;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public StandardResponse getStandardResponse() {
        return standardResponse;
    }

    public void setStandardResponse(StandardResponse standardResponse) {
        this.standardResponse = standardResponse;
    }
}
