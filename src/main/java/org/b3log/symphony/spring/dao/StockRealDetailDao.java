package org.b3log.symphony.spring.dao;


import org.b3log.symphony.spring.model.StockRealDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface StockRealDetailDao extends JpaRepository<StockRealDetailModel,String>, JpaSpecificationExecutor<StockRealDetailModel> {

    @Query("select p from StockRealDetailModel p where p.stockName=:stockName ")
    StockRealDetailModel findListByStockName(@Param("stockName") String stockName);

    @Query("select p from StockRealDetailModel p where p.stockNum=:stockNum ")
    StockRealDetailModel findListByStockCode(@Param("stockNum") String stockNum);

    @Query("select p from StockRealDetailModel p where p.stockNum=:stockNum and p.dateBatch=:dateBatch")
    StockRealDetailModel findListByStockCodeAndDateBatch(@Param("stockNum") String stockNum, @Param("dateBatch") String dateBatch);

}