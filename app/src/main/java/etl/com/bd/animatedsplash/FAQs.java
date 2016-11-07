package etl.com.bd.animatedsplash;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FAQs extends AppCompatActivity {
    private ListView lvFAQsItem;
    private FAQsListAdapter adapter;
    private List<FAQs_Item> mFAQs_Item;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.faqs);
        lvFAQsItem = (ListView)findViewById(R.id.FAQs_list_View);
        mFAQs_Item = new ArrayList<>();
        //add simple data for list

        mFAQs_Item.add(new FAQs_Item("1.","What is the minimum required age for donating blood?",
                "Ans:","If you can donate blood after 18 but you must fill all other physical criteria"));
        mFAQs_Item.add(new FAQs_Item("2.","Is it safe to donate blood?","Ans:","Yes,it is totally safe to donate."));
        mFAQs_Item.add(new FAQs_Item("3.","Is there any side effect of donating blood?","Ans:","Not at all."));
        mFAQs_Item.add(new FAQs_Item("4.","Can I be senseless as a result of blood donation?","Ans:",
                "A few number of people may face physical abnormality because of their physical condition but he/she can overcome it within a very short moment"));
        mFAQs_Item.add(new FAQs_Item("5.","After donating blood is there any possibility to get infected?","Ans:",
                "No,there is no chance to happen that, but you should not massage that portion of your hand, where blood is taken from."));
        mFAQs_Item.add(new FAQs_Item("6.","After drinking alcohol can I donate blood?","Ans:",
                "No, you can not donate blood within 24 hours of your last drink."));
        mFAQs_Item.add(new FAQs_Item("7.","Can I donate blood as I am suffering for abnormal blood pressure?","Ans:",
                "Yes, if your blood pressure is under control, you can donate."));
        mFAQs_Item.add(new FAQs_Item("8.","Can a mother donate blood during or after pregnancy?","Ans:",
                "No, mother cannot donate blood during pregnancy and within 15 month of delivery."));
        mFAQs_Item.add(new FAQs_Item("9.","Can a mother donate blood during breast feeding?","Ans:",
                "No, mother should not donate during breast feeding."));
        mFAQs_Item.add(new FAQs_Item("10.","Can I donate when I have to take antibiotic medicine?","Ans:",
                "No, you cannot donate blood within 7 days of taking antibiotic."));

        mFAQs_Item.add(new FAQs_Item("11.","If I suffer for Flux, can I donate blood?","Ans:",
                "No, as you carry some germ of Flux in your blood, you cannot donate blood."));
        mFAQs_Item.add(new FAQs_Item("12.","Can a diabetic patient donate blood?","Ans:",
                "No,they should not, but in special situation they also can donate blood."));
        mFAQs_Item.add(new FAQs_Item("13.","Can I donate blood after tacking Vaccine?","Ans:",
                "No,you cannot donate blood within 4 weeks of taking vaccine."));
        //adapter
        adapter=new FAQsListAdapter(getApplicationContext(),mFAQs_Item);

        lvFAQsItem.setAdapter(adapter);
    }
}


