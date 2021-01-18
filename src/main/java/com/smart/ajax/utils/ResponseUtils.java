package com.smart.ajax.utils;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResponseUtils {
    public static final String CONTENT_TYPE_JSON = "application/json;charset=utf-8";
    public static void resp(HttpServletResponse response, ResponseEntity entity) throws IOException {
        /* 允许跨域的主机地址 */
        response.setHeader("Access-Control-Allow-Origin", "*");
        /* 允许跨域的请求方法GET, POST, HEAD 等 */
        response.setHeader("Access-Control-Allow-Methods", "*");
        /* 重新预检验跨域的缓存时间 (s) */
        response.setHeader("Access-Control-Max-Age", "3600");
        /* 允许跨域的请求头 */
        response.setHeader("Access-Control-Allow-Headers", "*");
        /* 是否携带cookie */
        response.setHeader("Access-Control-Allow-Credentials", "true");

        //设置响应回前端的json数据的字符集格式
        response.setContentType(CONTENT_TYPE_JSON);
        //解析json数据，将json数据响应回前端。
        response.getWriter().print(JSONObject.toJSONString(entity));
    }
}
