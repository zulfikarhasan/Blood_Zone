package etl.com.bd.animatedsplash.adapter;

/**
 * Created by Zulfikar on 11/6/2016.
 */
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;



import java.util.List;

import etl.com.bd.animatedsplash.Donor_Profile;
import etl.com.bd.animatedsplash.R;
import etl.com.bd.animatedsplash.mode.DemoDataHandler;

import static android.support.design.R.id.start;

public class DemoDataloadAdapter extends RecyclerView.Adapter<DemoDataloadAdapter.MyDemoListViewHolder>  {
    private List<DemoDataHandler> demoInfo;
    Context context;

    public DemoDataloadAdapter(List<DemoDataHandler> demoInfo, Context context) {
        this.demoInfo = demoInfo;
        this.context = context;
    }

    public DemoDataloadAdapter() {

    }

    public class MyDemoListViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewEmail;
        TextView textViewAddress;


        public MyDemoListViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView)itemView.findViewById(R.id.tv_rowview_name);
            textViewEmail = (TextView)itemView.findViewById(R.id.tv_rowview_email);
            textViewAddress = (TextView)itemView.findViewById(R.id.tv_rowview_address);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }

    @Override
    public DemoDataloadAdapter.MyDemoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowview, parent, false);
        DemoDataloadAdapter.MyDemoListViewHolder holder = new DemoDataloadAdapter.MyDemoListViewHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(DemoDataloadAdapter.MyDemoListViewHolder holder, int position) {
        holder.textViewName.setText(demoInfo.get(position).getFull_name());
        holder.textViewEmail.setText(demoInfo.get(position).getPhone_number());
        holder.textViewAddress.setText(demoInfo.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return demoInfo.size();
    }


}
