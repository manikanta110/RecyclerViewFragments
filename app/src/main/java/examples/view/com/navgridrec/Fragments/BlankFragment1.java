package examples.view.com.navgridrec.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import examples.view.com.navgridrec.Adapters.TopRatedMovieAdapter;
import examples.view.com.navgridrec.Api.Client;
import examples.view.com.navgridrec.Api.Service;
import examples.view.com.navgridrec.R;
import examples.view.com.navgridrec.TopRatedMovies.Result;
import examples.view.com.navgridrec.TopRatedMovies.TopMovie;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by user on 16-Dec-17.
 */

public class BlankFragment1 extends Fragment {
    RecyclerView recyclerView;


    public BlankFragment1(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_blank1,container,false);
         recyclerView =(RecyclerView)root.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        loadJsondata();




        return root;
    }



    private void loadJsondata() {
      Service Service  = Client.getRetrofit().create(Service.class);

        Call<TopMovie> call = Service.getpopularmovies("81c4047a8486904dd6cf0787b4b47dc9");
        call.enqueue(new Callback<TopMovie>() {
            @Override
            public void onResponse(Call<TopMovie> call, Response<TopMovie> response) {

                List<Result> movies = response.body().getResults();
                recyclerView.setAdapter(new TopRatedMovieAdapter(getContext(), movies));
                recyclerView.smoothScrollToPosition(0);


            }

            @Override
            public void onFailure(Call<TopMovie> call, Throwable t) {

                Toast.makeText(getActivity(), "Error Occured", Toast.LENGTH_LONG).show();


            }
        });
    }
}
