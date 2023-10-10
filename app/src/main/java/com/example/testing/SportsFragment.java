package com.example.testing;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SportsFragment extends Fragment {

    String api_key="39b2f00896ac4b7a8d1af1f7abb2ca48";
    ArrayList<ModelClass> modelClassArrayList;
    RecyclerAdapter adapter;
    String country="in";
    private RecyclerView recyclerViewOfRecommended;
    private String category="sports";



    public SportsFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sports, container, false);

        recyclerViewOfRecommended=v.findViewById(R.id.recyclerViewOfRecommended);
        modelClassArrayList=new ArrayList<>();
        recyclerViewOfRecommended.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new RecyclerAdapter(getContext(),modelClassArrayList);
        recyclerViewOfRecommended.setAdapter(adapter);

        findNews();

        return v;
    }


    private void findNews() {

        ApiUtilities.getApiInterface().getCategoryNews(country,category,100,api_key).enqueue(new Callback<mainNews>() {
            @Override
            public void onResponse(Call<mainNews> call, Response<mainNews> response) {
                if (response.isSuccessful()){
                    modelClassArrayList.addAll(response.body().getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<mainNews> call, Throwable t) {

            }
        });
    }
}