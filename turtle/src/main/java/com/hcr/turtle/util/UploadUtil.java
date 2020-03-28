package com.hcr.turtle.util;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class UploadUtil implements Serializable {
    //判断结果
    private boolean success;
    //返回信息
    private String message;

    public UploadUtil(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    /*public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "UploadUtil{" +
                "success=" + success +
                ", message='" + message + '\'' +
                '}';
    }*/
}
