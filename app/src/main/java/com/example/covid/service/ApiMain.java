package com.example.covid.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// deklarasi base url untuk  API
public class ApiMain {
    private Retrofit retrofit;

    public KasusRepo getApiKasus(){
        String BASE_URL = "https://covid19-public.digitalservice.id/api/v1/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(KasusRepo.class);
    }

    public HospitalRepo getApiHospital(){
        String BASE_URL = "https://covid19-public.digitalservice.id/api/v1/";
        if (retrofit == null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(HospitalRepo.class);
    }
}
