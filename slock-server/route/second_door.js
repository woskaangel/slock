const express=require('express');

const route=express.Router();
const db=require('../db/db');

route.post('/read',function(req,res){
    const input=[req.body.rnum];
    db.getSecondStatus(input,function(docs){
        res.send({door:docs.d_num,d_flg:docs.l_flg});
    });
});

module.exports=route;