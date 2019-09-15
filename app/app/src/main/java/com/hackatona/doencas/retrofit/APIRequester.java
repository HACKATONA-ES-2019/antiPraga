package com.hackatona.doencas.retrofit;

import com.hackatona.doencas.entity.*;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.*;

import static com.hackatona.doencas.util.Constants.*;

public interface APIRequester {

    /* API endpoints */

    @GET(REQUEST_SINTOMA)
    Call<List<Sintoma>> requestSintomas(@Query("sintoma") String sintoma);

}
