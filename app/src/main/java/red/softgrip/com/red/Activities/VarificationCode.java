//package red.softgrip.com.red.Activities;
//
//import android.graphics.Paint;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import red.softgrip.com.red.R;
//
//public class VarificationCode extends AppCompatActivity implements View.OnClickListener{
//
//
//    EditText editTextCode1, editTextCode2, editTextCode3, editTextCode4;
//
//    TextView textViewResend;
//    TextView textView_1,
//            textView_2,
//            textView_3,
//            textView_4,
//            textView_5,
//            textView_6,
//            textView_7,
//            textView_8,
//            textView_9,
//            textView_0,
//            textView_x;
//
//    int counter = 0;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_varification_code);
//        editTextCode1 = (EditText) findViewById(R.id.et_code1);
//        editTextCode2 = (EditText) findViewById(R.id.et_code2);
//        editTextCode3 = (EditText) findViewById(R.id.et_code3);
//        editTextCode4 = (EditText) findViewById(R.id.et_code4);
//        textView_1 = (TextView) findViewById(R.id.tv_1);
//        textView_2 = (TextView) findViewById(R.id.tv_2);
//        textView_3 = (TextView) findViewById(R.id.tv_3);
//        textView_4 = (TextView) findViewById(R.id.tv_4);
//        textView_5 = (TextView) findViewById(R.id.tv_5);
//        textView_6 = (TextView) findViewById(R.id.tv_6);
//        textView_7 = (TextView) findViewById(R.id.tv_7);
//        textView_8 = (TextView) findViewById(R.id.tv_8);
//        textView_9 = (TextView) findViewById(R.id.tv_9);
//        textView_0 = (TextView) findViewById(R.id.tv_0);
//        textView_x = (TextView) findViewById(R.id.tv_x);
//
//
//
//        textView_1.setOnClickListener(this);
//        textView_2.setOnClickListener(this);
//        textView_3.setOnClickListener(this);
//        textView_4.setOnClickListener(this);
//        textView_5.setOnClickListener(this);
//        textView_6.setOnClickListener(this);
//        textView_7.setOnClickListener(this);
//        textView_8.setOnClickListener(this);
//        textView_9.setOnClickListener(this);
//        textView_0.setOnClickListener(this);
//        textView_x.setOnClickListener(this);
//
//
//        // UnderLine Register
//        textViewResend = (TextView) findViewById(R.id.tv_resend);
//        textViewResend.setPaintFlags(textViewResend.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
//    }
//
//    public void onClick(View v) {
//
//        switch (v.getId()) {
//            case R.id.tv_1:
//                if (counter <= 3) {
//                    setData(counter, "1");
//
//                }
//
//                break;
//            case R.id.tv_2:
//                if (counter <= 3) {
//                    setData(counter, "2");
//
//                }
//                break;
//            case R.id.tv_3:
//                if (counter <= 3) {
//                    setData(counter, "3");
//
//                }
//                break;
//            case R.id.tv_4:
//                if (counter <= 3) {
//                    setData(counter, "4");
//
//                }
//                break;
//            case R.id.tv_5:
//                if (counter <= 3) {
//                    setData(counter, "5");
//
//                }
//                break;
//            case R.id.tv_6:
//                if (counter <= 3) {
//                    setData(counter, "6");
//
//                }
//                break;
//            case R.id.tv_7:
//                if (counter <= 3) {
//                    setData(counter, "7");
//
//                }
//                break;
//            case R.id.tv_8:
//                if (counter <= 3) {
//                    setData(counter, "8");
//
//                }
//                break;
//            case R.id.tv_9:
//                if (counter <= 3) {
//                    setData(counter, "9");
//
//                }
//                break;
//            case R.id.tv_0:
//                if (counter <= 3) {
//                    setData(counter, "0");
//
//                }
//                break;
//            case R.id.tv_x:
//                if (counter >= 0) {
//                    removeData(counter);
//                    if (counter > 0)
//                        counter--;
//                }
//                break;
//
//
//        }
//    }
//
//    public void removeData(int index) {
//        switch (index) {
//            case 0:
//                editTextCode1.setText("");
//                break;
//            case 1:
//                editTextCode2.setText("");
//                break;
//            case 2:
//                editTextCode3.setText("");
//                break;
//            case 3:
//                editTextCode4.setText("");
//                break;
//
//        }
//    }
//
//
//    @Override
//    public void onPointerCaptureChanged(boolean hasCapture) {
//
//    }
//
//    public void setData(int index, String data) {
//        switch (index) {
//            case 0:
//                editTextCode1.setText(data);
//                if (counter <3)
//                    counter++;
//                break;
//
//            case 1:
//                counter++;
//                editTextCode2.setText(data);
//                break;
//            case 2:
//                counter++;
//                editTextCode3.setText(data);
//                break;
//            case 3:
//                if (editTextCode4.getText().toString().isEmpty())
//                    editTextCode4.setText(data);
//                break;
//        }
//    }
//}
