const express=require('express');
const cron=require('node-cron');

const route=express.Router();
const db=require('../db/db');

var closeTime;

cron.schedule('* * * * *',function(){
    var time; 
    if(new Date().getHours()<10){
        time="0"+new Date().getHours()+":"+new Date().getMinutes()+":00";
    }
    else{
        time=new Date().getHours()+":"+new Date().getMinutes()+":00";
    }
    db.getMReserve(function(docs){
        if(docs!=undefined){
            if(time==docs.mr_time){
                const input=[1];
                db.setMainStatus(input);
                db.DeleteMReserve();
                closeTime=(new Date().getHours()+1)+":"+new Date().getMinutes()+":00";
            }
        }
        else{
            if(closeTime==time){
                const input=[0];
                db.setMainStatus(input);
            }
        }
    });
}).start(); // 매 1분마다 실행

cron.schedule('0 0 * * *',function(){
    closeTime=0;
    db.DeleteReserve();
    db.DeleteMReserve();
}); // 매일 0시 0분 마다 실행

cron.schedule('0 0 1 3 *',function(){
    db.DeleteStudent();
}); // 매년 3월 1일에 실행

module.exports=route;