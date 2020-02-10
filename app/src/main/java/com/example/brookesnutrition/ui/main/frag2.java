package com.example.brookesnutrition.ui.main;

import android.content.Context;
import android.net.Uri;
<<<<<<< HEAD
import android.os.Build;
=======
>>>>>>> Initial commit
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
<<<<<<< HEAD
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.example.brookesnutrition.Food;
import com.example.brookesnutrition.R;
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



=======
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.example.brookesnutrition.R;
>>>>>>> Initial commit

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link frag2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link frag2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frag2 extends Fragment {
<<<<<<< HEAD
    private SearchView search;
    private ListView results;
    public static HttpURLConnection connection;
    private Context context;
    private Double totalcal = 0.0;

    ArrayList<Food> filteredFoodResults = new ArrayList<Food>();
=======
    EditText food;
    Button addFood;
>>>>>>> Initial commit


    private OnFragmentInteractionListener mListener;

    public frag2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment frag1.
     */
    // TODO: Rename and change types and number of parameters
    public static frag2 newInstance() {
        frag2 fragment = new frag2();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
<<<<<<< HEAD
        context = getActivity().getApplicationContext();


    }


    @androidx.annotation.RequiresApi(api = Build.VERSION_CODES.HONEYCOMB)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_frag2, container, false);
        ArrayList<Food> foodResults = new ArrayList<Food>();
        final foodAdapter adapter = new foodAdapter(context, foodResults);

        search = view.findViewById(R.id.search);
        results = view.findViewById(R.id.list);
        results.setAdapter(adapter);


        search.setQueryHint("Start typing to search...");


        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

            }
        });


        search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (newText.length() > 2){
                    Thread thread = new Thread(new Runnable() {

                        @Override
                        public void run() {
                            try{
                                URL url = new URL("https://trackapi.nutritionix.com/v2/search/instant");
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
                                jsonObject.put("query", search.getQuery().toString());
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
                                JSONArray foods = nutrition.getJSONArray("common");

                                for (int i = 0; i < foods.length(); i++) {
                                    JSONObject jsonObject2 = foods.getJSONObject(i);
                                    final String name = jsonObject2.getString("food_name");
                                    final Food food = new Food(name);

                                    getActivity().runOnUiThread(new Runnable() {
                                        @Override
                                        public void run() {
                                            adapter.add(food);
                                        }
                                    });

                                }



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

                    results.setVisibility(View.VISIBLE);
                }

                else{
                    results.setVisibility(View.INVISIBLE);
                }

                return false;
            }
        });





        return view;
=======

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_frag2, container, false);
>>>>>>> Initial commit
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

<<<<<<< HEAD
=======
    public void setAddFood() {
        food = getView().findViewById(R.id.food);
    }
>>>>>>> Initial commit

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
<<<<<<< HEAD

    public class foodAdapter extends ArrayAdapter<Food> {

        public foodAdapter(@NonNull Context context, ArrayList<Food> food) {
            super(context,0, food);

        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent){
            final Food food = getItem(position);
            if (convertView == null){
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.results,parent,false);
                }

            TextView foodName = (TextView) convertView.findViewById(R.id.result);
            TextView foodCal = (TextView) convertView.findViewById(R.id.food_cal);
            Button addcal = (Button) convertView.findViewById(R.id.add);

            foodName.setText(food.getName());
            double calstr = food.getCalories();
            foodCal.setText(Double.toString(calstr));

            addcal.setTag(position);

            addcal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = (Integer) v.getTag();
                    Double calories = food.getCalories();
                    totalcal += calories;
                    Toast.makeText(context,"Total calories:" + totalcal, Toast.LENGTH_SHORT).show();
                }
            });

            return convertView;
            }
        }


    }






=======
}
>>>>>>> Initial commit

