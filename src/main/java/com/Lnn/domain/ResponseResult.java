package com.Lnn.domain;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseResult<T> {

    private Integer code;

    private String message;

    private T data;

    public static <T> ResponseResult<T> ok(){
        return new ResponseResult<>(200,null,null);
    }

    public static <T> ResponseResult<T> ok(String message){
        return new ResponseResult<>(200,message,null);
    }

    public static <T> ResponseResult<T> ok(String message,T data){
        return new ResponseResult<>(200,message,data);
    }

    public static <T> ResponseResult<T> error(String message){
        return new ResponseResult<>(500,message,null);
    }

    public static <T> ResponseResult<T> failure(String message){
        return new ResponseResult<>(414,message,null);
    }
    public static <T> ResponseResult<T> failure(Integer code,String message){
        return new ResponseResult<>(code,message,null);
    }

}
