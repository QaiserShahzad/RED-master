package red.softgrip.com.red.WorkShopActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import red.softgrip.com.red.R;

public class OrderNumberActivity extends AppCompatActivity {


    TextView textViewvehicleNo,textViewvehileInfo,textViewTyreSize,textViewStartPoint,textViewEndPoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_number);
    }
}
