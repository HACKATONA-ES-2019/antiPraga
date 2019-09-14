import * as express from "express";
import * as cors from "cors";
import * as bodyparser from "body-parser";
import * as knex from 'knex';
import * as mysql from 'mysql';
//const appRoutes = require('./app-routes/app.routes');
import {router} from './app-routes/app.routes';
const options = require('../connection.js')

const app = express();

export const database = mysql.createConnection(options);

app.get('/', (req, res) => res.json({teste: 'teste'}));

app.use('/app',router);

app.listen(process.env.PORT || 8000, () => {
    console.log('server started');
    console.log(options);
});