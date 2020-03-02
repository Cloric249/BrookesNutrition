package com.example.brookesnutrition.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.brookesnutrition.R;
import com.example.brookesnutrition.User;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link frag4.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link frag4#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frag4 extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private Context context;



    User user = new User();

    private OnFragmentInteractionListener mListener;

    public frag4() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static frag4 newInstance() {
        frag4 fragment = new frag4();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getActivity().getApplicationContext();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_frag4, container, false);


        Button button = view.findViewById(R.id.button_add);
        final EditText ingredient = view.findViewById(R.id.ingredient);
        final Spinner ingredients = view.findViewById(R.id.spinnerI);
        ArrayList<String> lst = new ArrayList<String>();

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,
                lst);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ingredients.setAdapter(myAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ingredient.length() < 1){
                    Toast.makeText(context, "Enter a valid ingredient", Toast.LENGTH_LONG).show();
                }
                else{
                    String ingStr = ingredient.getText().toString();

                    myAdapter.add(ingStr);
                    myAdapter.notifyDataSetChanged();



                }

            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
