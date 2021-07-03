package com.example.covid.view.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.covid.R;
import com.example.covid.adapter.HospitalAdapter;
import com.example.covid.adapter.KasusAdapter;
import com.example.covid.model.hospital.HospitalDataItem;
import com.example.covid.view.viewModel.HospitalViewModel;
import com.example.covid.view.viewModel.KasusViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HospitalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HospitalFragment extends Fragment {

    private HospitalAdapter hospitalAdapter;
    private RecyclerView rvHospital;
    private HospitalViewModel hospitalViewModel;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HospitalFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HospitalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HospitalFragment newInstance(String param1, String param2) {
        HospitalFragment fragment = new HospitalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hospital, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        hospitalAdapter = new HospitalAdapter(getContext());
        hospitalAdapter.notifyDataSetChanged();

        rvHospital = view.findViewById(R.id.fragment_hospital_rv);
        rvHospital.setLayoutManager(new GridLayoutManager(getContext(),1));

        hospitalViewModel = new ViewModelProvider(this).get(HospitalViewModel.class);
        hospitalViewModel.setListHospital();
        hospitalViewModel.getHospital().observe(getViewLifecycleOwner(),getHospital);

        rvHospital.setAdapter(hospitalAdapter);
    }

    private Observer<ArrayList<HospitalDataItem>> getHospital = new Observer<ArrayList<HospitalDataItem>>() {
        @Override
        public void onChanged(ArrayList<HospitalDataItem> hospitalDataItems) {
            if(hospitalDataItems != null){
                hospitalAdapter.setData(hospitalDataItems);
            }
        }
    };
}