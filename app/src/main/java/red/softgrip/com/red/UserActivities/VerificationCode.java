package red.softgrip.com.red.UserActivities;

import android.content.Intent;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import red.softgrip.com.red.R;
//import com.goodiebag.pinview.Pinview;



public class VerificationCode extends AppCompatActivity{


    TextView tvOne;
    TextView tvTwo;
    TextView tvThree;
    TextView tvFour;
    TextView tvFive;
    TextView tvSix;
    TextView tvSeven;
    TextView tvEight;
    TextView tvNine;
    TextView tvZero;
    TextView show;
    EditText edtCode;
    TextView bckSpace;
    TextView back;
    TextView textViewResend;
    Button btnSubmit;
    String pwd;
//    SharedPrefHandler mySharePref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);
//        mySharePref=new SharedPrefHandler(getBaseContext());
        tvOne=(TextView) findViewById(R.id.tv_1);
        // UnderLine Register
        textViewResend = (TextView) findViewById(R.id.tv_resend);
        textViewResend.setPaintFlags(textViewResend.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        tvTwo=(TextView) findViewById(R.id.tv_2);

        tvThree=(TextView) findViewById(R.id.tv_3);
        tvFour=(TextView) findViewById(R.id.tv_4);
        tvFive=(TextView) findViewById(R.id.tv_5);
        tvSix=(TextView) findViewById(R.id.tv_6);
        tvSeven=(TextView) findViewById(R.id.tv_7);
        tvEight=(TextView) findViewById(R.id.tv_8);
        tvNine=(TextView) findViewById(R.id.tv_9);
        tvZero=(TextView) findViewById(R.id.tv_0);
        edtCode=(EditText) findViewById(R.id.edtPassword2);
        bckSpace=(TextView) findViewById(R.id.tv_x);
        back=(TextView) findViewById(R.id.tv_back);
        btnSubmit=(Button) findViewById(R.id.btn_submit);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtCode.equals("")) {
                    Toast.makeText(VerificationCode.this, "Please Enter pin", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(VerificationCode.this, "Registered Successfly", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),UserProfile.class));
                }
            }
        });
        bckSpace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String x=edtCode.getText().toString();
                if(x.length()>0) {

                    String y=x.substring(0,x.length() - 1);
                    edtCode.setText(y);

                }
                else {
                    edtCode.setText("");
                }
            }
        });
        tvOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCode.setText(edtCode.getText().toString()+"1");

            }
        });
        tvTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCode.setText(edtCode.getText().toString()+"2");

            }
        });

        tvThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCode.setText(edtCode.getText().toString()+"3");

            }
        });
        tvFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCode.setText(edtCode.getText().toString()+"4");

            }
        });
        tvFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCode.setText(edtCode.getText().toString()+"5");

            }
        });
        tvSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCode.setText(edtCode.getText().toString()+"6");
            }
        });
        tvSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCode.setText(edtCode.getText().toString()+"7");
            }
        });
        tvEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCode.setText(edtCode.getText().toString()+"8");
            }
        });
        tvNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCode.setText(edtCode.getText().toString()+"9");
            }
        });
        tvZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtCode.setText(edtCode.getText().toString()+"0");
            }
        });
    }


}
