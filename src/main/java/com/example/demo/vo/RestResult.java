package com.example.demo.vo;

import java.io.Serializable;

public class RestResult<T> implements Serializable{

    private boolean result;
    private String message;
    private T data;

    private RestResult() {
    }

    public static <T> RestResult<T> newInstance() {
        return new RestResult<>();
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    // ...setter and getter

    @Override
    public String toString() {
        return "RestResult{" +
                "result=" + result +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
