package org.b3log.symphony.spring.stock.sinamodel;


import lombok.Data;

import java.lang.reflect.Field;

@Data
public class HistroyStockParams {

//    symbol=sz000001&scale=5&ma=5&datalen=1023

    private String symbol;
    private String scale;
    private String ma;
    private Integer datalen;


    public String toUrlString() {
        String result = "";
        HistroyStockParams histroyStockParams = this;
        //获取参数类
        Class cls = histroyStockParams.getClass();
        //将参数类转换为对应属性数量的Field类型数组（即该类有多少个属性字段 N 转换后的数组长度即为 N）
        Field[] fields = cls.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field f = fields[i];
            f.setAccessible(true);
            try {
                result = result + f.getName() + "=" + f.get(histroyStockParams);
                result = result + "&";
            } catch (IllegalArgumentException | IllegalAccessException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                result = "symbol=sz000001&scale=5&ma=5&datalen=1023";
            }

        }
        return result;
    }


}
