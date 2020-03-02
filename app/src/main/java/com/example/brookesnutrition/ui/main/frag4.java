package com.example.brookesnutrition.ui.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.brookesnutrition.Food;
import com.example.brookesnutrition.R;
import com.example.brookesnutrition.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.Connection;

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
    private HttpURLConnection connection;



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
        final TextView info = view.findViewById(R.id.information);
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

        ingredients.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String ingSearch = ingredients.getItemAtPosition(position).toString();


                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try{
                            URL url = new URL("https://trackapi.nutritionix.com/v2/natural/nutrients");
                            connection = (HttpURLConnection) url.openConnection();
                            connection.setDoOutput(true);
                            connection.setReadTimeout(10000);
                            connection.setConnectTimeout(15000);
                            connection.setRequestMethod("POST"); // here you are telling that it is a POST request, which can be changed into “PUT”, “GET”, “DELETE” etc.
                            connection.setRequestProperty("Content-Type", "application/json"); // here you are setting the `Content-Type` for the data you are sending which is `application/json`
                            connection.setRequestProperty("x-app-id", "4e39bb2f");
                            connection.setRequestProperty("x-app-key", "0146ee08a7830b6a5afc79213bd8a0ba");
                            connection.connect();

                            final JSONObject jsonObject = new JSONObject();
                            jsonObject.put("query", ingSearch);
                            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
                            wr.writeBytes(jsonObject.toString());
                            wr.flush();
                            wr.close();
                            String json_response = "";
                            InputStreamReader in = new InputStreamReader(connection.getInputStream());
                            BufferedReader br = new BufferedReader(in);
                            String text = "";
                            while ((text = br.readLine()) != null){
                                json_response += text;
                            }

                            JSONObject nutrition = new JSONObject(json_response);
                            JSONArray x = nutrition.getJSONArray("foods");
                            final String strName = x.getJSONObject(0).getString("food_name");
                            final String strWeight = x.getJSONObject(0).getString("serving_weight_grams");
                            final String strcal = x.getJSONObject(0).getString("nf_calories");
                            final String strFat = x.getJSONObject(0).getString("nf_total_fat");
                            final String strSatFat = x.getJSONObject(0).getString("nf_saturated_fat");
                            final String strChol = x.getJSONObject(0).getString("nf_cholesterol");
                            final String strSodi = x.getJSONObject(0).getString("nf_sodium");
                            final String strCarbo = x.getJSONObject(0).getString("nf_total_carbohydrate");
                            final String strfiber = x.getJSONObject(0).getString("nf_dietary_fiber");
                            final String strSugars = x.getJSONObject(0).getString("nf_sugars");
                            final String strProtein = x.getJSONObject(0).getString("nf_protein");

                                getActivity().runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        info.setText("");
                                        info.append(strName + "\n");
                                        info.append("Weight: " + strWeight + "g" + "\n");
                                        info.append("Calories: " + strcal + "Kcal" + "\n");
                                        info.append("Fat: " + strFat + "g" + "\n");
                                        info.append("Saturated Fat: " + strSatFat + "g" + "\n");
                                        info.append("Cholesterol: " + strChol + "mg" + "\n");
                                        info.append("Sodium: " + strSodi + "mg" + "\n");
                                        info.append("Carbohydrates: " + strCarbo + "g" + "\n");
                                        info.append("Fiber: " + strfiber + "g" + "\n");
                                        info.append("Sugar: " + strSugars + "g" + "\n");
                                        info.append("Protein: " + strProtein + "g" + "\n");

                                    }
                                });

                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        finally{
                            connection.disconnect();
                        }
                    }

                });

                thread.start();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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
