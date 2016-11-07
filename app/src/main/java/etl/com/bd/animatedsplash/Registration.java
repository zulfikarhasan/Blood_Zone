package etl.com.bd.animatedsplash;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {

    EditText full_name,email,password,con_pass,address,phone_number,age;
    Button registrationbtn;
    private RadioGroup radioSexGroup;
    private RadioButton radioSexButton;
    RequestQueue requestQueue;
    Spinner spinner_blood_group;
    String blood_group;

    // Declaring the String Array with the Text Data for the Spinners
    String[] Blood_Group = {"Blood group","A+", "A-", "B+", "B-","O+","O-","AB+","AB-" };

    // Declaring the Integer Array with resourse Id's of Images for the Spinners
    Integer[] images = { R.drawable.blood,
                         R.drawable.apositive,
                         R.drawable.anegitive,
                         R.drawable.bpositive,
                         R.drawable.bnegitive,
                         R.drawable.opositive,
                         R.drawable.onegitive,
                         R.drawable.abpositive,
                         R.drawable.abnegitive
                       };

    String insertUrl = "http://10.0.2.2/Blooddonetion/registration.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        full_name = (EditText)findViewById(R.id.et_registration_fullName);
        password = (EditText)findViewById(R.id.et_registration_password);
        email = (EditText)findViewById(R.id.et_registration_email);
        con_pass = (EditText)findViewById(R.id.et_registration_conPass);
        address = (EditText)findViewById(R.id.et_registration_address);
        phone_number = (EditText)findViewById(R.id.et_registration_phoneNumber);
        age = (EditText)findViewById(R.id.et_registration_age);
        spinner_blood_group = (Spinner)findViewById(R.id.Select_Blood_Group);
        registrationbtn = (Button)findViewById(R.id.btn_registration_registration);
        radioSexGroup = (RadioGroup)findViewById(R.id.radio_group_registration);


        requestQueue = Volley.newRequestQueue(getApplication());


        // Setting a Custom Adapter to the Spinner
        spinner_blood_group.setAdapter(new MyAdapter(Registration.this, R.layout.custom_spinner,
                Blood_Group));

        spinner_blood_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                blood_group = spinner_blood_group.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        registrationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String passOne = password.getText().toString().trim();
                String passTwo = con_pass.getText().toString().trim();

                if(full_name.getText().toString().length()<=0){
                    Toast.makeText(Registration.this,"Full name is null",Toast.LENGTH_SHORT).show();
                    full_name.requestFocus();
                }else if(!validateEmail(email.getText().toString())){
                    Toast.makeText(Registration.this,"Invalid email",Toast.LENGTH_SHORT).show();
                    email.requestFocus();

                }else if(!validatePassword(password.getText().toString())){

                    Toast.makeText(Registration.this,"Invalid password",Toast.LENGTH_SHORT).show();
                    password.requestFocus();

                }else if(!passOne.equals(passOne)){
                    Toast.makeText(getApplicationContext(), "Password mismatch, Try again", Toast.LENGTH_SHORT).show();
                    password.requestFocus();
                }else if(address.getText().toString().length()<=0) {
                    Toast.makeText(Registration.this, "address fill is blank", Toast.LENGTH_SHORT).show();
                    address.requestFocus();
                }
                else if(phone_number.getText().toString().length()<11){
                    Toast.makeText(Registration.this,"Invalid Phone number",Toast.LENGTH_SHORT).show();
                    phone_number.requestFocus();
                }

                else if(age.getText().toString().length()<=0){
                    Toast.makeText(Registration.this,"age fill is blank",Toast.LENGTH_SHORT).show();
                    age.requestFocus();
                }


                else {
                    stringRequestforSaveData();
                    Toast.makeText(Registration.this,"Registration success",Toast.LENGTH_SHORT).show();

                    Intent intent=new Intent(Registration.this,LoginActivity.class);
                    startActivity(intent);
                }




            }
        });

    }


    public void onRadioButtonClicked(View view) {
        int selected = radioSexGroup.getCheckedRadioButtonId();

        radioSexButton = (RadioButton)findViewById(selected);

    }


     protected  boolean validateEmail(String email){
         String emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                 + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

         Pattern pattern = Pattern.compile(emailPattern);
         Matcher matcher = pattern.matcher(email);

         return matcher.matches();


     }

    protected  boolean validatePassword(String password){
        if(password!=null && password.length()>6){
            return true;
        }else {
            return false;
        }
    }


    // Creating an Adapter Class
    public class MyAdapter extends ArrayAdapter {

        public MyAdapter(Context context, int textViewResourceId,
                         String[] objects) {
            super(context, textViewResourceId, objects);
        }

        public View getCustomView(int position, View convertView,
                                  ViewGroup parent) {

            // Inflating the layout for the custom Spinner
            LayoutInflater inflater = getLayoutInflater();
            View layout = inflater.inflate(R.layout.custom_spinner, parent, false);

            // Declaring and Typecasting the textview in the inflated layout
            TextView tvLanguage = (TextView) layout
                    .findViewById(R.id.tv_blood_list);

            // Setting the text using the array
            tvLanguage.setText(Blood_Group[position]);

            // Setting the color of the text
            tvLanguage.setTextColor(Color.GRAY);

            // Declaring and Typecasting the imageView in the inflated layout
            ImageView img = (ImageView) layout.findViewById(R.id.img_blood_Group);

            // Setting an image using the id's in the array
            img.setImageResource(images[position]);

            // Setting Special atrributes for 1st element
            if (position == 0) {
                // Removing the image view
               // img.setVisibility(View.GONE);
                // Setting the size of the text
                tvLanguage.setTextSize(20f);
                // Setting the text Color
                tvLanguage.setTextColor(Color.GRAY);

            }

            return layout;
        }

        // It gets a View that displays in the drop down popup the data at the specified position
        @Override
        public View getDropDownView(int position, View convertView,
                                    ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }

        // It gets a View that displays the data at the specified position
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            return getCustomView(position, convertView, parent);
        }
    }



    private void stringRequestforSaveData(){
        StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parameters = new HashMap<String, String>();

                parameters.put("full_name",full_name.getText().toString());
                parameters.put("email",email.getText().toString());
                parameters.put("password",password.getText().toString());
                parameters.put("con_pass",con_pass.getText().toString());
                parameters.put("address",address.getText().toString());
                parameters.put("phone_number",phone_number.getText().toString());
                parameters.put("age",age.getText().toString());
                parameters.put("blood_group",blood_group.toString());
                parameters.put("gender",radioSexButton.getText().toString());

                return  parameters;
            }
        };
        requestQueue.add(request);
    }
}
