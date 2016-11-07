package etl.com.bd.animatedsplash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zulfikar on 10/27/2016.
 */

public class FAQsListAdapter extends BaseAdapter {

    private Context mContext;
    private List<FAQs_Item> mFAQs_Item;

    public FAQsListAdapter(android.content.Context context, List<FAQs_Item> FAQs_Item) {
        mContext = context;
        this.mFAQs_Item = FAQs_Item;
    }


    @Override
    public int getCount() {
        return mFAQs_Item.size();
    }

    @Override
    public Object getItem(int position) {
        return mFAQs_Item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=View.inflate(mContext,R.layout.faqs_list_item,null);
        TextView tv_serial_number = (TextView)v.findViewById(R.id.serial_number);
        TextView tv_question = (TextView)v.findViewById(R.id.question);
        TextView tv_ans = (TextView)v.findViewById(R.id.Ans);
        TextView tv_answer = (TextView)v.findViewById(R.id.answer);

        //set text for textView
        tv_serial_number.setText(mFAQs_Item.get(position).getSerial_number());
        tv_question.setText(mFAQs_Item.get(position).getQuestion());
        tv_ans.setText(mFAQs_Item.get(position).getAns());
        tv_answer.setText(mFAQs_Item.get(position).getAnswer());

        return v;
    }
}
