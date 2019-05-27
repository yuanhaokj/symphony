(function() {
	'use strict';
	var store = new Vuex.Store({
        state: {
          rule : {
              id: null,
              noticeType: '0',//0:短信 ，1：邮件
              noticeCycle: 'hour', // min :分钟 hour:小时  day：天
              maxNoticeTimes: 5,
              sendIntervalType: "sec", //sec:秒 min :分钟
              sendInterval: 10,
              receiverArray:[],
              receiver: null,
              receiverGroup: null,
              handleScript: null,
              warnRules: null,
              createDate: null,
              state: "1",
              createUser: null,
              warnRuleName:"",
              tmplId: ''
          },
          ruleItem:{
              ip:'',
              warnObj:'1',
              type:'fail',
              unitCode:''
          },
          titles: "告警单元",
          units: []
        },
	    mutations: {
            editRule: function (state, options) {
                state.rule = _.extend(state.rule, options);
                state.ruleItem=JSON.parse(state.rule.warnRules);
            },
            setUnits: function(state, units) {
                state.units = units;
            },
            addUnit: function(state, units) {
                state.steps.push(units);
            },
            deleteUnit: function(state, unit) {
                state.units.splice(state.units.indexOf(unit), 1);
            }
	    },
	    actions: {


        }
	});
	
	window.store = store;
}());