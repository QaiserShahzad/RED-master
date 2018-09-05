package red.softgrip.com.red.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

import red.softgrip.com.red.Adapter.SpinnerAdapter;
import red.softgrip.com.red.R;
import red.softgrip.com.red.Utils.SpinnerItemsData;


public class SignUp extends AppCompatActivity {

    Button buttonRegister;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        // spinners Items
        ArrayList<SpinnerItemsData> list=new ArrayList<>();
        list.add(new SpinnerItemsData("USER",R.drawable.user));
        list.add(new SpinnerItemsData("SERVICE PROVIDER",R.drawable.service_provider));
        list.add(new SpinnerItemsData("WORKSHOP",R.drawable.workshop));
        Spinner sp=(Spinner)findViewById(R.id.spinnerSignUp);
        SpinnerAdapter adapter=new SpinnerAdapter(this,
                R.layout.spinner_layout,R.id.txt,list);
        sp.setAdapter(adapter);


        buttonRegister=(Button)findViewById(R.id.btn_register);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),VerificationCode.class));
            }
        });
    }
}
