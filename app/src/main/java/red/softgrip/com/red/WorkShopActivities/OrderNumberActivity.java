package red.softgrip.com.red.WorkShopActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import red.softgrip.com.red.R;

public class OrderNumberActivity extends AppCompatActivity {


    Button buttonShowMap;
    TextView textViewvehicleNo,textViewvehileInfo,textViewTyreSize,textViewStartPoint,textViewEndPoint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_number);

        buttonShowMap=(Button)findViewById(R.id.btn_show_map);
        buttonShowMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),WsShowingMap.class));
            }
        });
    }
}
