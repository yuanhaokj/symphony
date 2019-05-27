package org.b3log.symphony.spring.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name="stock_real_detail")
public class StockRealDetailModel {

    @Id
    @Column(length = 64)
    private String id;

    @Column(name="stock_num",length = 20)
    private String stockNum;

    @Column(name="stock_name",length = 64)
    private String stockName;

    @Column(name="date_time")
    private Date dateTime;

    @Column(name="real_time_data",length = 64)
    private String realTimeData;

    @Column(name="date_batch",length = 32)
    private String dateBatch;

}
