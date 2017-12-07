package com.android.volley.utils;

import com.alibaba.fastjson.JSON;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import org.json.JSONObject;

/**
 * 类描述：
 * 创建人：swallow.li
 * 创建时间：
 * Email: swallow.li@kemai.cn
 * 修改备注：
 */
public abstract class VolleyListenerInterface {

    public static Response.Listener<String> mListener;
    public static Response.Listener<JSONObject> mFileListener;
    public static Response.ErrorListener mErrorListener;

    public VolleyListenerInterface() {
    }

    // 请求成功时的回调函数
    public abstract void onSuccess(Object result);

    // 请求失败时的回调函数
    public abstract void onError(Exception error);

    // 创建请求的事件监听
    public Response.Listener<String> responseListener(final Class<?> aClass) {
        mListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                try {
                    if (null != aClass)
                        onSuccess(JSON.parseObject(s, aClass));
                    else
                        onSuccess(s);
                } catch (Exception e) {
                    onError(e);
                }
            }
        };
        return mListener;
    }

    public Response.Listener<JSONObject> responseListener() {
        mFileListener = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject s) {
                try {
                    onSuccess(s);
                } catch (Exception e) {
                    onError(e);
                }
            }
        };
        return mFileListener;
    }

    // 创建请求失败的事件监听
    public Response.ErrorListener errorListener() {
        mErrorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                onError(volleyError);
            }
        };
        return mErrorListener;
    }

}
