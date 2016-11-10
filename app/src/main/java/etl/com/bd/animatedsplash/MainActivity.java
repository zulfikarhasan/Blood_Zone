package etl.com.bd.animatedsplash;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import etl.com.bd.animatedsplash.adapter.DemoDataloadAdapter;
import etl.com.bd.animatedsplash.mode.DemoDataHandler;
import etl.com.bd.animatedsplash.utils.ServiceHelper;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    NavigationView navigationView = null;
    Toolbar toolbar = null;
    //5/11/2016
    TextView textViewNullView;
    RecyclerView recyclerViewDemo;
    DemoDataloadAdapter ddLoadAdapter;
    private List<DemoDataHandler> demoList = new ArrayList<>();
    public static final String KEY_BLOODGROUP = "blood_group";

    Spinner spinner_blood_group;
    String blood_group;

    // Declaring the String Array with the Text Data for the Spinners
    String[] Blood_Group = {"Search Blood", "A+", "A-", "B+", "B-", "O+", "O-", "AB+", "AB-"};

    // Declaring the Integer Array with resourse Id's of Images for the Spinners
    Integer[] images = {R.drawable.blood,
            R.drawable.apositive,
            R.drawable.anegitive,
            R.drawable.bpositive,
            R.drawable.bnegitive,
            R.drawable.opositive,
            R.drawable.onegitive,
            R.drawable.abpositive,
            R.drawable.abnegitive
    };
    // 8/11/2016
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewDemo = (RecyclerView) findViewById(R.id.rv_demoRecyclerview);
        textViewNullView = (TextView) findViewById(R.id.tv_mainactivity_emptyview);
        spinner_blood_group = (Spinner) findViewById(R.id.MainActivity_Select_Blood_Group);

        spinner_blood_group.setAdapter(new MyAdapter(MainActivity.this, R.layout.custom_spinner, Blood_Group));


        loadinaternetdata();

        spinner_blood_group.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                String selectedItem = adapterView.getItemAtPosition(i).toString();
                if (selectedItem.equals("A+")) {
                    loadSearchData("A+");
                } else if (selectedItem.equals("A-")) {
                    loadSearchData("A-");
                } else if (selectedItem.equals("B+")) {
                    loadSearchData("B+");
                } else if (selectedItem.equals("B-")) {
                    loadSearchData("B-");
                } else if (selectedItem.equals("O+")) {
                    loadSearchData("O+");
                } else if (selectedItem.equals("O-")) {
                    loadSearchData("O-");
                } else if (selectedItem.equals("AB+")) {
                    loadSearchData("AB+");
                } else if (selectedItem.equals("AB-")) {
                    loadSearchData("AB-");
                }else {
                    loadinaternetdata();
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        // shared Preferences
        SharedPreferences sharedPreferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
        String email = sharedPreferences.getString(Config.EMAIL_SHARED_PREF, "Not Available");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void loadinaternetdata() {
        String linkrequest = "http://10.0.2.2/Blooddonetion/getlistItem.php";
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();

        StringRequest stringRrquest = new StringRequest(Request.Method.GET, linkrequest, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject object = new JSONObject(response);
                    JSONArray array = object.getJSONArray("result");
                    if (array.length()<=0){
                        recyclerViewDemo.setVisibility(View.GONE);
                        textViewNullView.setVisibility(View.VISIBLE);
                    }else {
                        recyclerViewDemo.setVisibility(View.VISIBLE);
                        textViewNullView.setVisibility(View.GONE);
                        for (int i = 0; i < array.length(); i++) {
                            JSONObject innerobj = array.getJSONObject(i);
                            String name = innerobj.getString("name");
                            String email = innerobj.getString("email");
                            String gender = innerobj.getString("gender");
                            String phone_number = innerobj.getString("phone_number");
                            String address = innerobj.getString("address");
                            String blood_group = innerobj.getString("blood_group");
                            String age = innerobj.getString("age");

                            DemoDataHandler dhandler = new DemoDataHandler();
                            dhandler.setFull_name(name.toString().trim());
                            dhandler.setEmail(email.toString().trim());
                            dhandler.setGender(gender.toString().trim());
                            dhandler.setPhone_number(phone_number.toString().trim());
                            dhandler.setAddress(address.toString().trim());
                            dhandler.setBlood_group(blood_group.toString().trim());
                            dhandler.setAge(age.toString().trim());

                            demoList.add(dhandler);
                        }

                        setRecyclerviewData();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(getApplicationContext(), String.valueOf(volleyError), Toast.LENGTH_SHORT).show();

            }
        });
        ServiceHelper.getInstance().addToRequest(stringRrquest);
    }

    public void setRecyclerviewData() {
        if (demoList.size() > 0) {
            recyclerViewDemo.setVisibility(View.VISIBLE);
            textViewNullView.setVisibility(View.GONE);
            ddLoadAdapter = new DemoDataloadAdapter(demoList, MainActivity.this);
            ddLoadAdapter.notifyDataSetChanged();
            recyclerViewDemo.setLayoutManager(new LinearLayoutManager(this));
            recyclerViewDemo.setAdapter(ddLoadAdapter);
            mProgressDialog.dismiss();
        } else {
            recyclerViewDemo.setVisibility(View.GONE);
            textViewNullView.setVisibility(View.VISIBLE);
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


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
//            //set the fragment initially

        } else if (id == R.id.nav_tips) {
            //set the fragment initially
            Intent intent = new Intent(MainActivity.this, TipsForDonnar.class);
            startActivity(intent);

        } else if (id == R.id.nav_FAQs) {
            Intent intent = new Intent(MainActivity.this, FAQs.class);
            startActivity(intent);

        } else if (id == R.id.nav_profile_settings) {

        } else if (id == R.id.nav_help) {
            Intent intent = new Intent(MainActivity.this, Help.class);
            startActivity(intent);
        } else if (id == R.id.nav_about) {

            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);

        } else if (id == R.id.nav_logout) {
            SharedPreferences preferences = getSharedPreferences(Config.SHARED_PREF_NAME, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean(Config.LOGGEDIN_SHARED_PREF, false);
            editor.putString(Config.EMAIL_SHARED_PREF, "");
            editor.commit();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void loadSearchData(final String bloodgroup) {
        String linkrequest = "http://10.0.2.2/Blooddonetion/searchbybloodgroup.php";
        mProgressDialog = new ProgressDialog(MainActivity.this);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.show();
        demoList.clear();
        ddLoadAdapter.notifyDataSetChanged();
        StringRequest stringRequest = new StringRequest(Request.Method.POST, linkrequest,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray array = object.getJSONArray("result");

                            if (array.length()<=0){
                                recyclerViewDemo.setVisibility(View.GONE);
                                textViewNullView.setVisibility(View.VISIBLE);
                                mProgressDialog.dismiss();

                            }else {
                                recyclerViewDemo.setVisibility(View.VISIBLE);
                                textViewNullView.setVisibility(View.GONE);
                                for (int i = 0; i < array.length(); i++) {
                                    JSONObject innerobj = array.getJSONObject(i);
                                    String name = innerobj.getString("name");
                                    String email = innerobj.getString("email");
                                    String gender = innerobj.getString("gender");
                                    String phone_number = innerobj.getString("phone_number");
                                    String address = innerobj.getString("address");
                                    String blood_group = innerobj.getString("blood_group");
                                    String age = innerobj.getString("age");

                                    DemoDataHandler dhandler = new DemoDataHandler();
                                    dhandler.setFull_name(name.toString().trim());
                                    dhandler.setEmail(email.toString().trim());
                                    dhandler.setGender(gender.toString().trim());
                                    dhandler.setPhone_number(phone_number.toString().trim());
                                    dhandler.setAddress(address.toString().trim());
                                    dhandler.setBlood_group(blood_group.toString().trim());
                                    dhandler.setAge(age.toString().trim());

                                    demoList.add(dhandler);
                                }
                                ddLoadAdapter.notifyDataSetChanged();
                                setRecyclerviewData();
                            }
                        } catch (JSONException e) {
                            mProgressDialog.dismiss();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                mProgressDialog.dismiss();
                Toast.makeText(MainActivity.this, "Internet Problem Occour", Toast.LENGTH_LONG).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put(KEY_BLOODGROUP, bloodgroup);
                return params;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(stringRequest);
    }
}
