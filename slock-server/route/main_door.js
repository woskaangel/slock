const express=require('express');

const route=express.Router();
const db=require('../db/db');

route.post('/write',function(req,res){
    var lock_nowData;
    db.getMainStatus(function(docs){
        lock_nowData=docs.l_flg;
        if(docs.l_flg!=req.body.status){
            db.setMainStatus(parseInt(req.body.status));
            lock_nowData=req.body.status;
        }
        res.send({l_flg:lock_nowData});
    });
});
route.post('/read',function(req,res){
    db.getMainStatus(function(docs){
        res.send({d_flg:docs.d_flg,l_flg:docs.l_flg});
    });
});

module.exports=route;