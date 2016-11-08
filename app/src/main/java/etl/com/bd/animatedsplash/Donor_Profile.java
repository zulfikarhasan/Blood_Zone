package etl.com.bd.animatedsplash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Donor_Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donor__profile);


        TextView Name = (TextView)findViewById(R.id.tv_Donor_Name);
        TextView Number = (TextView)findViewById(R.id.tv_Donor_Number);
        TextView Address = (TextView)findViewById(R.id.tv_Donor_Address);


        Name.setText("Name: "+getIntent().getStringExtra("Name"));
        Number.setText("Number: "+getIntent().getStringExtra("Number"));
        Address.setText("Address: "+getIntent().getStringExtra("Address"));

    }
}
