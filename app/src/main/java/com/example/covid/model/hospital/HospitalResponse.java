package com.example.covid.model.hospital;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HospitalResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<HospitalDataItem> data;

	public void setStatusCode(int statusCode){
		this.statusCode = statusCode;
	}

	public int getStatusCode(){
		return statusCode;
	}

	public void setData(ArrayList<HospitalDataItem> data){
		this.data = data;
	}

	public ArrayList<HospitalDataItem> getData(){
		return data;
	}
}