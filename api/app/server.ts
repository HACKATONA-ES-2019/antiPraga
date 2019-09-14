import * as express from "express";
import * as cors from "cors";
import * as bodyparser from "body-parser";

const app = express();

app.get('/', () => console.log(''));



app.listen(process.env.PORT || 3000, () => {
    console.log('server started');
});