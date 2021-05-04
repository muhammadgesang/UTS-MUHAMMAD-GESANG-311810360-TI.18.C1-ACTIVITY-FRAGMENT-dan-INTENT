package com.example.a4fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentPertama#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentPertama extends Fragment {

    private Button buttonSatu;


    public FragmentPertama() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_pertama, container, false);
        ((MainActivity) getActivity()).getSupportActionBar().setTitle("Fragment Pertama");
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        buttonSatu = (Button) view.findViewById(R.id.button1);

        //inisalisasi button
        return view;


    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        buttonSatu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentKedua fragmentKedua = new FragmentKedua();
                //buat object fragmentkedua

                getFragmentManager().beginTransaction()
                        .replace(R.id.frame_content, fragmentKedua)
                        //menggant fragment
                        .addToBackStack(null)
                        //menyimpan fragment
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        //transisi fragment
                        .commit();
                        //mengeksekusi fragment transaction

            }
        });
    }

    @Override
    //membuat button back
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            getFragmentManager().popBackStack();
        }
        return super.onOptionsItemSelected(item);
    }
}