package red.softgrip.com.red.UserAdapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import red.softgrip.com.red.R;
import red.softgrip.com.red.UserUtils.SpinnerItemsData;

/**
 * Created by Qaiser Pasha on 8/31/2018.
 */

public class SpinnerAdapter extends ArrayAdapter<SpinnerItemsData> {


    int groupid;
    Activity context;
    ArrayList<SpinnerItemsData> list;
    LayoutInflater inflater;
    public SpinnerAdapter(Activity context, int groupid, int id, ArrayList<SpinnerItemsData>
            list){
        super(context,id,list);
        this.list=list;
        inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.groupid=groupid;
    }

    public View getView(int position, View convertView, ViewGroup parent ){
        View itemView=inflater.inflate(groupid,parent,false);
        ImageView imageView=(ImageView)itemView.findViewById(R.id.img);
        imageView.setImageResource(list.get(position).getImageId());
        TextView textView=(TextView)itemView.findViewById(R.id.txt);
        textView.setText(list.get(position).getText());
        return itemView;
    }

    public View getDropDownView(int position, View convertView, ViewGroup
            parent){
        return getView(position,convertView,parent);

    }


}
