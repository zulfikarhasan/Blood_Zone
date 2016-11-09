package etl.com.bd.animatedsplash.adapter;

/**
 * Created by Zulfikar on 11/6/2016.
 */
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

import etl.com.bd.animatedsplash.Donor_Profile;
import etl.com.bd.animatedsplash.MainActivity;
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


    public class MyDemoListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewName;
        TextView textViewNumber;
        TextView textViewAddress;
        TextView textViewBlood;

        ArrayList<DemoDataHandler> demoInfo = new ArrayList<DemoDataHandler>();
        Context context;
        public MyDemoListViewHolder(View view, Context context, ArrayList<DemoDataHandler> demoInfo) {
            super(view);
            this.demoInfo=demoInfo;
            this.context=context;
            itemView.setOnClickListener(this);

            textViewName = (TextView)view.findViewById(R.id.tv_rowview_name);
            textViewBlood = (TextView)view.findViewById(R.id.tv_rowview_blood);
            textViewNumber = (TextView)view.findViewById(R.id.tv_rowview_number);
            textViewAddress = (TextView)view.findViewById(R.id.tv_rowview_address);


        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            DemoDataHandler demoInfo = this.demoInfo.get(position);

            Intent intent = new Intent(this.context,Donor_Profile.class);
            intent.putExtra("Name",demoInfo.getFull_name());
            intent.putExtra("Email",demoInfo.getEmail());
            intent.putExtra("Gender",demoInfo.getGender());
            intent.putExtra("Number",demoInfo.getPhone_number());
            intent.putExtra("Address",demoInfo.getAddress());
            intent.putExtra("blood_group",demoInfo.getBlood_group());
            intent.putExtra("Age",demoInfo.getAge());


            this.context.startActivity(intent);
        }
    }

    @Override
    public DemoDataloadAdapter.MyDemoListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowview, parent, false);
        DemoDataloadAdapter.MyDemoListViewHolder holder = new DemoDataloadAdapter.MyDemoListViewHolder(v,context, (ArrayList<DemoDataHandler>) demoInfo);
        return holder;
    }

    @Override
    public void onBindViewHolder(DemoDataloadAdapter.MyDemoListViewHolder holder, int position) {
        holder.textViewName.setText(demoInfo.get(position).getFull_name());
        holder.textViewNumber.setText(demoInfo.get(position).getPhone_number());
        holder.textViewAddress.setText(demoInfo.get(position).getAddress());
        holder.textViewBlood.setText(demoInfo.get(position).getBlood_group());
    }

    @Override
    public int getItemCount() {
        return demoInfo.size();
    }


}
