package red.softgrip.com.red.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.sql.Time;

import red.softgrip.com.red.Adapter.RequestHistoryAdaptor;
import red.softgrip.com.red.R;

public class RequestHistory extends AppCompatActivity {


    private RecyclerView recyclerViewReqHistory;
    private RecyclerView.Adapter adapter;
    private  RecyclerView.LayoutManager layoutManager;



//    String[] EndP={"Saddar","Sadiqabad","7th Ave","IJP","Kameeti Chowk"};
//    String[] Dte={"22:50 Pm"};
//    String[] Tme={"5:15 Am"};
//    String[] Ammt={"$200"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_history);


        recyclerViewReqHistory=(RecyclerView)findViewById(R.id.location_history_recycler_view);
        recyclerViewReqHistory.setLayoutManager(new LinearLayoutManager(this));
        String[] StartP={"Khana Pull","Cock Pull","Rawat","Faizabad","6th Road"};
            String[] EndP={"Saddar","Sadiqabad","7th Ave","IJP","Kameeti Chowk"};
            String[] Dte={"2 Apr 2015","12 May 2016","1 June 2017","31 Aug 1994","23 Mar 2013"};
            String[] Tme={"7:09","8:37","1:23","2:45","24:12"};
            String[] Ammt={"$200","$350","$800","$50","$600"};

        recyclerViewReqHistory.setAdapter(new RequestHistoryAdaptor(StartP,EndP,Dte,Tme,Ammt));
//        ,Dte,Tme,Ammt));

//        recyclerViewReqHistory.setLayoutManager(layoutManager);
//        layoutManager=new LinearLayoutManager(this);
//        adapter=new RequestHistoryAdaptor(StartP,EndP,Dte,Tme,Ammt);
//
//
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setAdapter(adapter);
    }
}
