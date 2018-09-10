package red.softgrip.com.red.WorkShopActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import red.softgrip.com.red.R;
import red.softgrip.com.red.WorkShopAdapter.WSAdapter;

public class NumbrOfOrder extends AppCompatActivity {


    private RecyclerView recyclerViewNoOfOrder;
    private RecyclerView.Adapter Orderadapter;
    private  RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbr_of_order);




        recyclerViewNoOfOrder=(RecyclerView)findViewById(R.id.location_history_recycler_view);
        recyclerViewNoOfOrder.setLayoutManager(new LinearLayoutManager(this));

        String[] OrdNumm={"Order No. 123","Order No. 1234","Order No. 12345","Order No. 123456","Order No. 12334567"};
        String[] CarNumm={"MIA 123","MIA 123","MIA 123","MIA 123","MIA 123"};
        recyclerViewNoOfOrder.setAdapter(new WSAdapter(OrdNumm,CarNumm));

    }
}
