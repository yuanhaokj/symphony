#网易财经
------------

## 1 优点：
速度快；JSON容易处理。

------------

## 2 缺点：
不能获取分钟线数据。

------------

## 3 方法1：
http://img1.money.126.net/data/[沪深拼音]/time/today/[股票代码].json

返回结果：当日分时图数据；JSON数据；分时图获取数据依次是count节点数量、symbol股票代码、name股票名称、data数据，其中数据依次是小时分钟时间、价格、均价、成交量。

注意，沪深拼音为简写hs，以此可以推断出其他市场也可以获取，具体请自行判断研究。

例如，http://img1.money.126.net/data/hs/time/today/1399001.json，返回深证成指当日分时图数据。

------------

## 4 方法2：
http://img1.money.126.net/data/hs/time/4days/[股票代码].json

返回结果：获取4天分时数据；和上述分时图相似，但数据是连续4天的数据，不包括当天的数据。

------------

## 5 方法3：
http://img1.money.126.net/data/[沪深拼音]/[是否复权]/day/history/[年份]/[股票代码].json

返回结果：获取日线数据。

其中，是否复权，不复权为kline，复权为klinederc。

例如，http://img1.money.126.net/data/hs/kline/day/history/2015/1399001.json，获取深证成指2015年所有日线数据。

------------

## 6 方法4：
http://img1.money.126.net/data/[沪深拼音]/[是否复权]/[周期]/times/[股票代码].json

返回结果：获取日线所有时间节点和收盘价。

其中，[是否复权]，不复权为kline，复权为klinederc。

其中，[周期]，day为日数据，week周数据，month月数据。

例如，http://img1.money.126.net/data/hs/kline/day/times/1399001.json，获取深证成指所有时间节点数据。

------------

## 7方法5：
http://quotes.money.163.com/cjmx/[今年年份]/[日期]/[股票代码].xls

返回结果：获取历史成交明细；XLS文件。

注意，只能获取5日内的数据，再之前的数据不会存在。

注意，该方法为网易公开获取数据方法，推荐使用。

例如，http://quotes.money.163.com/cjmx/2015/20150611/0601857.xls，获取0601857股票的2015年6月11日历史成交明细XLS文件。

------------

## 8 方法6：
http://quotes.money.163.com/service/chddata.html?code=[股票代码]&start=[开始日期]&end=[结束日期]&fields=[自定义列]

返回结果：历史股价及相关情况；CSV文件。

注意，该方法为网易公开方法，推荐使用。

其中，自定义列可定义TCLOSE收盘价 ;HIGH最高价;LOW最低价;TOPEN开盘价;LCLOSE前收盘价;CHG涨跌额;PCHG涨跌幅;TURNOVER换手率;VOTURNOVER成交量;VATURNOVER成交金额;TCAP总市值;MCAP流通市值这些值。

例如，http://quotes.money.163.com/service/chddata.html?code=0601857&start=20071105&end=20150618&fields=TCLOSE;HIGH;LOW;TOPEN;LCLOSE;CHG;PCHG;TURNOVER;VOTURNOVER;VATURNOVER;TCAP;MCAP，获取0601857从2007-11-05到2015-06-18区间的数据。