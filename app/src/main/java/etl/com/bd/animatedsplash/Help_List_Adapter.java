package etl.com.bd.animatedsplash;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Zulfikar on 10/28/2016.
 */

public class Help_List_Adapter extends BaseAdapter {

    private Context mContext;
    private List<Help_Item> mHelpItem;

    public Help_List_Adapter(Context mContext, List<Help_Item> mHelpItem) {
        this.mContext = mContext;
        this.mHelpItem = mHelpItem;
    }

    @Override
    public int getCount() {
        return mHelpItem.size();
    }

    @Override
    public Object getItem(int position) {
        return mHelpItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = View.inflate(mContext,R.layout.help_list_item,null);
        TextView tv_help_question = (TextView)v.findViewById(R.id.tv_help_question);
        TextView tv_help_answer = (TextView)v.findViewById(R.id.tv_help_answer);

        tv_help_question.setText(mHelpItem.get(position).getHelp_question());
        tv_help_answer.setText(mHelpItem.get(position).getHelp_answer());
        return v;
    }
}
