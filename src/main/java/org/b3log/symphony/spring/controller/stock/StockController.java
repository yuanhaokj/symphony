package org.b3log.symphony.spring.controller.stock;



import org.b3log.symphony.spring.stock.network.DetailStock;
import org.b3log.symphony.spring.stock.sinamodel.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("api/stock/")
public class StockController {


    private static Logger logger = LoggerFactory.getLogger(StockController.class);

    /**
     * 股票历史数据
     * @param symbol
     * @param ma
     * @param scale
     * @param datalen
     * @param request
     * @param model
     * @param resp
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "detail", method = RequestMethod.GET)
    public StockModel unitQueryByCode(
            @RequestParam(value = "symbol", defaultValue = "sz000001") String symbol,
            @RequestParam(value = "ma", defaultValue = "5") String ma,
            @RequestParam(value = "scale", defaultValue = "5") String scale,
            @RequestParam(value = "date", defaultValue = "20190412") String date,
            @RequestParam(value = "datalen", defaultValue = "1023") Integer datalen,
            HttpServletRequest request,
            Model model,
            HttpServletResponse resp)
            throws Exception {
        StockModel stockModel = new StockModel();
        HistroyStockParams histroyStockParams = new HistroyStockParams();
        histroyStockParams.setDatalen(datalen);
        histroyStockParams.setMa(ma);
        histroyStockParams.setSymbol(symbol);
        histroyStockParams.setScale(scale);
        System.out.println(histroyStockParams.toUrlString());

        String history = DetailStock.get(SinaConstantURL.HISTORY_STOCK + histroyStockParams.toUrlString());

        List<HistroyStockModel> historyStockModels = HistroyStockModel.parseStockData(history);


        List<HistroyStockModel> historyStockModelsForBack = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
        Date currentDate = dateFormat.parse(date);
        Date lastDate = new Date(currentDate.getTime() - 24*3600*1000L + 15*3600*1000L - 20*1000L);
        for (HistroyStockModel histroyStockModel : historyStockModels){
            SimpleDateFormat dateFormatTemp = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Date dateCurrent = dateFormatTemp.parse(histroyStockModel.getDay());
            //时间小于24小时
            long dateFromNet = dateCurrent.getTime();
            long dateFromParm = currentDate.getTime();
            long dateCalucate = dateFromNet - dateFromParm;
            if ( dateCalucate >= 0 && dateCalucate < 24*3600*1000L){
                historyStockModelsForBack.add(histroyStockModel);
            }

            long dateFromNetTemp = dateFromNet - lastDate.getTime();
            if ( dateFromNetTemp >= 0 && dateFromNetTemp < 50*1000L){
                stockModel.setLastDayCloseStockModel(histroyStockModel);
            }
        }

        //返回back值
        stockModel.setHistoryStockModels(historyStockModelsForBack);

        String stockRealTime = DetailStock.get(DetailStock.SHANGZHENG_STOCK_PREFIX +symbol);
        List<CurrentStockModelReal> currentStockModelReals =  CurrentStockModelReal.parseStockData(stockRealTime);
        stockModel.setCurrentStockModelReals(currentStockModelReals);
        return stockModel;
    }

}
