package com.cgs.entity.base;

/**
 * Created by Administrator on 2017/7/5.
 */
public class Message {

    private String code;
    private Object payload;

    public Message(String code){
        this.code = code;
        this.payload = null;
    }

    public Message(String code,Object payload){
        this.code = code;
        this.payload = payload;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}
