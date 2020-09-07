package com.learn.common;

import lombok.Data;

@Data
public class Result {

    private Integer code;

    private Boolean success;

    private String message;

    private Object data;

    private Result() {
    }

    public static Result ok(String message) {
        Result result = new Result();
        result.setCode(200);
        result.setSuccess(true);
        result.setMessage(message);
        return result;
    }

    public static Result error(String message){
        Result result = new Result();
        result.setCode(500);
        result.setMessage(message);
        result.setSuccess(false);
        return result;
    }

    public static Result data(Object data){
        Result result = new Result();
        result.setCode(200);
        result.setSuccess(true);
        result.setData(data);
        return result;
    }
}
