package com.example.covid.view.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.covid.model.kasus.KasusContentItem;
import com.example.covid.model.kasus.KasusResponse;
import com.example.covid.service.ApiMain;

import java.util.ArrayList;
import java.util.Collections;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<KasusContentItem>> listKasus= new MutableLiveData<>();

    public void setListKasus(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }
        apiMain.getApiKasus().getKasus().enqueue(new Callback<KasusResponse>() {
            @Override
            public void onResponse(Call<KasusResponse> call, Response<KasusResponse> response) {
                KasusResponse kasusResponse = response.body();
                if (kasusResponse != null && kasusResponse.getData().getContent() != null){
                    ArrayList<KasusContentItem> kasusContentItems = kasusResponse.getData().getContent();
                    Collections.reverse(kasusContentItems);
                    listKasus.postValue(kasusContentItems);
                }
            }

            @Override
            public void onFailure(Call<KasusResponse> call, Throwable t) {

            }
        });
    }
    public LiveData<ArrayList<KasusContentItem>> getKasus(){
        return listKasus;
    }
}
