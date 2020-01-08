const express=require('express');

const route=express.Router();
const db=require('../db/db');

route.post('/write',function(req,res){
    const str=req.body.hour+":"+req.body.minute+":00";
    const id=[req.body.id];
    const input=[str,req.body.id];
    db.getReserve(id,function(docs){
        if(docs==undefined){
            db.InsertReserve(input);
        }
        else{
            db.UpdateReserve(input);
        }
        res.send({status:"ok"});
    });
});
route.post('/read',function(req,res){
    db.PrintReserve(function(docs){
        res.send(docs);
    });
});
route.post('/m_write',function(req,res){
    const str=req.body.hour+":"+req.body.minute+":00";
    const input=[str];
    db.getMReserve(function(docs){
        if(docs==undefined){
            db.InsertMReserve(input);
        }
        else {
            db.UpdateMReserve(input);
        }
        res.send({status:"ok"});
    });
});
route.post('/m_read',function(req,res){
    db.getMReserve(function(docs){
        if(docs==undefined){
            res.send({time:"0"});
        }
        else{
            res.send({time:docs.mr_time});
        }
    });
});

module.exports=route;