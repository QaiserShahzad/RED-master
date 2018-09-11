package red.softgrip.com.red.SPActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import red.softgrip.com.red.R;

public class NewRequest extends AppCompatActivity {

    Button buttonAccept;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_request);

        buttonAccept=(Button)findViewById(R.id.btn_sp_accept);
        buttonAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SpOrderNumb.class));
            }
        });
    }
}
