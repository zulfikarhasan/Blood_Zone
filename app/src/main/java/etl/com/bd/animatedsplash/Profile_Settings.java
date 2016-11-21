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

    String name,email,phone_number,address,blood_group,age,gender,mail;

    TextView tv_level_name,tv_level_email,tv_name,tv_gender,tv_age,tv_blood_group,tv_number,tv_address;

    public static final String KEY_EMAIL = "email";
    ProgressDialog mProgressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile__settings);

        tv_level_name = (TextView)findViewById(R.id.tv_profile_setting_level_Name);
        tv_level_email = (TextView)findViewById(R.id.tv_profile_setting_level_email);
        tv_name = (TextView)findViewById(R.id.tv_profile_setting_Full_name);
        tv_gender = (TextView)findViewById(R.id.tv_profile_setting_Gender);
        tv_age = (TextView)findViewById(R.id.tv_profile_setting_Age);
        tv_blood_group = (TextView)findViewById(R.id.tv_profile_setting_Blood_Group);
        tv_number = (TextView)findViewById(R.id.tv_profile_setting_Number);
        tv_address = (TextView)findViewById(R.id.tv_profile_setting_Address);

        //profile
        Intent intent = getIntent();
        email = intent.getStringExtra("KEY_EMAIL");
        getUserInformation(email);



    }

    //profile
    private void getUserInformation(final String email){
        String linkrequest = "http://10.0.2.2/Blooddonetion/userdetails.php";
        mProgressDialog = new ProgressDialog(Profile_Settings.this);
        mProgressDialog.setMessage("Loading...");
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
                                     mail = innerobj.getString("email");
                                     gender = innerobj.getString("gender");
                                     phone_number = innerobj.getString("phone_number");
                                     address = innerobj.getString("address");
                                     blood_group = innerobj.getString("blood_group");
                                     age = innerobj.getString("age");

                                    tv_level_name.setText(name);
                                    tv_level_email.setText(email);
                                    tv_name.setText(name);
                                    tv_number.setText(phone_number);
                                    tv_address.setText(address);
                                    tv_blood_group.setText(blood_group);
                                    tv_age.setText(age);
                                    tv_gender.setText(gender);


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
