package com.boot.model.common;

import java.util.ArrayList;

/**
 * 返回数据信息包
 * @param <T>
 */
public class ActionResultDto<T> {

    private String code;    //返回状态码
    private String message; //返回状态信息
    private T data;         //返回数据
    private Object ext;     //返回附加数据
    private Object attach;  //返回附加信息

    public ActionResultDto() {
        this.code = ResultDataType.CODE_MESSAGE_TURE.getCode();
        this.message = ResultDataType.CODE_MESSAGE_TURE.getMessage();
        this.data = (T) new ArrayList<>();
        this.ext = "";
        this.attach = "";
    }

    public ActionResultDto(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ActionResultDto(String code) {
        this.code = code;
        this.message = "";
        ResultDataType resultDateType = ResultDataType.get(code);
        if(resultDateType != null){
            this.message = resultDateType.getMessage();
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public Object getExt() {
        return ext;
    }

    public void setExt(Object ext) {
        this.ext = ext;
    }

    public Object getAttach() {
        return attach;
    }

    public void setAttach(Object attach) {
        this.attach = attach;
    }
}
