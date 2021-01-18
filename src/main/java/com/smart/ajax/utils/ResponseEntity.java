package com.smart.ajax.utils;

import java.io.Serializable;

public class ResponseEntity<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public ResponseEntity() {
    }

    public static <T> ResponseEntity<T> success(T data){
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatus(200);
        entity.setMsg("success");
        entity.setData(data);
        return entity;
    }
    public static <T> ResponseEntity<T> error(int status, String msg){
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatus(status);
        entity.setMsg(msg);
        return entity;
    }
    public static <T> ResponseEntity<T> error(ResponseCode responseCode) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatus(responseCode.getStatus());
        entity.setMsg(responseCode.getMsg());
        return entity;
    }



    public static <T> ResponseEntity<T> error(){
        return error(404,"error");
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
