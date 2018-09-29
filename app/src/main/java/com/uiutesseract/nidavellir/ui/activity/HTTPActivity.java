package com.uiutesseract.nidavellir.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.uiutesseract.nidavellir.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HTTPActivity extends AppCompatActivity {

    private static  String TAG = "HTTPActivity";
    private TextView textView;
    private String finalText = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_http);
        textView =findViewById(R.id.tv_data_http);

        findViewById(R.id.btn_fetch_data_hhtp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feetchData();
            }
        });
    }
    public void feetchData() {


        String url = "https://api.myjson.com/bins/9fsqo";

        StringRequest sr = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);

                            Log.d(TAG, jsonArray.toString());
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                // get data from Json Object (name-value pair)
                                String strName = jsonObject.getString("name");
                                String strValue = jsonObject.getString("value");

                                finalText = finalText+(i+1)+") "+strName + " " +strValue+"\n";
                                Toast.makeText(HTTPActivity.this,strName+" "+strValue  , Toast.LENGTH_SHORT).show();
                            }
                            //display at textview
                            textView.setText(finalText);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue rq = Volley.newRequestQueue(HTTPActivity.this);
        rq.add(sr);
    }
}
