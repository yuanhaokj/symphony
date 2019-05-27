package org.b3log.symphony.spring.stock.sinamodel;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.List;

public class HistroyStockModel {


    /**
     * day : 2019-04-04 14:55:00
     * open : 13.900
     * high : 13.950
     * low : 13.860
     * close : 13.870
     * volume : 3399450
     * ma_price5 : 14.118
     * ma_volume5 : 8792153
     */


    private String day;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String ma_price5;
    private String ma_volume5;
    /**
     * ma_price15 : 11.039
     * ma_volume15 : 20660255
     */

    private String ma_price15;
    private String ma_volume15;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getMa_price5() {
        return ma_price5;
    }

    public void setMa_price5(String ma_price5) {
        this.ma_price5 = ma_price5;
    }

    public String getMa_volume5() {
        return ma_volume5;
    }

    public void setMa_volume5(String ma_volume5) {
        this.ma_volume5 = ma_volume5;
    }

    @Override
    public String toString() {
        return "HistroyStockModel{" +
                "day='" + day + '\'' +
                ", open='" + open + '\'' +
                ", high='" + high + '\'' +
                ", low='" + low + '\'' +
                ", close='" + close + '\'' +
                ", volume='" + volume + '\'' +
                ", ma_price5='" + ma_price5 + '\'' +
                ", ma_volume5='" + ma_volume5 + '\'' +
                ", ma_price15='" + ma_price15 + '\'' +
                ", ma_volume15='" + ma_volume15 + '\'' +
                '}';
    }

    public static List<HistroyStockModel> parseStockData(String historyStockData){
        //Json的解析类对象
        JsonParser parser = new JsonParser();
        //将JSON的String 转成一个JsonArray对象
        JsonArray jsonArray = parser.parse(historyStockData).getAsJsonArray();

        Gson gson = new Gson();
        ArrayList<HistroyStockModel> historyStockModelList = new ArrayList<>();

        //加强for循环遍历JsonArray
        for (JsonElement element : jsonArray) {
            //使用GSON，直接转成Bean对象
            HistroyStockModel histroyStockModel = gson.fromJson(element, HistroyStockModel.class);
            historyStockModelList.add(histroyStockModel);
        }
        return historyStockModelList;
    }

    public String getMa_price15() {
        return ma_price15;
    }

    public void setMa_price15(String ma_price15) {
        this.ma_price15 = ma_price15;
    }

    public String getMa_volume15() {
        return ma_volume15;
    }

    public void setMa_volume15(String ma_volume15) {
        this.ma_volume15 = ma_volume15;
    }
}
