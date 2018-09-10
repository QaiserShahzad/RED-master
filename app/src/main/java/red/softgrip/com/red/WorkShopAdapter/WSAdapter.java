package red.softgrip.com.red.WorkShopAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import red.softgrip.com.red.R;
import red.softgrip.com.red.WorkShopActivities.OrderNumberActivity;

/**
 * Created by Qaiser Pasha on 9/8/2018.
 */

public class WSAdapter extends RecyclerView.Adapter<WSAdapter.OrderViewHolder>{


    private String[] OrderNum;
    private String[] CarNum;

    public WSAdapter( String[] orderNum, String[] carNum)
    {
    this.OrderNum=orderNum;
    this.CarNum=carNum;
    }

    @Override
    public WSAdapter.OrderViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View view;
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        view=inflater.inflate(R.layout.order_view_design,parent,false);

        final WSAdapter.OrderViewHolder viewHolder=new WSAdapter.OrderViewHolder(view);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(viewHolder.itemView.getContext(), OrderNumberActivity.class);
//                // sending data process
//                i.putExtra("anime_name",mData.get(viewHolder.getAdapterPosition()).getName());
////                i.putExtra("anime_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
////                i.putExtra("anime_studio",mData.get(viewHolder.getAdapterPosition()).getStudio());
////                i.putExtra("anime_category",mData.get(viewHolder.getAdapterPosition()).getCategorie());
////                i.putExtra("anime_nb_episode",mData.get(viewHolder.getAdapterPosition()).getNb_episode());
//
                Bundle bundle=new Bundle();
//                bundle.putString("value","khana");
                bundle.putString("oNum",viewHolder.textViewOrderNum.getText().toString());
                bundle.putString("cNum",viewHolder.textViewCarNum.getText().toString());


                i.putExtras(bundle);
//
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                viewHolder.itemView.getContext().startActivity(i);

            }
        });
        return new WSAdapter.OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(WSAdapter.OrderViewHolder holder, int position) {

        String OrdNo=OrderNum[position];
        holder.textViewOrderNum.setText(OrdNo);
        String CarNo=CarNum[position];
        holder.textViewCarNum.setText(CarNo);
    }

    @Override
    public int getItemCount() {
        return OrderNum.length;
    }
//    String[] StartPoint,EndPint,Date,Time,Ammount;



    public class OrderViewHolder extends RecyclerView.ViewHolder
    {

        TextView textViewOrderNum,textViewCarNum;

//        LinearLayout view_Container;

        public OrderViewHolder(View itemView) {
            super(itemView);

//            view_Container=(LinearLayout)itemView.findViewById(R.id.container);
            textViewOrderNum=itemView.findViewById(R.id.tv_orderNo);
            textViewCarNum=itemView.findViewById(R.id.tv_carNo);

        }
    }




}



