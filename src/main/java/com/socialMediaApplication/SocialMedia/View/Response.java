package com.socialMediaApplication.SocialMedia.View;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.socialMediaApplication.SocialMedia.dto.ErrorResponseDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class Response {
        @JsonInclude(JsonInclude.Include.ALWAYS)
        private long timestamp;
        @JsonInclude(JsonInclude.Include.ALWAYS)
        private int statusCode;
        @JsonInclude(JsonInclude.Include.ALWAYS)
        private String status;
        @JsonInclude(JsonInclude.Include.ALWAYS)
        private String message;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Long transactionId;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private Object content;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private int numberOfElement;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private long rowCount;
        @JsonInclude(JsonInclude.Include.NON_NULL)
        private List<ErrorResponseDto> errors;


}
