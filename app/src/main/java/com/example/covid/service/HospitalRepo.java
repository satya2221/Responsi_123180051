package com.example.covid.service;

import com.example.covid.model.hospital.HospitalResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HospitalRepo {
    @GET("sebaran_v2/jabar/faskes")
    Call<HospitalResponse> getHospital();
}
