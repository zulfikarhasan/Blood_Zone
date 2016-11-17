package etl.com.bd.animatedsplash;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import etl.com.bd.animatedsplash.mode.DemoDataHandler;

public class Profile_Settings extends AppCompatActivity {

    String name,email,phone_number,address,blood_group,age;

    EditText et_name,et_phone_number,et_address,et_blood_group,et_age;

    public static final String KEY_EMAIL = "email";
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__settings);

        et_name = (EditText)findViewById(R.id.et_profile_settings_name);
        et_phone_number = (EditText)findViewById(R.id.et_profile_settings_phone_number);
        et_address = (EditText)findViewById(R.id.et_profile_settings_address);
        et_blood_group = (EditText)findViewById(R.id.et_profile_settings_blood_group);
        et_age = (EditText)findViewById(R.id.et_profile_settings_age);


        //profile
        Intent intent = getIntent();
        email = intent.getStringExtra("KEY_EMAIL");
        getUserInformation(email);







    }

    //profile
    private void getUserInformation(final String email){
        String linkrequest = "http://10.0.2.2/Blooddonetion/userdetails.php";

        StringRequest stringRequest = new StringRequest(Request.Method.POST, linkrequest,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray array = object.getJSONArray("result");

                            if (array.length()>0) {
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject innerobj = array.getJSONObject(i);
                                     name = innerobj.getString("name");
                                     phone_number = innerobj.getString("phone_number");
                                     address = innerobj.getString("address");
                                     blood_group = innerobj.getString("blood_group");
                                     age = innerobj.getString("age");

                                    DemoDataHandler dhandler = new DemoDataHandler();
                                    dhandler.setFull_name(name.toString().trim());
                                   dhandler.setPhone_number(phone_number.toString().trim());
                                    dhandler.setAddress(address.toString().trim());
                                    dhandler.setBlood_group(blood_group.toString().trim());
                                    dhandler.setAge(age.toString().trim());
                                }
                            }

                        } catch (JSONException e) {
                            mProgressDialog.dismiss();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mProgressDialog.dismiss();
                // Toast.makeText(MainActivity.this, "Internet Problem Occour", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_EMAIL, email);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(Profile_Settings.this);
        requestQueue.add(stringRequest);
    }
}
