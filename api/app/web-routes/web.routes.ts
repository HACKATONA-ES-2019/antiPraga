import * as express from 'express';
import { database } from '../server';
import { Epidemia } from '../models/web/Epidemia';
import { Medico } from '../models/web/Medico'
import { TipoEpidemia } from '../models/web/TipoEpidemia';

export const webRoutes = express.Router();

webRoutes.get('/epidemias', (req, res, next) => {
    const epidemias: Epidemia[] = [
        {
            doenca: 'gripe',
            epidemia: TipoEpidemia.EPIDEMIA,
            lat: -30.056190,
            lng: -51.172200,
            radius: 75
        },
        {
            doenca: 'sei la mano',
            epidemia: TipoEpidemia.EPIDEMIA,
            lat: -30.056390,
            lng: -51.172105,
            radius: 100
        },
        {
            doenca: 'ebola',
            epidemia: TipoEpidemia.POSSIVEL_EPIDEMIA,
            lat: -30.055090,
            lng: -51.122200,
            radius: 90
        }
    ]
    return res.json(epidemias);
});

webRoutes.post('/registra-medico', (req, res) => {
    const medico: Medico = req.body.medico;
    const query = `insert into Medico (nome, cremers, senha) values('${medico.nome}',${medico.cremers},'${medico.senha}')`;
    database.query(query, (error, results, fields ) => {
        console.log(results);
        console.log(error);
        console.log(fields);
        if(error !== null) {
            return res.status(200).json({})
        }
    });
});

webRoutes.post('/login', (req, res) => {
    const cremers: number = parseInt(req.body.cremers);
    const senha: string = req.body.senha;
    database.query(`select nome from Medico where cremers = ${cremers} and senha = ${senha}`, (error, results, fields ) => {
        
        if(results.length === 0) {
            return res.status(400).json({msg: 'cremers nao encontrado'});
        }
        return res.status(200).json({nome: results[0].nome}); 
    });
});

