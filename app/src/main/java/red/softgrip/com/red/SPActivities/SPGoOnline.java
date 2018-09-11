package red.softgrip.com.red.SPActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import red.softgrip.com.red.R;

public class SPGoOnline extends AppCompatActivity {

    Button buttonGoOnine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spgo_online);

        buttonGoOnine=(Button)findViewById(R.id.btn_go_online);
        buttonGoOnine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),NewRequest.class));
            }
        });
    }
}
