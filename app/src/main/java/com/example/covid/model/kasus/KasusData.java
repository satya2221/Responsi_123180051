package com.example.covid.model.kasus;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class KasusData {

	@SerializedName("metadata")
	private Metadata metadata;

	@SerializedName("content")
	private ArrayList<KasusContentItem> content;

	public void setMetadata(Metadata metadata){
		this.metadata = metadata;
	}

	public Metadata getMetadata(){
		return metadata;
	}

	public void setContent(ArrayList<KasusContentItem> content){
		this.content = content;
	}

	public ArrayList<KasusContentItem> getContent(){
		return content;
	}
}