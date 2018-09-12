package red.softgrip.com.red.UserActivities;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import red.softgrip.com.red.R;

public class UserProfile extends AppCompatActivity {


    LinearLayout linearLayoutProfile,linearLayoutRequestHistory,linearLayoutPayment,linearLayoutFaq;

    TextView textViewLogout,textViewMenu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        linearLayoutProfile=(LinearLayout)findViewById(R.id.linear_profile);
        linearLayoutPayment=(LinearLayout)findViewById(R.id.linear_payment);
        linearLayoutRequestHistory=(LinearLayout)findViewById(R.id.linear_request_history);
        linearLayoutFaq=(LinearLayout)findViewById(R.id.linear_faq);

        textViewMenu=(TextView)findViewById(R.id.tv_menu);


        textViewLogout = (TextView) findViewById(R.id.tv_logout);
        textViewLogout.setPaintFlags(textViewLogout.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        linearLayoutProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Profile.class));
            }
        });


        linearLayoutRequestHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),RequestHistory .class));
            }
        });

        textViewMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),WelcomeScreen.class));
            }
        });
    }
}
