import * as express from 'express';
import { database } from '../server';
import { Epidemia } from '../models/web/Epidemia';
import { Medico } from '../models/web/Medico';
import { Coord } from '../models/web/Coord';
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

webRoutes.post('/inclui', (req, res) => {
    const cremers: number = parseInt(req.body.cremers);
    const id_org: number = parseInt(req.body.id_org);
    const numeroEpidemia: number = req.body.numeroEpidemia;
    const senha: string = req.body.senha;
    const idDoenca = req.body.idDoenca;

    const coord: Coord  = {
        lat: req.body.lat,
        lng: req.body.lng 
     };

    if(!cremers && !id_org) {
        return res.status(400).json({msg: "makakio o fio"});
    } else if(cremers && !id_org) {
        return database.query(`select nome,senha from Medico where cremers = ${cremers} and senha = '${senha}'`, (error, results, fields ) => {
            
            if(results.length === 0) {
                return res.status(400).json({msg: 'cremers ou senha invalidos'});
            }
            
            if(coord.lat && coord.lng && idDoenca) {
                database.query('insert into Ponto_doenca (idDoenca, lat, lng) values (' + idDoenca + ',' + coord.lat + ',' + coord.lng + ')', () => {});
            }


        });
    } else if(!cremers && id_org) {
        return database.query(`select id_org,senha from Organizacao where id_org = ${id_org} and senha = '${senha}'`, (error, results, fields ) => {
            if(results.length === 0 && numeroEpidemia) {
                return res.status(400).json({msg: 'id_org ou senha invalidos'});
            }

            if(coord.lat && coord.lng && idDoenca) {
                database.query('insert into Doenca (numeroEpidemia) values (' + numeroEpidemia + ')', () => {});
            }
        });
    }    
});


webRoutes.get('/doencas-coord/:lat/:lng', (req, res, next) => {

    const radius = 0.05;

    const myLat: number = parseInt(req.params.lat);
    const myLng: number = parseInt(req.params.lng);
    database.query(`select idDoenca from Ponto_doenca where (lat <= ${myLat + radius} and lat >= ${myLat - radius} and lng <= ${myLng + radius} and lng >= ${myLng - radius})`,
    (error, results, fields ) => {
        console.log(results);
    }
    );
});

webRoutes.get('/doencas', (req, res, next) => {
    const doenca = req.query.doenca;
    console.log('doenca: ' + doenca);
    const a = database.query('select idDoenca,nome from Doenca', (error, results, fields ) => {
        const lista =results.filter((n: any) => {
            const nome: string = n.nome;
            return nome.toLowerCase().search(doenca.toLowerCase()) != -1;
        });
        if(lista.length === 0) {
            return res.status(400).json({msg: "erro mano, seila"});
        }
        return res.json(lista);
    });
    return;
})