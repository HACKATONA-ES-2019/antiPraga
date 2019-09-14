import * as express from 'express';
import {database} from '../server';
import { Epidemia } from '../models/web/Epidemia';
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