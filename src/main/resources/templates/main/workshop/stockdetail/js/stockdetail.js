(function () {
    /**************************************时间格式化处理************************************/
    var dateFunction=function dateFtt(fmt,date)
    { //author: meizz
        var o = {
            "M+" : date.getMonth()+1,                 //月份
            "d+" : date.getDate(),                    //日
            "h+" : date.getHours(),                   //小时
            "m+" : date.getMinutes(),                 //分
            "s+" : date.getSeconds(),                 //秒
            "q+" : Math.floor((date.getMonth()+3)/3), //季度
            "S"  : date.getMilliseconds()             //毫秒
        };
        if(/(y+)/.test(fmt))
            fmt=fmt.replace(RegExp.$1, (date.getFullYear()+"").substr(4 - RegExp.$1.length));
        for(var k in o)
            if(new RegExp("("+ k +")").test(fmt))
                fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        return fmt;
    };
    'use strict';
    var main = new Vue({
        el: '#main',
        data: {
            stockNum:'sz000002',
            stockDate:'20190412',
            filter: {
                symbol: 'sz000002',
                ma: 'no',
                scale: '5',
                date: '20190412',
                datalen: '1023'
            },
            form: {
                stockName: '沙河股份',
                currentDayOpenQuotationPrize: '12.090',
                lastDayCloseQuotationPrize: '12.250',
                currentPrize: '12.020',
                todayHighPrize: '12.230',
                todayLowPrize: '11.860',
                currentBidPrize: '12.020',
                currentSellPrize: '12.040',
                dealStockNumber: '7446711',
                dealStockAmountOfMoney: '89618573.840',
                bid1StockNumber: '15000',
                bid1StockPrice: '12.020',
                bid2StockNumber: '48200',
                bid2StockPrice: '12.010',
                bid3StockNumber: '24700',
                bid3StockPrice: '12.000',
                bid4StockNumber: '1700',
                bid4StockPrice: '11.990',
                bid5StockNumber: '1400',
                bid5StockPrice: '11.980',
                sell1StockNumber: '3100',
                sell1StockPrice: '12.040',
                sell2StockNumber: '38900',
                sell2StockPrice: '12.070',
                sell3StockNumber: '500',
                sell3StockPrice: '12.080',
                sell4StockNumber: '11700',
                sell4StockPrice: '12.100',
                sell5StockNumber: '9900',
                sell5StockPrice: '12.110',
                stockDate: '2019-04-12',
                stockHour: '15:00:03',
                stockStatus: '00',
                upDownNumber: 0
            },
            option: {
                //设置标题
                // title : {
                //     text : '该股票不存在',
                //     subtext : '该股票不存在'
                // },
                tooltip : {
                    trigger: 'item',
                    formatter : function (params) {
                        // return params.name + '<br/>' + params.data;
                        return params.data;
                    }
                },
                dataZoom: {
                    show: true,
                    start : 0
                },
                xAxis: {
                    type: 'category',
                    data: ["0","1","2","3","4","5"]
                },
                yAxis: {
                    type: 'value',
                    axisLabel : {
                        formatter: '￥{value}'
                    },
                    min: 0,
                    max: 100,
                    splitArea:{show:true,
                        areaStyle:{color:[
                                '#000000']}
                    },
                    splitLine:{show:false},
                    splitNumber:5
                },
                series: [
                    {
                    data: [0,0,0,0,0,0],
                    type: 'line'
                    },
                    {
                        data: [0,0,0,0,0,0],
                        type: 'line'
                    }]
            }
        },
        computed: {},
        watch: {
            stockNum: function (newVal, oldVal) {
                var _self = this;
                _self.filter.symbol = newVal;
                _self.init();
            },
            stockDate: function (newVal, oldVal) {
                var _self = this;
                _self.filter.date = newVal;
                _self.init();
            }
        },
        methods: {
            init() {
                var _self = this;
                var minY = 1000;
                var maxY = -1000;
                axios.get(_contextPath + '/api/stock/detail', {
                    params: {
                        symbol: _self.filter.symbol,
                        ma: _self.filter.ma,
                        scale: _self.filter.scale,
                        datalen: _self.filter.datalen
                    }
                })
                    .then(function (response) {
                        var data = response.data;
                        if (data) {
                            var todayData = data.historyStockModels;
                            var stockInfoData = data.currentStockModelReals;
                            _self.form = stockInfoData[0];
                            _self.form.upDownNumber = (parseFloat(stockInfoData[0].currentPrize) - parseFloat(stockInfoData[0].lastDayCloseQuotationPrize))/parseFloat(stockInfoData[0].lastDayCloseQuotationPrize) * 100;
                            var stockLastInfoData = data.lastDayCloseStockModel;
                            _self.option.xAxis.data = [];
                            _self.option.series[0].data = [];
                            _self.option.series[1].data = [];
                            for ( var i = 0; i <todayData.length; i++){
                                _self.option.xAxis.data.push(todayData[i].day);
                                _self.option.series[0].data.push(todayData[i].open);
                                _self.option.series[1].data.push(stockLastInfoData.close);
                                // _self.option.title.text = stockInfoData[0].stockName;
                                // _self.option.title.subtext = stockInfoData[0].stockDate;
                                if (minY > todayData[i].open){
                                    minY = todayData[i].open;
                                }
                                if (todayData[i].open > maxY) {
                                    maxY = todayData[i].open;
                                }
                                console.log(todayData[i]);
                            }
                            // var maxY = maxY + 0.5;
                            if (stockLastInfoData.close > maxY) maxY=stockLastInfoData.close;
                            if (stockLastInfoData.close < minY) minY=stockLastInfoData.close;
                            var maxYTemp=parseFloat(maxY) + 0.2;
                            var minYTemp=parseFloat(minY) - 0.2;
                            _self.option.yAxis.min = minYTemp;
                            _self.option.yAxis.max = maxYTemp;
                        }
                        _self.$nextTick(function () {
                            var dom = document.getElementById('graph');
                            var dataGraph = echarts.init(dom);
                            dataGraph.setOption(this.option);
                        });
                    })
                    .catch(function (error) {
                        console.log(error);
                        _self.$nextTick(function () {
                            var dom = document.getElementById('graph');
                            var dataGraph = echarts.init(dom);
                            dataGraph.setOption(this.option);
                        });
                    });


            }


        },
        created: function () {
            var self = this;
            self.init();
        },
        mounted: function () {
            var self = this;

        }
    });
    window.main = main;
}());