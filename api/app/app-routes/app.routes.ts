import * as express from 'express';
import {database} from '../server';

export const appRoutes = express.Router();

appRoutes.get('/sintomas', (req, res, next) => {
    const sintoma = req.query.sintoma;
    console.log('parametro: ' + sintoma);
    const a = database.query('select nome from Sintoma', (error, results, fields ) => {
        res.json(results.filter((n: any) => {
            const nome: string = n.nome;
            return nome.toLowerCase().search(sintoma.toLowerCase()) != -1;
        }));
    });
    return;
})