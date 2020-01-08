const express=require('express');
 
const route=express.Router();
const db=require('../db/db');

route.post('/login',function(req,res){
    const input=[req.body.id,req.body.pw];
    db.Login(input,function(docs){
        if(docs==undefined) res.send({level:"no"});
        else{
            if(docs.u_level=="1") {
                res.send({level:docs.u_level,name:docs.u_name,rnum:docs.u_rnum});
            }
            else{
                res.send({level:docs.u_level,name:docs.u_name});
            }
        }
    });
});
route.post('/signup',function(req,res){
    const input=[req.body.name,req.body.id,req.body.pw,req.body.level];
    if(req.body.level==1) {
        input.push(req.body.num,req.body.rnum);
        db.SignUpStudent(input);
    }
    else{
        db.SignUpTeacher(input);
    }
    res.send({status:"ok"});
});
route.post('/idduplicate',function(req,res){
    const input=[req.body.id];
    db.IdDuplicate(input,function(docs){
        if(docs==null) res.send({status:"ok"});
        else res.send({status:"no"});
    });
});
route.post('/pwchange',function(req,res){
    const input=[req.body.cpw,req.body.id];
    db.PwChange(input);
    res.send({status:"ok"});
});
route.post('/rnumchange',function(req,res){
    const input=[req.body.crnum,req.body.id];
    db.RnumChange(input);
    res.send({status:"ok"});
});

module.exports=route;