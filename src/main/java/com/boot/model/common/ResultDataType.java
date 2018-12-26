package com.boot.model.common;

/**
 * @author  caiyunchun
 * 返回前段的数据类型定义
 */
public enum ResultDataType {
    CODE_MESSAGE_TURE("200","请求成功"),
    CODE_MESSAGE_ERROR("500","请求失败"),
    CODE_USERNAME_ERROR("10000","电话号或者密码错误，输入错误5次之后该账户将被锁定"),
    CODE_PARAM_ERROR("10001","操作失败"),
    CODE_PARAM_NULL("10002","操作失败"),
    CODE_TOKEN_ERROR("10003","请先登录"),
    CODE_VAILDCODE_ERROR("10004","验证码错误"),
    CODE_REFERRAL_ERROR("10005","不存在此理财师推荐码"),
    CODE_USER_EXIST("10006","该手机号已注册"),
    CODE_TIMEOUT("10007","验证码超时"),
    CODE_ERROR("10008","验证码错误"),
    CODE_INVALID("10009","验证码失效"),
    CODE_AUTH_NO("10011","未实名认证"),
    CODE_LOGIN_ERROR("10012","用户名或密码错误"),
    CODE_AUTH_ERROR("10013","身份认证失败"),
    CODE_BANK_ERROR("10014","银行卡绑定失败"),
    CODE_ACCOUNT_LOCK("10015","您的账户已被锁定"),
    CODE_CANCEL_DEFEATED("10016","取消失败，请联系您的理财师或者客服"),
    CODE_PASSWORD_EQUAL("10020","新的密码不能和旧的密码一样"),
    CODE_OLDPHONE_NULL("10021","用户没有绑定手机"),
    CODE_SENDTEXT_ERROR("10022","短信发送失败"),
    CODE_BANK_NULL("10023","未绑定银行卡"),
    CODE_BANK_REPETITION("10024","已绑定该银行卡"),
    CODE_AUTH_YES("10025","此身份证号已被认证"),
    //银行卡认证
    CODE_AUTH_MISMATCHING("10026","身份证号码不匹配"),
    CODE_REALNAME_MISMATCHING("10027","姓名不匹配"),
    CODE_BANK_EXCEPTION("10028","卡状态异常无效卡号");


    private String code;
    private String message;

    ResultDataType(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResultDataType get(String code){
        ResultDataType[] vs = ResultDataType.values();
        for(ResultDataType v : vs){
            if(code.equals(v.getCode())){
                return v;
            }
        }
        return null;
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
}
