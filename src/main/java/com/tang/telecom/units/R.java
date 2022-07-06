package com.tang.telecom.units;

/**
 * @author weepppp 2022/7/6 9:27
 **/
public class R {
    private String msg;
    private Integer code;
    private Object data;

    public static R ok(String msg){
        return new R(200,msg,null);
    }
    public static R ok(String msg,Object data){
        return new R(200,msg,data);
    }
    public static R error(String msg){
        return new R(500,msg,null);
    }
    public static R error(String msg,Object data){
        return new R(500,msg,data);
    }

    public R() {
    }

    public R(Integer code, String msg, Object data) {
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
