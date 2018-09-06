package red.softgrip.com.red.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import red.softgrip.com.red.R;

public class ComplUsrHstory extends AppCompatActivity {


    TextView textViewStart,textViewEndPoint,textViewSTime,textViewETime,textViewamnt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compl_usr_hstory);

        textViewStart=(TextView)findViewById(R.id.start_locate_profile);
        textViewEndPoint=(TextView)findViewById(R.id.end_locate_profile);
        textViewSTime=(TextView)findViewById(R.id.startTime_profile);
//        textViewETime=(TextView)findViewById(R.id.tv_time);
        textViewamnt=(TextView)findViewById(R.id.amount_profile);


        Bundle bundle = getIntent().getExtras();


        String SPoint = bundle.getString("sPoint");
        textViewStart.setText(SPoint);

        String EPoint = bundle.getString("ePoint");
        textViewEndPoint.setText(EPoint);

        String STime = bundle.getString("sTime");
        textViewSTime.setText(STime);

//        String ETime = bundle.getString("time");
//        textViewETime.setText(ETime);

        String Amount = bundle.getString("amont");
        textViewamnt.setText(Amount);
    }
}
