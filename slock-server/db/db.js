const mysql=require('mysql');

const conn = mysql.createConnection({
    host: 'localhost', 
    user: 'root',
    password: 'k06120393@', 
    database: 'slock',
    port: 3306,
});

exports.Login=function(input,callback){
    conn.query('select * from user where u_id = ? and u_pw = ?;',input,function(err,docs){
        if(err) console.log(err);
        else callback(docs[0]);
    });
}
exports.SignUpStudent=function(input){
    conn.query('insert into user(u_name,u_id,u_pw,u_level,u_num,u_rnum) values (?,?,?,?,?,?);',input,function(err){
        if(err) console.log(err);
    });
}
exports.SignUpTeacher=function(input){
    conn.query('insert into user(u_name,u_id,u_pw,u_level) values (?,?,?,?);',input,function(err){
        if(err) console.log(err);
    });
}
exports.IdDuplicate=function(input,callback){
    conn.query('select * from user where u_id = ?',input,function(err,docs){
        if(err) console.log(err);
        else if(docs[0]==undefined) callback(null);
        else callback(1);
    });
}
exports.DeleteStudent=function(){
    conn.query('delete from user where u_level=1',function(err){
        if(err) console.log(err);
    });
}
exports.PwChange=function(input){
    conn.query('update user set u_pw=? where u_id=?;',input,function(err){
        if(err) console.log(err);
    });
}
exports.RnumChange=function(input){
    conn.query('update user set u_rnum=? where u_id=?;',input,function(err){
        if(err) console.log(err);
    });
}
exports.PrintLog=function(callback){
    conn.query('select * from log',function(err,docs){
        if(err) console.log(err);
        else callback(docs);
    });
}
exports.getMainStatus=function(callback){
    conn.query('select * from door where d_num=101;',function(err,docs){
        if(err) console.log(err);
        else callback(docs[0]);
    });
}
exports.setMainStatus=function(input){
    conn.query('update door set l_flg=? where d_num=101;',input,function(err){
        if(err) console.log(err);
    });
    var input2;
    const time=new Date().getFullYear()+"-"+(new Date().getMonth()+1)+"-"+new Date().getDate()+" "+new Date().getHours()+":"+new Date().getMinutes()+":"+new Date().getSeconds();
    if(input==1){
        input2=['close',time];
    }
    else{
        input2=['open',time];
    }
    conn.query('insert into log(l_num,l_time) values (?,?);',input2,function(err){
        if(err) console.log(err);
    });
}
exports.getSecondStatus=function(input,callback){
    conn.query('select * from door where d_num=?;',input,function(err,docs){
        if(err) console.log(err);
        else callback(docs[0]);
    });
}
exports.getReserve=function(input,callback){
    conn.query('select * from reserve where r_id=?',input,function(err,docs){
        if(err) console.log(err);
        else callback(docs[0]);
    });
}
exports.UpdateReserve=function(input){
    conn.query('update reserve set r_time=? where r_id=?;',input,function(err){
        if(err) console.log(err);
    });
}
exports.InsertReserve=function(input){
    conn.query('insert into reserve(r_time,r_id) values (?,?);',input,function(err){
        if(err) console.log(err);
    });
}
exports.DeleteReserve=function(){
    conn.query('delete from reserve',function(err){
        if(err) console.log(err);
    });
}
exports.PrintReserve=function(callback){
    conn.query('select * from reserve',function(err,docs){  
        if(err) console.log(err);
        else callback(docs);
    });
}
exports.getMReserve=function(callback){
    conn.query('select * from main_reserve;',function(err,docs){
        if(err) console.log(err);
        else callback(docs[0]);
    });
}
exports.UpdateMReserve=function(input){
    conn.query('update main_reserve set mr_time=?;',input,function(err){
        if(err) console.log(err);
    });
}
exports.InsertMReserve=function(input){
    conn.query('insert into main_reserve values (?);',input,function(err){
        if(err) console.log(err);
    });
}
exports.DeleteMReserve=function(){
    conn.query('delete from main_reserve',function(err){
        if(err) console.log(err);
    });
}
exports.getHardware=function(callback){
    conn.query('select * from device',function(err,docs){
        if(err) console.log(err);
        callback(docs);
    });
}