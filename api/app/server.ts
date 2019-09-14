import * as express from "express";
import * as cors from "cors";
import * as bodyparser from "body-parser";
import * as knex from 'knex';
const options = require('../connection.js')

const app = express();

const database = knex(options)

app.get('/', () => console.log('aaa'));



app.listen(process.env.PORT || 8000, () => {
    console.log('server started');
    console.log(options);
    database.from('Doenca');
});