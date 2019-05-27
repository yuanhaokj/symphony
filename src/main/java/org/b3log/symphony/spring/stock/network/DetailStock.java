package org.b3log.symphony.spring.stock.network;

import okhttp3.*;

import java.io.IOException;

public class DetailStock {


    public static final String SHANGZHENG_STOCK_PREFIX="http://hq.sinajs.cn/list=";

    public static final String SHENZHENG_CHENG_ZHI="sz399001";

    public static final String SHANGZHENG_ZHONG_ZHI="sh000001";


    public static final String HISTORY_STOCK="http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?";

    public static OkHttpClient client = new OkHttpClient();

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public static String get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    public static String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


}
