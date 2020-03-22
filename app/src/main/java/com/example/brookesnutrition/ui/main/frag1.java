package com.example.brookesnutrition.ui.main;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.brookesnutrition.Main3Activity;
import com.example.brookesnutrition.R;
import com.example.brookesnutrition.User;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link frag1.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link frag1#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frag1 extends Fragment {


    User user = new User();
    private Context context;
    private sendData omitData;

    private OnFragmentInteractionListener mListener;

    public frag1() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static frag1 newInstance() {
        frag1 fragment = new frag1();
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
        final View view = inflater.inflate(R.layout.fragment_frag1, container, false);
        Button button =  view.findViewById(R.id.addOmit);
        final EditText add = view.findViewById(R.id.writeOmit);
        final Spinner omit = view.findViewById(R.id.spinnerOmit);

        final ArrayList<String> omitList = new ArrayList<String>();
        final ArrayList<String> omitTransList = new ArrayList<String>();

        final ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,
                omitList);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        omit.setAdapter(myAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (add.length() < 1){
                    Toast.makeText(context, "Enter a valid ingredient", Toast.LENGTH_LONG).show();
                }
                else{
                    String omitStr = add.getText().toString();

                    myAdapter.add(omitStr);
                    myAdapter.notifyDataSetChanged();
                    omit.setSelection(myAdapter.getPosition(omitStr));
                    omitTransList.add(omitStr);
                    omitData.setArrayList(omitTransList);

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
            omitData = (sendData) context;
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
