package org.b3log.symphony.spring.stock.sinamodel;


import lombok.Data;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Data
public class CurrentStockModel {

    private String stockNameIndex0;
    private String currentDayOpenQuotationPrizeIndex1;
    private String lastDayCloseQuotationPrizeIndex2;
    private String currentPrizeIndex3;
    private String todayHighPrizeIndex4;
    private String todayLowPrizeIndex5;
    private String currentBidPrizeIndex6;
    private String currentSellPrizeIndex7;
    private String dealStockNumberIndex8;
    private String dealStockAmountOfMoneyIndex9;
    private String bid1StockNumberIndex10;
    private String bid1StockPriceIndex11;
    private String bid2StockNumberIndex12;
    private String bid2StockPriceIndex13;
    private String bid3StockNumberIndex14;
    private String bid3StockPriceIndex15;
    private String bid4StockNumberIndex16;
    private String bid4StockPriceIndex17;
    private String bid5StockNumberIndex18;
    private String bid5StockPriceIndex19;

    private String sell1StockNumberIndex20;
    private String sell1StockPriceIndex21;
    private String sell2StockNumberIndex22;
    private String sell2StockPriceIndex23;
    private String sell3StockNumberIndex24;
    private String sell3StockPriceIndex25;
    private String sell4StockNumberIndex26;
    private String sell4StockPriceIndex27;
    private String sell5StockNumberIndex28;
    private String sell5StockPriceIndex29;
    private String stockDateIndex30;
    private String stockHourIndex31;
    private String stockStatusIndex32;

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
// 2019-04-12,15:00:00,  时间
// 00";


    public static void main(String[] args) {


        List<CurrentStockModel> currentStockModels = new ArrayList<>();

        String responseData = "var hq_str_sh600000=\"浦发银行,11.470,11.470,11.490,11.560,11.430,11.490,11.500,26273690,301752036.000,279000,11.490,93500,11.480,215981,11.470,195300,11.460,249600,11.450,39605,11.500,333800,11.510,387930,11.520,245251,11.530,270109,11.540,2019-04-12,15:00:00,00\";\n" +
                "var hq_str_sh600001=\"邯郸钢铁,0.000,0.000,0.000,0.000,0.000,0.000,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,0,0.000,2019-04-12,11:45:02,-3\";";
        String[] currentStocksInfo = responseData.split("\n");
        String pattern = "=\".*\"";

        for (String stock : currentStocksInfo) {

            // 创建 Pattern 对象
            Pattern r = Pattern.compile(pattern);

            // 现在创建 matcher 对象
            Matcher m = r.matcher(stock);
            if (m.find()) {
                System.out.println("Found value: " + m.group(0));
                String[] stockInfo = m.group(0).split(",");
                CurrentStockModel currentStockModel = new CurrentStockModel();
                //获取参数类
                Class cls = currentStockModel.getClass();
                for (int n = 0; n < stockInfo.length; n++) {
                    //methods
                    Method[] methods = cls.getDeclaredMethods();
                    for (int i = 0; i < methods.length; i++) {
                        Method method = methods[i];
                        method.setAccessible(true);
                        try {
                            if (method.getName().contains("set")
                                    && method.getName().contains("Index" + String.valueOf(n))) {
                                method.invoke(currentStockModel, stockInfo[n]);

                            }
                        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }
                currentStockModels.add(currentStockModel);
            } else {
                System.out.println("NO MATCH");
            }

        }


        for (CurrentStockModel stockModel : currentStockModels) {

            System.out.println("最终值：" + stockModel.toString());

//            //获取参数类
//            Class cls = stockModel.getClass();
//            //将参数类转换为对应属性数量的Field类型数组（即该类有多少个属性字段 N 转换后的数组长度即为 N）
//            Field[] fields = cls.getDeclaredFields();
//
//            List<String> methodNames = new ArrayList<>();
//
//            for (int i = 0; i < fields.length; i++) {
//                Field f = fields[i];
//                f.setAccessible(true);
//                try {
//                    //f.getName()得到对应字段的属性名，f.get(o)得到对应字段属性值,f.getGenericType()得到对应字段的类型
//                    methodNames.add(f.getName());
//                    System.out.println("属性名：" + f.getName() + "；属性值：" + f.get(stockModel) + ";字段类型：" + f.getGenericType());
//                } catch (IllegalArgumentException | IllegalAccessException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//            }

        }


    }


    public static List<CurrentStockModel> parseCurrentStockModel(String parseString) {

        List<CurrentStockModel> currentStockModels = new ArrayList<>();

        String[] currentStocksInfo = parseString.split("\n");
        String pattern = "=\".*\"";

        for (String stock : currentStocksInfo) {

            // 创建 Pattern 对象
            Pattern r = Pattern.compile(pattern);

            // 现在创建 matcher 对象
            Matcher m = r.matcher(stock);
            if (m.find()) {
                System.out.println("正则匹配数据为: " + m.group(0));
                String[] stockInfo = m.group(0).split(",");
                CurrentStockModel currentStockModel = new CurrentStockModel();
                //获取参数类
                Class cls = currentStockModel.getClass();
                for (int n = 0; n < stockInfo.length; n++) {
                    //methods
                    Method[] methods = cls.getDeclaredMethods();
                    for (int i = 0; i < methods.length; i++) {
                        Method method = methods[i];
                        method.setAccessible(true);
                        try {
                            if (method.getName().contains("set")
                                    && method.getName().contains("Index" + String.valueOf(n))) {
                                String value = "";
                                if (n == 0){
                                    value = stockInfo[n].replace("=\"","");
                                }else if (n == stockInfo.length - 1 ){
                                    value = stockInfo[n].replace("\"","");
                                }else {
                                    value = stockInfo[n];
                                }
                                method.invoke(currentStockModel, value);
                            }
                        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException e) {
                            // TODO Auto-generated catch block
                            System.out.println("数据解析为类异常: " + e.getMessage());
                            e.printStackTrace();
                        }
                    }
                }
                currentStockModels.add(currentStockModel);
            } else {
                System.out.println("数据结果格式错误，不匹配");
            }
        }

        for (CurrentStockModel stockModel : currentStockModels) {
            System.out.println("CurrentStockModel最终值：" + stockModel.toString());
        }

        return currentStockModels;
    }


}
