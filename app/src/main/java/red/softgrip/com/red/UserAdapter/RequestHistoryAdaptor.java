package red.softgrip.com.red.UserAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import red.softgrip.com.red.UserActivities.ComplUsrHstory;
import red.softgrip.com.red.R;

/**
 * Created by Qaiser on 2/23/2018.
 */

public class RequestHistoryAdaptor extends RecyclerView.Adapter<RequestHistoryAdaptor.ReqViewHolder>{

//    private Context mContext;
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
        final View view;
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
         view=inflater.inflate(R.layout.location_view_design,parent,false);

        final ReqViewHolder viewHolder=new ReqViewHolder(view);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(viewHolder.itemView.getContext(), ComplUsrHstory.class);
//                // sending data process
//                i.putExtra("anime_name",mData.get(viewHolder.getAdapterPosition()).getName());
////                i.putExtra("anime_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
////                i.putExtra("anime_studio",mData.get(viewHolder.getAdapterPosition()).getStudio());
////                i.putExtra("anime_category",mData.get(viewHolder.getAdapterPosition()).getCategorie());
////                i.putExtra("anime_nb_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());
//
                Bundle bundle=new Bundle();
//                bundle.putString("value","khana");
                bundle.putString("sPoint",viewHolder.textViewStartPoints.getText().toString());
                bundle.putString("ePoint",viewHolder.textViewEndPoints.getText().toString());
                bundle.putString("sTime",viewHolder.textViewSTime.getText().toString());
                bundle.putString("amont",viewHolder.textViewAmont.getText().toString());

               i.putExtras(bundle);
//
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                viewHolder.itemView.getContext().startActivity(i);

            }
        });
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
        holder.textViewSTime.setText(Tmee);
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

        TextView textViewStartPoints,textViewEndPoints,textViewDate,textViewSTime,textViewETime,textViewAmont;

//        LinearLayout view_Container;

        public ReqViewHolder(View itemView) {
            super(itemView);

//            view_Container=(LinearLayout)itemView.findViewById(R.id.container);
            textViewStartPoints=itemView.findViewById(R.id.start_locate);
            textViewEndPoints=itemView.findViewById(R.id.end_locate);
            textViewDate=itemView.findViewById(R.id.tv_date);
            textViewSTime=itemView.findViewById(R.id.tv_time);
            textViewAmont=itemView.findViewById(R.id.tv_ammount);
        }
    }




}



