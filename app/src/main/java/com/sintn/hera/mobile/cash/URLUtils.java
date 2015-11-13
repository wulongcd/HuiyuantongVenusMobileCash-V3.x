package com.sintn.hera.mobile.cash;

/**
 * @Desc: URL接口路径常量
 * @com.sintn.hera.mobile.cash
 * @HuiyuantongVenusShopCash-V3.x
 * @URLUtils.java
 * @Author:Wxl@Sintn.Inc
 * @2015-5-12下午3:06:18
 */
public class URLUtils {
    // 发布
    public static String HOST = "http://www.sintn.com";
//    public static String HOST = "http://192.168.0.111:8080";

    // 根工程目录
    public static String COMMON_URL = HOST + "/venus";
    // 注册设备
    public static String URL_REGIST_DEVICE = COMMON_URL + "/boss/enterpriseManagerAccount/registerDevice";
    // 上传系统重要BUG
    public static String URL_POST_APPLICTION_ERROR = COMMON_URL + "/systemBackend/clientErrorLog/create";
    // 检测版本
    public static String URL_GET_APPVERSION_QUERYLATEST = COMMON_URL + "/systembackend/appVersion/queryLatest/%s/%s";///systembackend/appVersion/queryLatest/{appType}/{osType}
    // 登陆
    public static String URL_SHOPMANAGERACCOUNT_LOGIN_IN = COMMON_URL + "/cashierApp/shopManagerAccount/login";
    // 登出
    public static String URL_SHOPMANAGERACCOUNT_LOGIN_OUT = COMMON_URL + "/cashierApp/shopManagerAccount/logout";
    // 创建订单
    public static String URL_ORDER_CREATE = COMMON_URL + "/cashierApp/order/create";
    // 查询订单记录
    public static String URL_ORDER_QUERY = COMMON_URL + "/cashierApp/order/query";
    // 查询订单记录
    public static String URL_ORDER_QUERYTOTALMONEY = COMMON_URL + "/cashierApp/order/queryTotalMoney";
    // 查询订单状态
    public static String URL_ORDER_QUERY_STATUS = COMMON_URL + "/cashierApp/order/queryOrderStatus/%s";
    // 获取一级行业列表
    public static String URL_POST_QUERY_FIRST_CATEGORY_LIST = COMMON_URL + "/cashierApp/category/queryCategory1";
    // 获取二级行业列表
    public static String URL_POST_QUERY_SECOND_CATEGORY_LIST = COMMON_URL + "/cashierApp/category/queryCategory2";
    // 获取验证码
    public static String URL_POST_GET_VERIFICATION_CODE = COMMON_URL + "/cashierApp/shopManagerAccount/getIC";
    // 注册企业
    public static String URL_POST_REGISTER_ENTERPRISE = COMMON_URL + "/cashierApp/enterprise/register";
    // 查询企业信息
    public static String URL_GET_QUERY_ENTERPRISE_INFO = COMMON_URL + "/cashierApp/enterprise/query";
    // 更新企业信息
    public static String URL_POST_UPDATE_ENTERPRISE_INFO = COMMON_URL + "/cashierApp/enterprise/update";
    // 查询店铺列表
    public static String URL_POST_QUERY_SHOP_LIST = COMMON_URL + "/cashierApp/shop/query";
    // 添加店铺
    public static String URL_POST_ADD_SHOP = COMMON_URL + "/cashierApp/shop/create";
    // 更新店铺
    public static String URL_POST_UPDATE_SHOP_INFO = COMMON_URL + "/cashierApp/shop/update";
    // 查询管理员列表
    public static String URL_POST_QUERY_SHOP_CASHIER_LIST = COMMON_URL + "/cashierApp/shopManagerAccount/query";
    // 添加管理员
    public static String URL_POST_ADD_SHOP_CASHIER = COMMON_URL + "/cashierApp/shopManagerAccount/create";
    // 删除管理员
    public static String URL_GET_DELETE_SHOP_CASHIER = COMMON_URL + "/cashierApp/shopManagerAccount/remove";
    // 更新管理员
    public static String URL_POST_UPDATE_SHOP_CASHIER = COMMON_URL + "/cashierApp/shopManagerAccount/update";
    // 查询银行列表
    public static String URL_POST_QUERY_BANK_LIST = COMMON_URL + "/cashierApp/bank/query";
    // 查询提现账户列表
    public static String URL_POST_QUERY_BANDING_BANK_LIST = COMMON_URL + "/cashierApp/bindingBankCard/query";
    // 添加提现账户
    public static String URL_POST_ADD_BANDING_BANK = COMMON_URL + "/cashierApp/bindingBankCard/create";
    // 删除提现账户
    public static String URL_GET_DELETE_BANDING_BANK = COMMON_URL + "/cashierApp/bindingBankCard/remove";
    // 查询企业到账金额
    public static String URL_GET_QUERY_BANLANCE = COMMON_URL + "/cashierApp/wallet/queryBalance";
    // 提现
    public static String URL_POST_QUERY_WITHDRAW = COMMON_URL + "/cashierApp/wallet/withdraw";
    // 设置体现密码
    public static String URL_POST_SET_WITHDRAW_PASSWORD = COMMON_URL + "/cashierApp/wallet/setWithdrawPassword";

    /**
     * 初始化服务器地址
     *
     * @param host
     */
    public static void initURServer(String host) {
        HOST = host;
        // 根工程目录
        COMMON_URL = HOST + "/venus";
        // 注册设备
        URL_REGIST_DEVICE = COMMON_URL + "/boss/enterpriseManagerAccount/registerDevice";
        // 上传系统重要BUG
        URL_POST_APPLICTION_ERROR = COMMON_URL + "/systemBackend/clientErrorLog/create";
        // 检测版本
        URL_GET_APPVERSION_QUERYLATEST = COMMON_URL + "/systembackend/appVersion/queryLatest/%s/%s";///systembackend/appVersion/queryLatest/{appType}/{osType}
        // 登陆
        URL_SHOPMANAGERACCOUNT_LOGIN_IN = COMMON_URL + "/cashierApp/shopManagerAccount/login";
        // 登出
        URL_SHOPMANAGERACCOUNT_LOGIN_OUT = COMMON_URL + "/cashierApp/shopManagerAccount/logout";
        // 创建订单
        URL_ORDER_CREATE = COMMON_URL + "/cashierApp/order/create";
        // 查询订单记录
        URL_ORDER_QUERY = COMMON_URL + "/cashierApp/order/query";
        // 查询订单记录
        URL_ORDER_QUERYTOTALMONEY = COMMON_URL + "/cashierApp/order/queryTotalMoney";
        // 查询订单状态
        URL_ORDER_QUERY_STATUS = COMMON_URL + "/cashierApp/order/queryOrderStatus/%s";
        // 获取一级行业列表
        URL_POST_QUERY_FIRST_CATEGORY_LIST = COMMON_URL + "/cashierApp/category/queryCategory1";
        // 获取二级行业列表
        URL_POST_QUERY_SECOND_CATEGORY_LIST = COMMON_URL + "/cashierApp/category/queryCategory2";
        // 获取眼中码
        URL_POST_GET_VERIFICATION_CODE = COMMON_URL + "/cashierApp/shopManagerAccount/getIC";
        // 注册企业
        URL_POST_REGISTER_ENTERPRISE = COMMON_URL + "/cashierApp/enterprise/register";
        // 查询企业信息
        URL_GET_QUERY_ENTERPRISE_INFO = COMMON_URL + "/cashierApp/enterprise/query";
        // 更新企业信息
        URL_POST_UPDATE_ENTERPRISE_INFO = COMMON_URL + "/cashierApp/enterprise/update";
        // 查询店铺列表
        URL_POST_QUERY_SHOP_LIST = COMMON_URL + "/cashierApp/shop/query";
        // 添加店铺
        URL_POST_ADD_SHOP = COMMON_URL + "/cashierApp/shop/create";
        // 更新店铺
        URL_POST_UPDATE_SHOP_INFO = COMMON_URL + "/cashierApp/shop/update";
        // 查询管理员列表
        URL_POST_QUERY_SHOP_CASHIER_LIST = COMMON_URL + "/cashierApp/shopManagerAccount/query";
        // 添加管理员
        URL_POST_ADD_SHOP_CASHIER = COMMON_URL + "/cashierApp/shopManagerAccount/create";
        // 删除管理员
        URL_GET_DELETE_SHOP_CASHIER = COMMON_URL + "/cashierApp/shopManagerAccount/remove";
        // 更新管理员
        URL_POST_UPDATE_SHOP_CASHIER = COMMON_URL + "/cashierApp/shopManagerAccount/update";
        // 查询银行列表
        URL_POST_QUERY_BANK_LIST = COMMON_URL + "/cashierApp/bank/query";
        // 查询提现账户列表
        URL_POST_QUERY_BANDING_BANK_LIST = COMMON_URL + "/cashierApp/bindingBankCard/query";
        // 添加提现账户
        URL_POST_ADD_BANDING_BANK = COMMON_URL + "/cashierApp/bindingBankCard/create";
        // 删除提现账户
        URL_GET_DELETE_BANDING_BANK = COMMON_URL + "/cashierApp/bindingBankCard/remove";
        // 查询企业到账金额
        URL_GET_QUERY_BANLANCE = COMMON_URL + "/cashierApp/wallet/queryBalance";
        // 体现
        URL_POST_QUERY_WITHDRAW = COMMON_URL + "/cashierApp/wallet/withdraw";
        // 设置体现密码
        URL_POST_SET_WITHDRAW_PASSWORD = COMMON_URL + "/cashierApp/wallet/setWithdrawPassword";
    }
}
