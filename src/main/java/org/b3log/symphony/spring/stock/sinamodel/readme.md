#新浪
------------

## 1 缺点：
历史股价数据不够完整，只能获取最近1023个数据节点。

------------

## 2 优点：
速度非常快；可以获取行情图片；返回JSON，容易处理；可以获取历史的分价图数据和分时买卖交易列。

------------

## 3 方法1：
HTTP://HQ.SINAJS.CN/LIST=[股票代码]
返回结果：JSON实时数据，以逗号隔开相关数据，数据依次是“股票名称、今日开盘价、昨日收盘价、当前价格、今日最高价、今日最低价、竞买价、竞卖价、成交股数、成交金额、买1手、买1报价、买2手、买2报价、…、买5报价、…、卖5报价、日期、时间”。

获取当前的股票行情，如http://hq.sinajs.cn/list=sh601006，注意新浪区分沪深是以sh和sz区分。

------------

## 4 方法2：
获取各个时间段行情图。
查看日K线图：http://image.sinajs.cn/newchart/daily/n/sh601006.gif分时线的查询：http://image.sinajs.cn/newchart/min/n/sh000001.gif日K线查询：http://image.sinajs.cn/newchart/daily/n/sh000001.gif周K线查询：http://image.sinajs.cn/newchart/weekly/n/sh000001.gif月K线查询：http://image.sinajs.cn/newchart/monthly/n/sh000001.gif

------------

## 5 方法3：
http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=[市场][股票代码]&scale=[周期]&ma=no&datalen=[长度]

返回结果：获取5、10、30、60分钟JSON数据；day日期、open开盘价、high最高价、low最低价、close收盘价、volume成交量；向前复权的数据。

注意，最多只能获取最近的1023个数据节点。

例如，http://money.finance.sina.com.cn/quotes_service/api/json_v2.php/CN_MarketData.getKLineData?symbol=sz002095&scale=60&ma=no&datalen=1023，获取深圳市场002095股票的60分钟数据，获取最近的1023个节点。

------------

## 6 方法4：
http://finance.sina.com.cn/realstock/company/[市场][股票代码]/[复权].js?d=[日期]

[复权]：qianfuquan-前复权；houfuquan-后复权。

返回结果：股票日期的股价JSON数据。

例如，http://finance.sina.com.cn/realstock/company/sz002095/qianfuquan.js?d=2015-06-16，获取深圳市场002095股票的前复权2015-06-16的数据。

注意，无法获取未复权的数据。

注意，需要对返回数据进行处理才能使用，新浪会在末尾加入注释语句，打乱日期数据，key值需要自行加入双引号，否则无法解析JSON。

注意，由于新浪的周线和月线数据，是以股票日线所有数据直接计算得到的，所以无法直接通过API获取周线和月线数据，需要自行处理。

------------

## 7 方法5：
http://market.finance.sina.com.cn/downxls.php?date=[日期]&symbol=[市场][股票代码]

返回数据：XLS文件；股票历史成交明细。

例如，http://market.finance.sina.com.cn/downxls.php?date=2015-06-15&symbol=sz002095，获取2015-06-15日期的深圳市长002095数据。

------------

## 8 方法6：
http://market.finance.sina.com.cn/pricehis.php?symbol=[市场][股票代码]&startdate=[开始日期]&enddate=[结束日期]

返回数据：HTML文本；指定日期范围内的股票分价表。

例如，http://market.finance.sina.com.cn/pricehis.php?symbol=sh600900&startdate=2011-08-17&enddate=2011-08-19，获取上证600900股票2011-08-17到2011-08-19日期的分价数据。