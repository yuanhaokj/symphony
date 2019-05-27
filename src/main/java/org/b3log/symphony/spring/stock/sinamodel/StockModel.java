package org.b3log.symphony.spring.stock.sinamodel;

import lombok.Data;

import java.util.List;

@Data
public class StockModel {

    private List<CurrentStockModelReal> currentStockModelReals;
    private List<HistroyStockModel> historyStockModels;
    private HistroyStockModel lastDayCloseStockModel;

}
