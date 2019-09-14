import * as express from 'express';
import {database} from '../server';

export const router = express.Router();

const nome = 'ksadka';
const temdentro =  


router.get('/sintomas', (req, res, next) => {
    const sintoma = req.query.sintoma
    console.log('parametro: ' + sintoma);
    const a = database.query('select nome from Sintoma', (error, results, fields ) => {
        console.log(results.filter((n: any) => {
            const nome: string = n.nome;
            return nome.toLowerCase().search(sintoma.toLowerCase()) != -1;
        }));
    });
})