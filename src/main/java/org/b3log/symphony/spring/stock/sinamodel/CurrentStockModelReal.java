package org.b3log.symphony.spring.stock.sinamodel;


import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class CurrentStockModelReal {

    private String stockName;
    private String currentDayOpenQuotationPrize;
    private String lastDayCloseQuotationPrize;
    private String currentPrize;
    private String todayHighPrize;
    private String todayLowPrize;
    private String currentBidPrize;
    private String currentSellPrize;
    private String dealStockNumber;
    private String dealStockAmountOfMoney;
    private String bid1StockNumber;
    private String bid1StockPrice;
    private String bid2StockNumber;
    private String bid2StockPrice;
    private String bid3StockNumber;
    private String bid3StockPrice;
    private String bid4StockNumber;
    private String bid4StockPrice;
    private String bid5StockNumber;
    private String bid5StockPrice;

    private String sell1StockNumber;
    private String sell1StockPrice;
    private String sell2StockNumber;
    private String sell2StockPrice;
    private String sell3StockNumber;
    private String sell3StockPrice;
    private String sell4StockNumber;
    private String sell4StockPrice;
    private String sell5StockNumber;
    private String sell5StockPrice;
    private String stockDate;
    private String stockHour;
    private String stockStatus;

// var hq_str_sh600000="
// 浦发银行, 名字
// 11.470,  开盘
// 11.470,  昨收
// 11.490,  当前
// 11.560,  最高
// 11.430,  最低
// 11.490,  竞买买一
// 11.500,  竞卖卖一
// 26273690, 今日成交股票数
// 301752036.000,  今日成交金额
// 279000, 买一股票数
// 11.490, 买一价格
// 93500, 买二股票数
// 11.480, 买二价格
// 215981, 买三股票数
// 11.470, 买三价格
// 195300, 买四股票数
// 11.460, 买四价格
// 249600, 买五股票数
// 11.450, 买五价格
// 39605, 卖一股票数
// 11.500, 卖一价格
// 333800, 卖二股票数
// 11.510, 卖二价格
// 387930, 卖三股票数
// 11.520, 卖三价格
// 245251, 卖四股票数
// 11.530, 卖四价格
// 270109, 卖五股票数
// 11.540, 卖五价格
// 2019-04-12,15:00:00,00"; 时间





    public static  void main(String[] args){

        String responseData = "var hq_str_sh600000=\"浦发银行,11.470,11.470,11.490,11.560,11.430,11.490,11.500,26273690,301752036.000,279000,11.490,93500,11.480,215981,11.470,195300,11.460,249600,11.450,39605,11.500,333800,11.510,387930,11.520,245251,11.530,270109,11.540,2019-04-12,15:00:00,00\";\n";
        List<CurrentStockModel> currentStockModels = CurrentStockModel.parseCurrentStockModel(responseData);

        List<CurrentStockModelReal> currentStockModelReals = new ArrayList<>();

        for (CurrentStockModel model : currentStockModels) {

            //获取参数类
            Class cls = model.getClass();
            //methods
            Method[] methods = cls.getDeclaredMethods();

            //目标
            CurrentStockModelReal currentStockModelReal = new CurrentStockModelReal();
            //获取目标参数类
            Class clsReal = currentStockModelReal.getClass();

            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                method.setAccessible(true);
                try {
                    //methods
                    Method[] methodsReal = clsReal.getDeclaredMethods();
                    for (int n = 0; n < methodsReal.length; n++) {
                        Method methodReal = methodsReal[n];
                        methodReal.setAccessible(true);
                        try {
                            if ( method.getName().contains(methodReal.getName())
                                    && methodReal.getName().contains("set")) {
                                Method methodTemp = cls.getDeclaredMethod(method.getName().replace("set","get"));
                                methodReal.invoke(currentStockModelReal, methodTemp.invoke(model));
                            }
                        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                            // TODO Auto-generated catch block
                            System.out.println("数据解析为类异常: " + e.getMessage());
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            System.out.println("数据解析为类异常: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }

                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    System.out.println("数据解析为类异常: " + e.getMessage());
                    e.printStackTrace();
                }
            }


            currentStockModelReals.add(currentStockModelReal);


        }


        for (CurrentStockModelReal currentStockModel : currentStockModelReals ){
            System.out.println("真实CurrentStockModelReal最终值：" + currentStockModel.toString());
        }
    }




    public static  List<CurrentStockModelReal> parseStockData(String hqNetWorkData){

        List<CurrentStockModel> currentStockModels = CurrentStockModel.parseCurrentStockModel(hqNetWorkData);
        List<CurrentStockModelReal> currentStockModelReals = new ArrayList<>();
        for (CurrentStockModel model : currentStockModels) {
            //获取参数类
            Class cls = model.getClass();
            //methods
            Method[] methods = cls.getDeclaredMethods();
            //目标
            CurrentStockModelReal currentStockModelReal = new CurrentStockModelReal();
            //获取目标参数类
            Class clsReal = currentStockModelReal.getClass();

            for (int i = 0; i < methods.length; i++) {
                Method method = methods[i];
                method.setAccessible(true);
                try {
                    //methods
                    Method[] methodsReal = clsReal.getDeclaredMethods();
                    for (int n = 0; n < methodsReal.length; n++) {
                        Method methodReal = methodsReal[n];
                        methodReal.setAccessible(true);
                        try {
                            if ( method.getName().contains(methodReal.getName())
                                    && methodReal.getName().contains("set")) {
                                Method methodTemp = cls.getDeclaredMethod(method.getName().replace("set","get"));
                                methodReal.invoke(currentStockModelReal, methodTemp.invoke(model));
                            }
                        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                            // TODO Auto-generated catch block
                            System.out.println("数据解析为类异常: " + e.getMessage());
                            e.printStackTrace();
                        } catch (NoSuchMethodException e) {
                            System.out.println("数据解析为类异常: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }

                } catch (IllegalArgumentException e) {
                    // TODO Auto-generated catch block
                    System.out.println("数据解析为类异常: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            currentStockModelReals.add(currentStockModelReal);
        }


        for (CurrentStockModelReal currentStockModel : currentStockModelReals ){
            System.out.println("真实CurrentStockModelReal最终值：" + currentStockModel.toString());
        }
        return currentStockModelReals;
    }


    public String toJson(){
        Map<String,String> json = new HashMap<>();
        json.put("bid1StockNumber",this.bid1StockNumber);
        json.put("bid1StockPrice",this.bid1StockPrice);
        json.put("bid2StockNumber",this.bid2StockNumber);
        json.put("bid2StockPrice",this.bid2StockPrice);
        json.put("bid3StockNumber",this.bid3StockNumber);
        json.put("bid3StockPrice",this.bid3StockPrice);
        json.put("bid4StockNumber",this.bid4StockNumber);
        json.put("bid4StockPrice",this.bid4StockPrice);
        json.put("bid5StockNumber",this.bid5StockNumber);
        json.put("bid5StockPrice",this.bid5StockPrice);

        json.put("sell1StockNumber",this.sell1StockNumber);
        json.put("sell1StockPrice",this.sell1StockPrice);
        json.put("sell2StockNumber",this.sell2StockNumber);
        json.put("sell2StockPrice",this.sell2StockPrice);
        json.put("sell3StockNumber",this.sell3StockNumber);
        json.put("sell3StockPrice",this.sell3StockPrice);
        json.put("sell4StockNumber",this.sell4StockNumber);
        json.put("sell4StockPrice",this.sell4StockPrice);
        json.put("sell5StockNumber",this.sell5StockNumber);
        json.put("sell5StockPrice",this.sell5StockPrice);
        json.put("currentDate",this.stockDate+this.stockHour);

        return JSON.toJSONString(json);
    }

}
