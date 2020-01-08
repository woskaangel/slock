const express=require('express');
const logger = require('morgan');
const Login=require('./route/Login');
const main=require('./route/main_door');
const second=require('./route/second_door');
const reserve=require('./route/reserve');
const Log=require('./route/Log');
const schedule=require('./route/schedule');

const app=express();

app.use(express.json());
app.use(express.urlencoded({extended:false}));
app.use(logger('dev'));

app.use('/',Login);
app.use('/main_door',main);
app.use('/second_door',second);
app.use('/reserve',reserve);
app.use('/log',Log);
app.use(schedule);

app.listen(8080);