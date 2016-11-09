package etl.com.bd.animatedsplash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Donor_Profile extends AppCompatActivity {


    TextView tv_level_Name,tv_level_email,tv_Full_Name,tv_Gender,tv_Age,tv_Number,tv_Address,tv_Blood_Group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor__profile);
        tv_level_Name = (TextView)findViewById(R.id.tv_donor_profile_level_Name);
        tv_level_email = (TextView)findViewById(R.id.tv_donor_profile_level_email);
        tv_Full_Name = (TextView)findViewById(R.id.tv_donor_profile_Full_name);
        tv_Gender = (TextView)findViewById(R.id.tv_donor_profile_Gender);
        tv_Age = (TextView)findViewById(R.id.tv_donor_profile_Age);
        tv_Number = (TextView)findViewById(R.id.tv_donor_profile_Number);
        tv_Address = (TextView)findViewById(R.id.tv_donor_profile_Address);
        tv_Blood_Group = (TextView)findViewById(R.id.tv_donor_profile_Blood_Group);


        tv_level_Name.setText(getIntent().getStringExtra("Name"));
        tv_level_email.setText(getIntent().getStringExtra("Email"));
        tv_Full_Name.setText(getIntent().getStringExtra("Name"));
        tv_Gender.setText(getIntent().getStringExtra("Gender"));
        tv_Age.setText(getIntent().getStringExtra("Age"));
        tv_Number.setText(getIntent().getStringExtra("Number"));
        tv_Address.setText(getIntent().getStringExtra("Address"));
        tv_Blood_Group.setText(getIntent().getStringExtra("blood_group"));



    }
}
