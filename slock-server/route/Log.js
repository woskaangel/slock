const express=require('express');

const route=express.Router();
const db=require('../db/db');

route.post('/read',function(req,res){
    db.PrintLog(function(docs){
        res.send(docs);
    });
});
route.post('/hardware',function(req,res){
    db.getHardware(function(docs){
        res.send({main:docs[0].connect,sub1:docs[1].connect,sub2:docs[2].connect});
    });
});

module.exports=route;