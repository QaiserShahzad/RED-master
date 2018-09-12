package red.softgrip.com.red.UserActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import red.softgrip.com.red.R;

public class WelcomeScreen extends AppCompatActivity {


    LinearLayout linearLayoutTow;
    Button buttonRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);


        linearLayoutTow=(LinearLayout)findViewById(R.id.L_Tow);
        buttonRequest=(Button)findViewById(R.id.btn_submit);
        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),UserProfile.class));
            }
        });
        linearLayoutTow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),TowingAgreement.class));
            }
        });
    }
}