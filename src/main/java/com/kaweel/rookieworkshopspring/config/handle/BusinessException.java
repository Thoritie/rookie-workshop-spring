package com.kaweel.rookieworkshopspring.config.handle;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = false)
public class BusinessException extends RuntimeException {

    private HttpStatus httpStatus;
    private ResponseMsg responseMsg;

    public BusinessException(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        this.responseMsg = new ResponseMsg(httpStatus.getReasonPhrase());
    }

    public BusinessException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.responseMsg = new ResponseMsg(message);
    }

    @Data
    public static class ResponseMsg {
        private Date date;
        private String message;

        public ResponseMsg(String message) {
            this.date = new Date();
            this.message = message;
        }
    }

}
