package etl.com.bd.animatedsplash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Help extends AppCompatActivity {

    private ListView lvhelp;
    private Help_List_Adapter adapter;
    private List<Help_Item> mHelp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        lvhelp = (ListView)findViewById(R.id.help_list_view);
        mHelp=new ArrayList<>();

        mHelp.add(new Help_Item("How can I use this app?","You must sign up first to search donar or donate blood by providing some basic information of yours. Then you should be login to our apps using your given email and password. Your given email and password is changable from the settings after logged in."));
        mHelp.add(new Help_Item("What's about the privacy?","In the purpose of donating blood or ask for blood, Only valid users will be able to see your public profile including your contact numbers."));
        mHelp.add(new Help_Item("What is the task of complain option?","You can make a limited number of complains to anyone with whom you performed an activity.You can write us any kind of real and documented annoying things are being performed with you by that particular person.And if your complain will be proved then we will takes necessary steps against that user."));
        mHelp.add(new Help_Item("How can I reset my password ?","You can change it from your profile settings option.Provide the current password and give your new password then save it. wow! everything is done!"));

        adapter=new Help_List_Adapter(getApplicationContext(),mHelp);
        lvhelp.setAdapter(adapter);
    }
}
