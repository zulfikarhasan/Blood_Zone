package etl.com.bd.animatedsplash;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Donor_Profile extends AppCompatActivity {


    TextView tv_level_Name, tv_level_email, tv_Full_Name, tv_Gender, tv_Age, tv_Number, tv_Address, tv_Blood_Group;
    ImageButton btn_call,btn_msg,btn_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor__profile);
        tv_level_Name = (TextView) findViewById(R.id.tv_donor_profile_level_Name);
        tv_level_email = (TextView) findViewById(R.id.tv_donor_profile_level_email);
        tv_Full_Name = (TextView) findViewById(R.id.tv_donor_profile_Full_name);
        tv_Gender = (TextView) findViewById(R.id.tv_donor_profile_Gender);
        tv_Age = (TextView) findViewById(R.id.tv_donor_profile_Age);
        tv_Number = (TextView) findViewById(R.id.tv_donor_profile_Number);
        tv_Address = (TextView) findViewById(R.id.tv_donor_profile_Address);
        tv_Blood_Group = (TextView) findViewById(R.id.tv_donor_profile_Blood_Group);
        btn_call = (ImageButton) findViewById(R.id.btn_donor_profile_call);
        btn_msg = (ImageButton)findViewById(R.id.btn_donor_profile_msg);
        btn_email = (ImageButton)findViewById(R.id.btn_donor_profile_email);

        tv_level_Name.setText(getIntent().getStringExtra("Name"));
        tv_level_email.setText(getIntent().getStringExtra("Email"));
        tv_Full_Name.setText(getIntent().getStringExtra("Name"));
        tv_Gender.setText(getIntent().getStringExtra("Gender"));
        tv_Age.setText(getIntent().getStringExtra("Age"));
        tv_Number.setText(getIntent().getStringExtra("Number"));
        tv_Address.setText(getIntent().getStringExtra("Address"));
        tv_Blood_Group.setText(getIntent().getStringExtra("blood_group"));


        btn_call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"call:",Toast.LENGTH_SHORT).show();
            }
        });


       btn_msg.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getApplicationContext(),"massage",Toast.LENGTH_SHORT).show();
           }
       });

        btn_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"email",Toast.LENGTH_SHORT).show();
            }
        });



    }
}
