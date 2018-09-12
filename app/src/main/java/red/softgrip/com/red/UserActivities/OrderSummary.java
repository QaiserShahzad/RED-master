package red.softgrip.com.red.UserActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import red.softgrip.com.red.R;

public class OrderSummary extends AppCompatActivity {


    Button buttonProcedToPayment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_summary);


        buttonProcedToPayment=(Button)findViewById(R.id.btn_proceed_payment);
        buttonProcedToPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TransitMap.class));
            }
        });
    }
}
