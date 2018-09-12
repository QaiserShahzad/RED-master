package red.softgrip.com.red.UserActivities;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

import red.softgrip.com.red.UserAdapter.SpinnerAdapter;
import red.softgrip.com.red.R;
import red.softgrip.com.red.UserUtils.SpinnerItemsData;

public class Login extends AppCompatActivity {

    TextView textViewRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);




        // spinners Items
        ArrayList<SpinnerItemsData> list=new ArrayList<>();
        list.add(new SpinnerItemsData("USER",R.drawable.user));
        list.add(new SpinnerItemsData("SERVICE PROVIDER",R.drawable.service_provider));
        list.add(new SpinnerItemsData("WORKSHOP",R.drawable.workshop));
        Spinner sp=(Spinner)findViewById(R.id.spinnerLogin);
        SpinnerAdapter adapter=new SpinnerAdapter(this,
                R.layout.spinner_layout,R.id.txt,list);
        sp.setAdapter(adapter);

        // UnderLine Register
        textViewRegister = (TextView)findViewById(R.id.tv_Register);
        textViewRegister.setPaintFlags(textViewRegister.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        textViewRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUp.class));
            }
        });



    }
}
