package com.example.demo.Bean;

import java.util.HashMap;
import java.util.Map;

public class Message {
    private Integer code;
    private String message;
    private Map<String, Object> map = new HashMap<String, Object>();

    public static Message success(){
        Message m = new Message();
        m.setCode(100);
        m.setMessage("success");
        return m;
    }

    public static Message fail(){
        Message m = new Message();
        m.setCode(200);
        m.setMessage("fail");
        return m;
    }

    public Message add(String key, Object value){
        this.getMap().put(key,value);
        return this;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
