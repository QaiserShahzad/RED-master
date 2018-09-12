package red.softgrip.com.red.UserActivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import red.softgrip.com.red.GoogleMap.MapsActivity;
import red.softgrip.com.red.R;

public class TowingAgreement extends AppCompatActivity {

    Button buttonAgreement;
//    Dialog myDialog;
    LinearLayout linearContinue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_towing_agreement);

        linearContinue=(LinearLayout) findViewById(R.id.l_continue);

        buttonAgreement=(Button)findViewById(R.id.btn_yess);
        buttonAgreement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ShowPopup();
            }
        });

//        myDialog = new Dialog(this);

        linearContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),MapsActivity.class));
            }
        });
    }


//
//    public void ShowPopup() {
//        TextView txtclose;
//        Button btnOk;
//        myDialog.setContentView(R.layout.popup_design);
//        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
//        txtclose.setText("X");
//        btnOk = (Button) myDialog.findViewById(R.id.btn_popup_ok);
//        txtclose.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myDialog.dismiss();
//            }
//        });
//        btnOk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myDialog.dismiss();
//            }
//        });
//        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//        myDialog.show();
//    }
}
