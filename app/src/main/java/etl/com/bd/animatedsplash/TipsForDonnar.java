package etl.com.bd.animatedsplash;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TipsForDonnar extends AppCompatActivity {
    private ListView lvTipsList;
    private Tips_List_Adapter adapter;
    private List<TipsForDonar_Item> mTipsForDonarList;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips_for_donar);
        lvTipsList = (ListView)findViewById(R.id.Tips_for_donar_list_View);
        mTipsForDonarList = new ArrayList<>();

        mTipsForDonarList.add(new TipsForDonar_Item("***","Before Donation:"));
        mTipsForDonarList.add(new TipsForDonar_Item("1.", "In the days before your donation, eat healthy, iron-rich foods such as spinach, red meat,fish, poultry, beans, iron-fortified cereals and raisins.This will help maintain a healthy iron level. The number one reason for deferrals (especially women) is anemia."));
        mTipsForDonarList.add(new TipsForDonar_Item("2.","Get a good night’s sleep."));
        mTipsForDonarList.add(new TipsForDonar_Item("3.","At least 3 hours before donating, eat a balanced meal and avoid fatty foods,such as hamburgers, fries, or ice cream."));
        mTipsForDonarList.add(new TipsForDonar_Item("4.","Drink an extra 16 oz. of water and fluids before the donation; you can be deferred for dehydration."));
        mTipsForDonarList.add(new TipsForDonar_Item("5.","Remember that your system must be free of aspirin for three days (72 hours) or ibuprofen for 24 hours prior to donation."));
        mTipsForDonarList.add(new TipsForDonar_Item("***","During Donation :"));
        mTipsForDonarList.add(new TipsForDonar_Item("1.","Wear clothing with short sleeves or sleeves that can be raised above the elbow."));
        mTipsForDonarList.add(new TipsForDonar_Item("2.","If you have a preference of arm or vein that you like the phlebotomist to use for your donation, let them know."));
        mTipsForDonarList.add(new TipsForDonar_Item("3.","Relax, listen to music, talk to others, or simply just catch up on some reading on our comfortable donor lounge chairs designed specifically for apheresis donations,which are equipped for our donors to surf the internet or watch movies."));
        mTipsForDonarList.add(new TipsForDonar_Item("4.","Enjoy an assortment of refreshments in our canteen area immediately after donating."));
        mTipsForDonarList.add(new TipsForDonar_Item("***","After Donation:"));
        mTipsForDonarList.add(new TipsForDonar_Item("1.","Drink plenty of fluids over the next 24-48 hours to replenish any fluids you lost during donation."));
        mTipsForDonarList.add(new TipsForDonar_Item("2.","Avoid strenuous physical activity or heavy lifting for about 24 hours after donation."));
        mTipsForDonarList.add(new TipsForDonar_Item("3.","If you feel light headed, lie down, preferably with feet elevated, until the feeling passes."));
        mTipsForDonarList.add(new TipsForDonar_Item("4.","If something doesn’t feel right, call the Donor Center’s toll-free number provided to you after your donation."));
        mTipsForDonarList.add(new TipsForDonar_Item("5.","Enjoy your day and know that you have made a positive difference."));


        adapter = new Tips_List_Adapter(getApplicationContext(),mTipsForDonarList);
        lvTipsList.setAdapter(adapter);
    }
}
