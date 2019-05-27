# 证券之星
------------

## 1 缺点：
只能获取80条数据。

------------

## 2 优点：
国内速度快；JSON返回容易解析。

------------

## 3 方法1：
HTTP://CQ.SSAJAX.CN/INTERACT/GETTRADEDATA.ASHX?PIC=QLPIC_[股票代码]_[市场]_[周期]
其中股票代码如000001；市场1表示沪，2表示深；周期6表示日，7表示周，8表示月。如：http://cq.ssajax.cn/interact/getTradedata.ashx?pic=qlpic_000001_1_6，获取上证指数的日线行情数据。

返回结果：JSON数据。

------------

## 4 方法2：
HTTP://CQ.SSAJAX.CN/INTERACT/GETTRADEDATA.ASHX?PIC=QMPIC_600308_1_6_N80