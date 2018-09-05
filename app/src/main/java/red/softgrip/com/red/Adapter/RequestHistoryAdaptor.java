package red.softgrip.com.red.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import red.softgrip.com.red.R;

/**
 * Created by Qaiser on 2/23/2018.
 */

public class RequestHistoryAdaptor extends RecyclerView.Adapter<RequestHistoryAdaptor.ReqViewHolder>{

    private String[] StartPoint;
    private String[] EndPoint;
    private String[] Date;
    private String[] Time;
    private String[] Amnt;

    public RequestHistoryAdaptor(String[] startPoint, String[] endPoint, String[] date, String[] time, String[] amnt)
    {
            this.StartPoint=startPoint;
            this.EndPoint=endPoint;
            this.Date=date;
            this.Time=time;
            this.Amnt=amnt;
    }

    @Override
    public ReqViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.location_view_design,parent,false);
        return new ReqViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReqViewHolder holder, int position) {

        String StartLoc=StartPoint[position];
        holder.textViewStartPoints.setText(StartLoc);
        String EndtLoc=EndPoint[position];
        holder.textViewEndPoints.setText(EndtLoc);
        String Dtee=Date[position];
        holder.textViewDate.setText(Dtee);
        String Tmee=Time[position];
        holder.textViewTimes.setText(Tmee);
        String Ammnt=Amnt[position];
        holder.textViewAmont.setText(Ammnt);
    }

    @Override
    public int getItemCount() {
        return StartPoint.length;
    }
//    String[] StartPoint,EndPint,Date,Time,Ammount;



    public class ReqViewHolder extends RecyclerView.ViewHolder
    {

        TextView textViewStartPoints,textViewEndPoints,textViewDate,textViewTimes,textViewAmont;
        public ReqViewHolder(View itemView) {
            super(itemView);
            textViewStartPoints=itemView.findViewById(R.id.start_locate);
            textViewEndPoints=itemView.findViewById(R.id.end_locate);
            textViewDate=itemView.findViewById(R.id.tv_date);
            textViewTimes=itemView.findViewById(R.id.tv_time);
            textViewAmont=itemView.findViewById(R.id.tv_ammount);
        }
    }




}



