package com.example.concerto.utils;

import okhttp3.OkHttpClient;

import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.FormBody;

/**
 * Created by lbw on 2021/5/12
 */
public class OkhttpUtils {
    //创建OkHttpClient对象
    private final OkHttpClient client = new OkHttpClient();

    //登录验证的方法
    public String Login(String username, String password) {
        //创建请求体并传递参数
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();
        //创建Request对象
        Request request = new Request.Builder()
                .url("http://1.15.141.65:8080/login")
                .addHeader("token","...")
                .post(formBody)
                .build();
        //获取Response对象
        try (Response response = client.newCall(request).execute()) {
            //响应成功并返回响应内容
            if (response.isSuccessful()) {
                return response.body().string();
                //此时代码执行在子线程，修改UI的操作使用handler跳转到UI线程
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //响应失败返回" "
        return " ";
    }

    //注册验证的方法
    public String Register(String username, String password) {
        RequestBody formBody = new FormBody.Builder()
                .add("username", username)
                .add("password", password)
                .build();
        Request request = new Request.Builder()
                .url("http://1.15.141.65:8080/register")
                .post(formBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return " ";
    }
}