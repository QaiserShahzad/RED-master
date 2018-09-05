package red.softgrip.com.red.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import red.softgrip.com.red.R;

public class Profile extends AppCompatActivity {

    Button buttonEditInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        buttonEditInfo=(Button)findViewById(R.id.btn_edit_info);
        buttonEditInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EditInformation.class));
            }
        });
    }
}
