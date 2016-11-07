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

public class Tips_List_Adapter extends BaseAdapter{

    private Context mContext;
    private List<TipsForDonar_Item> mTipsForDonarItem;

    public Tips_List_Adapter(Context mContext, List<TipsForDonar_Item> mTipsForDonarItem) {
        this.mContext = mContext;
        this.mTipsForDonarItem = mTipsForDonarItem;
    }


    @Override
    public int getCount() {
        return mTipsForDonarItem.size();
    }

    @Override
    public Object getItem(int position) {
        return mTipsForDonarItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v=View.inflate(mContext,R.layout.tips_for_donar_list_item,null);
        TextView tv_sNumber = (TextView)v.findViewById(R.id.tv_serial_number);
        TextView tv_tips = (TextView)v.findViewById(R.id.tips);

        tv_sNumber.setText(mTipsForDonarItem.get(position).getS_number());
        tv_tips.setText(mTipsForDonarItem.get(position).getTips());
        return v;
    }
}
