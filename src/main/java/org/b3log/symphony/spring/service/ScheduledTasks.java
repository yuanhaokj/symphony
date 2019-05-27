package org.b3log.symphony.spring.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.b3log.symphony.spring.dao.StockRealDetailDao;
import org.b3log.symphony.spring.model.StockRealDetailModel;
import org.b3log.symphony.spring.stock.network.DetailStock;
import org.b3log.symphony.spring.stock.sinamodel.CurrentStockModelReal;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.cache.interceptor.SimpleKeyGenerator;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Component
@Configurable
@EnableScheduling
public class ScheduledTasks{

    private static final Logger LOG = LoggerFactory.getLogger(ScheduledTasks.class);

    private static boolean isNeedStart = false;

    @Autowired
    private StockRealDetailDao stockRealDetailDao;

    @Scheduled(fixedRate = 1000 * 3600 * 24)
    public void reportCurrentTime(){
        LOG.info("Scheduling Tasks Examples: The time is now " + dateFormat ().format (new Date ()));
        if(isNeedStart) {
            String stockRealTime = null;
            String stockCode = "sh600000";
            Date current = new Date();
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            gregorianCalendar.setTime(current);
            String currentDateBatch = String.valueOf(gregorianCalendar.get(GregorianCalendar.YEAR)) +
                    gregorianCalendar.get(GregorianCalendar.MONTH) + gregorianCalendar.get(GregorianCalendar.DATE);
            System.out.println(currentDateBatch);
            try {
                stockRealTime = DetailStock.get(DetailStock.SHANGZHENG_STOCK_PREFIX + stockCode);
                List<CurrentStockModelReal> currentStockModelReals = CurrentStockModelReal.parseStockData(stockRealTime);

                StockRealDetailModel model;
                if (stockRealDetailDao.findListByStockCodeAndDateBatch(stockCode, currentDateBatch) != null) {
                    model = stockRealDetailDao.findListByStockCodeAndDateBatch(stockCode, currentDateBatch);
                    String temp = model.getRealTimeData();

                    JSONArray jsonArray = JSONArray.parseArray(temp);
                    jsonArray.add(JSON.parseObject(currentStockModelReals.get(0).toJson()));
                    model.setRealTimeData(
                            JSONArray.toJSONString(jsonArray)
                    );
                    stockRealDetailDao.save(model);
                } else {
                    if (currentStockModelReals.size() > 0) {
                        model = new StockRealDetailModel();
                        model.setStockNum(stockCode);
                        model.setDateBatch(currentDateBatch);
                        model.setDateTime(new Date());
                        model.setId(SimpleKeyGenerator.generateKey(64).toString().toLowerCase());
                        model.setStockName(currentStockModelReals.get(0).getStockName());
                        JSONArray ja = new JSONArray();
                        ja.add(JSON.parseObject(currentStockModelReals.get(0).toJson()));

                        model.setRealTimeData(
                                JSONArray.toJSONString(ja)
                        );
                        stockRealDetailDao.save(model);
                    }
                }


            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //每1秒执行一次
    @Scheduled(cron = "0 30 9 * * ?")
    public void reportCurrentByCron9(){
        isNeedStart = true;
        LOG.info("Scheduling Tasks isNeedStart 9: " + isNeedStart);
        LOG.info("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date()));
    }

    @Scheduled(cron = "0 0 13 * * ?")
    public void reportCurrentByCron13(){
        isNeedStart = true;
        LOG.info("Scheduling Tasks isNeedStart 13: " + isNeedStart);
        LOG.info("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date()));
    }

    @Scheduled(cron = "0 30 11 * * ?")
    public void reportCurrentByCron11(){
        isNeedStart = false;
        LOG.info("Scheduling Tasks isNeedStart 11: " + isNeedStart);
        LOG.info("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date()));
    }

    @Scheduled(cron = "0 0 15 * * ?")
    public void reportCurrentByCron15(){
        isNeedStart = false;
        LOG.info("Scheduling Tasks isNeedStart 15: " + isNeedStart);
        LOG.info("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date()));
    }

//    @Scheduled(cron = "0/1 * * * * ?")
//    public void reportCurrentByCronS(){
//        LOG.info("Scheduling Tasks Examples By Cron: The time is now " + dateFormat ().format (new Date()));
//    }

    private SimpleDateFormat dateFormat(){
        return new SimpleDateFormat ("HH:mm:ss");
    }

}