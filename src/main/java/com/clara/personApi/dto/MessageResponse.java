package com.clara.personApi.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponse {

    private String message;
}
