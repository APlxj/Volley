package com.android.volley.utils;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public class RequestUtil {

    public static StringRequest stringRequest;
    public static int sTimeOut = 30000;

    /**
     * 获取GET请求内容
     * 参数：
     *
     * @param url：请求的url地址；
     * @param tag：当前请求的标签；
     * @param volleyListenerInterface：VolleyListenerInterface接口；
     * @param timeOutDefaultFlg：是否使用Volley默认连接超时；
     */
    public static void get(RequestQueue queue, String url, String tag,
                           VolleyListenerInterface volleyListenerInterface,
                           boolean timeOutDefaultFlg, Class<?> aClass) {
        // 清除请求队列中的tag标记请求
        queue.cancelAll(tag);
        // 创建当前的请求，获取字符串内容
        stringRequest = new StringRequest(Request.Method.GET, url,
                volleyListenerInterface.responseListener(aClass), volleyListenerInterface.errorListener());
        // 为当前请求添加标记
        stringRequest.setTag(tag);
        // 默认超时时间以及重连次数
        int myTimeOut = timeOutDefaultFlg ? DefaultRetryPolicy.DEFAULT_TIMEOUT_MS : sTimeOut;
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(myTimeOut,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // 将当前请求添加到请求队列中
        queue.add(stringRequest);
        // 重启当前请求队列
        queue.start();
    }


    /**
     * 获取POST请求内容（请求的代码为Map）
     * 参数：
     *
     * @param url：请求的url地址；
     * @param tag：当前请求的标签；
     * @param params：POST请求内容；
     * @param volleyListenerInterface：VolleyListenerInterface接口；
     * @param timeOutDefaultFlg：是否使用Volley默认连接超时；
     */
    public static void post(RequestQueue queue, String url, String tag,
                            final Map<String, String> params,
                            VolleyListenerInterface volleyListenerInterface,
                            boolean timeOutDefaultFlg, Class<?> aClass) {
        // 清除请求队列中的tag标记请求
        queue.cancelAll(tag);
        // 创建当前的POST请求，并将请求内容写入Map中
        stringRequest = new StringRequest(Request.Method.POST, url,
                volleyListenerInterface.responseListener(aClass), volleyListenerInterface.errorListener()) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                return params;
            }
        };
        // 为当前请求添加标记
        stringRequest.setTag(tag);
        // 默认超时时间以及重连次数
        int myTimeOut = timeOutDefaultFlg ? DefaultRetryPolicy.DEFAULT_TIMEOUT_MS : sTimeOut;
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(myTimeOut,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        // 将当前请求添加到请求队列中
        queue.add(stringRequest);
        // 重启当前请求队列
        queue.start();
    }
}