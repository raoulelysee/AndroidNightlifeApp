package com.example.admin.mon1ernightlife.ProfileUserMenu;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.admin.mon1ernightlife.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class ScreenSlideFirstFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    Spinner spinnerMusic;
    public ScreenSlideFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.fragment_screen_slide_first,container,false );

        //Adding genderArray to spinnerGender
        spinner = (Spinner)view.findViewById( R.id.spinnerGender );
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource( this.getActivity(),R.array.gender_array,android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter( adapter );
        spinner.setOnItemSelectedListener(this);

        spinnerMusic =(Spinner)view.findViewById( R.id.spinnerMusicalStyle );
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource( this.getActivity(),R.array.musical_array,android.R.layout.simple_spinner_item
        );
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerMusic.setAdapter( adapter2 );
        spinnerMusic.setOnItemSelectedListener(this);

        return view;


    }


    @Override
    public void onResume() {
        super.onResume();
        getActivity().setTitle(R.string.my_details);
    }


   @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
        public void onNothingSelected (AdapterView < ? > adapterView){

    }

}


