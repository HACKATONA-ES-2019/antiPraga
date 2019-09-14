import * as express from "express";
import * as cors from "cors";
import * as bodyparser from "body-parser";
import * as knex from 'knex';
import * as mysql from 'mysql';
const options = require('../connection.js')

const app = express();

const database = mysql.createConnection(options);

app.get('/', () => console.log('aaa'));



app.listen(process.env.PORT || 8000, () => {
    console.log('server started');
    console.log(options);
    const a = database.query('select * from Doenca', (error, results, fields ) => {
        console.log(results[0].nome);
    });
    
});