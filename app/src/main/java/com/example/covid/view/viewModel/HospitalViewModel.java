package com.example.covid.view.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;


import com.example.covid.model.hospital.HospitalDataItem;
import com.example.covid.model.hospital.HospitalResponse;
import com.example.covid.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HospitalViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<HospitalDataItem>> listHospital = new MutableLiveData<>();

    public void setListHospital(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }
        apiMain.getApiHospital().getHospital().enqueue(new Callback<HospitalResponse>() {
            @Override
            public void onResponse(Call<HospitalResponse> call, Response<HospitalResponse> response) {
                HospitalResponse hospitalResponse = response.body();
                if (hospitalResponse != null && hospitalResponse.getData()!=null){
                    ArrayList<HospitalDataItem> hospitalDataItems = hospitalResponse.getData();
                    listHospital.postValue(hospitalDataItems);
                }
            }

            @Override
            public void onFailure(Call<HospitalResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<HospitalDataItem>> getHospital(){return listHospital;}
}
