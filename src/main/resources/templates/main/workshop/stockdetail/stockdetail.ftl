<!DOCTYPE html>
<html style="height: 100%">
<head>
    <meta charset="utf-8">
    <title>StockDetail</title>
    <meta http-equiv="x-ua-compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1"/>
    <#include "../../resource/common/common.ftl" parse=true/>
    <link rel="stylesheet" href="${mvcPath}/main/workshop/stockdetail/css/stockdetail.css">
</head>
<body style="height: 100%; margin: 0">
<#--<div id="container" style="height: 50%"></div>-->
<div id="main" style="height: 100%">
    <el-input v-model="stockNum" placeholder="请填写股票编码或名称" class="stock-num-input"></el-input>
    <el-input v-model="stockDate" placeholder="请填写日期" class="stock-num-input"></el-input>

    <div style="height: 100%; width: 100%">

        <#--//左侧-->
        <div class="left-side" >
            <table border="0" style="width: 600px;">
                <tr>
                    <th>{{ form.stockName }}</th>
                </tr>
                <tr>
                    <td> 开盘:</td>
                    <td>{{ form.currentDayOpenQuotationPrize }}</td>
                    <td> 昨收:</td>
                    <td> {{ form.lastDayCloseQuotationPrize }}</td>
                    <td>当前:</td>
                    <td>{{ form.currentPrize }}</td>
                </tr>
                <tr>
                    <td> 最高:</td>
                    <td>{{ form.todayHighPrize }}</td>
                    <td> 最低:</td>
                    <td>{{ form.todayLowPrize }}</td>
                    <td> 买一:</td>
                    <td>{{ form.currentBidPrize }}</td>
                </tr>
                <tr>
                    <td> 卖一:</td>
                    <td>{{ form.currentSellPrize }}</td>
                    <td> 成交量:</td>
                    <td>{{ form.dealStockNumber }}</td>
                    <td> 成交额:</td>
                    <td>{{ form.dealStockAmountOfMoney }}</td>
                </tr>
                <tr>
                    <td>日期:</td>
                    <td>{{ form.stockDate }}</td>
                    <td>时间:</td>
                    <td>{{ form.stockHour }}</td>
                    <td>涨跌:</td>
                    <td>{{form.upDownNumber}}%</td>
                </tr>
            </table>
            <div id="graph" style="height: 80%; margin-right: 10px;"></div>
        </div>


        <#--//右侧-->
        <div class="right-side">
            <table border="0" style="width: 200px;" class="real-time-border" >
                <tr >
                    <td> 卖五:</td>
                    <td>{{ form.sell5StockPrice }}</td>
                    <td>{{ form.sell5StockNumber }}</td>
                </tr>
                <tr >
                    <td> 卖四:</td>
                    <td>{{ form.sell4StockPrice }}</td>
                    <td>{{ form.sell4StockNumber }}</td>
                </tr>
                <tr>
                    <td> 卖三:</td>
                    <td>{{ form.sell3StockPrice }}</td>
                    <td>{{ form.sell3StockNumber }}</td>
                </tr>
                <tr>
                    <td> 卖二:</td>
                    <td>{{ form.sell2StockPrice }}</td>
                    <td>{{ form.sell2StockNumber }}</td>
                </tr>
                <tr>
                    <td> 卖一:</td>
                    <td>{{ form.sell1StockPrice }}</td>
                    <td>{{ form.sell1StockNumber }}</td>
                </tr>
                <tr>
                    <td> 买一:</td>
                    <td>{{ form.bid1StockPrice }}</td>
                    <td>{{ form.bid1StockNumber }}</td>
                </tr>
                <tr>
                    <td> 买二:</td>
                    <td>{{ form.bid2StockPrice }}</td>
                    <td>{{ form.bid2StockNumber }}</td>
                </tr>
                <tr>
                    <td> 买三:</td>
                    <td>{{ form.bid3StockPrice }}</td>
                    <td>{{ form.bid3StockNumber }}</td>
                </tr>
                <tr>
                    <td> 买四:</td>
                    <td>{{ form.bid4StockPrice }}</td>
                    <td>{{ form.bid4StockNumber }}</td>
                </tr>
                <tr>
                    <td> 买五:</td>
                    <td>{{ form.bid5StockPrice }}</td>
                    <td>{{ form.bid5StockNumber }}</td>
                </tr>

            </table>
        </div>
    </div>

</div>

<script type="text/javascript">
    // var dom = document.getElementById("container");
    // var myChart = echarts.init(dom);
    // var app = {};
    // var option = null;
    // option = {
    //     xAxis: {
    //         type: 'category',
    //         data: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun']
    //     },
    //     yAxis: {
    //         type: 'value'
    //     },
    //     series: [{
    //         data: [820, 932, 901, 934, 1290, 1330, 1320],
    //         type: 'line'
    //     }]
    // };
    // if (option && typeof option === "object") {
    //     myChart.setOption(option, true);
    // }
</script>

<script src="${mvcPath}/main/workshop/stockdetail/js/stockdetail.js"></script>
</body>
</html>