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
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Donor_Profile extends AppCompatActivity {


    TextView tv_level_Name, tv_level_email, tv_Full_Name, tv_Gender, tv_Age, tv_Number, tv_Address, tv_Blood_Group;
    ImageView iv_call,iv_sms,iv_email,donor_pic;

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
        iv_call = (ImageView)findViewById(R.id.iv_call);
        iv_sms = (ImageView)findViewById(R.id.iv_massage);
        iv_email = (ImageView)findViewById(R.id.iv_email);
        donor_pic = (ImageView)findViewById(R.id.donor_pic);

        tv_level_Name.setText(getIntent().getStringExtra("Name"));
        tv_level_email.setText(getIntent().getStringExtra("Email"));
        tv_Full_Name.setText(getIntent().getStringExtra("Name"));
        tv_Gender.setText(getIntent().getStringExtra("Gender"));
        tv_Age.setText(getIntent().getStringExtra("Age"));
        tv_Number.setText(getIntent().getStringExtra("Number"));
        tv_Address.setText(getIntent().getStringExtra("Address"));
        tv_Blood_Group.setText(getIntent().getStringExtra("blood_group"));



       String FemaleDonor = getIntent().getStringExtra("Gender");

        if(FemaleDonor.toString().equals("Female")){
            donor_pic.setImageResource(R.drawable.femaledonor);
        }else{
            donor_pic.setImageResource(R.drawable.maledonor);
        }


       iv_call.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               String callText = getIntent().getStringExtra("Number");
               Intent call=new Intent(Intent.ACTION_VIEW, Uri.parse("tel:"+callText));
               startActivity(call);

           }
       });

        iv_sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smsText=getIntent().getStringExtra("Number");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:" + smsText));
                intent.putExtra("","" );
                startActivity(intent);
            }

        });

      iv_email.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              String email  = getIntent().getStringExtra("Email");
              Intent intent = new Intent(Intent.ACTION_SEND);
              intent.setType("text/html");
              intent.putExtra(Intent.EXTRA_EMAIL, email);
              intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
              intent.putExtra(Intent.EXTRA_TEXT, "email body.");

              startActivity(Intent.createChooser(intent, "Send Email"));

          }
      });

    }

}
