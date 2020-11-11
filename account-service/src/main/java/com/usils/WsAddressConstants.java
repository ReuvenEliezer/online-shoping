package com.usils;

public class WsAddressConstants {

    private static final String localhost = "http://localhost:";
    public static final String localAccountApp = localhost + "4000";


    public static final String accountLogicUrl = "/account/";
    public static final String accountFullUrl = localAccountApp + accountLogicUrl;
    public static final String userLogicUrl = "/user/";
    public static final String userFullUrl = localAccountApp + userLogicUrl;

}
