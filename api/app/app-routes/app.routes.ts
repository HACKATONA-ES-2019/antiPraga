import * as express from 'express';
import {database} from '../server';

export const appRoutes = express.Router();

appRoutes.get('/sintomas', (req, res, next) => {
    const a = database.query('select nome, idSintoma from Sintoma', (error, results, fields ) => {
        res.json(results);
     }) 
});

appRoutes.post('/sintomas-doencas', (req, res) => {
    const sintomas = req.body.sintomas;

    let query: string = `select distinct id,count(*) from hackatona.SintomaDoenca2 s where (`;

    sintomas.forEach((d: any) => {
        query = query.concat(`s.${getNomeSintoma(parseInt(d.id))} = 1  and `)
    })

    query = query.substring(0,query.length -4);
    query = query.concat(') group by id');

    console.log(query);
    
})

const getNomeSintoma = (id:number) => {
    switch(id) {
        case 1: return 'dor_de_cabeca';
        case 2: return 'febre';
        case 3: return 'vomito';
        case 4: return 'dor_muscular';
        case 5: return 'diarreia';
        case 6: return 'dor_nos_olhos';
        case 7: return 'emagrecimento';
        default: return 'desmaio';
    }
}