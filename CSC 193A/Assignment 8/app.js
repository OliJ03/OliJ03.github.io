"use strict";

const express = require('express');
const app = express();

app.get('/', function (req, res) {
  res.type("text").send("Hello World");
});
//EXERCISE 1
app.get('/math/circle/:r', function (req, res) {
    const radius = req.params.r; 
    const area = Math.PI * radius * radius; 
    const circumeference = Math.PI * 2 * radius; 

    res.type("text").send("Area: " + area + "Circumefernece: " + circumeference);
    
});
//EXERCISE 2
app.get('/hello/name/:first?/:last?', function (req, res) {
    let first = req.params.first;
    let last = req.params.last
    if(!first && !last) { 
        return res.status(400).send("No first or last name detected. Please input a first and last name");
    }
    if(!first || first == ' '){
        return res.status(400).send("No first name detected. Please input a first name");
    }
    if(!last){
        return res.status(400).send("No last name detected. Please input a last name");
    }
    res.type("text").send("Hello " + first + " " + last);
  });

app.listen(8080);

