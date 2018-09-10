package red.softgrip.com.red.GoogleMap;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.location.Address;
import android.location.Geocoder;
import android.nfc.Tag;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ZoomControls;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import red.softgrip.com.red.R;
import red.softgrip.com.red.UserActivities.OrderSummary;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {




    Button buttonSearch,buttonNext;
    Dialog myDialog;
    private GoogleMap mMap;
    private static final int LOCATION_REQUEST=500;
    ArrayList<LatLng> listPoints;
    EditText editTextSPoint,editTextEPoint;

//    private static final float DEFAULT_ZOOM = 15f;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
//        editTextSPoint=(EditText)findViewById(R.id.et_SPoint);
        editTextEPoint=(EditText)findViewById(R.id.et_EPoint);
        buttonSearch=(Button)findViewById(R.id.buttonSearchStartLocation);
        buttonNext=(Button)findViewById(R.id.btn_next);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        listPoints=new ArrayList<>();




        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowPopup();
            }
        });
        myDialog = new Dialog(this);

//        buttonSearch.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                EditText etLocat = (EditText) findViewById(R.id.et_SPoint);
//                String location = etLocat.getText().toString();
//                List<Address> addressList = null;
//                if (location != null || location.equals("")) {
//                    Geocoder geocoder = new Geocoder(getApplicationContext());
//                    try {
//                        addressList = geocoder.getFromLocationName(location, 1);
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    Address address = addressList.get(0);
//                    LatLng latLng = new LatLng(address.getLatitude(), address.getLongitude());
//                    mMap.addMarker(new MarkerOptions().position(latLng).title(location));
//                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
//                }
//
//            }
//        });




    }




    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setZoomControlsEnabled(true);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.ACCESS_FINE_LOCATION}, LOCATION_REQUEST);
            return;
        }


        mMap.setMyLocationEnabled(true);

        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                if (listPoints.size()==2)
                {
                    listPoints.clear();
                    mMap.clear();
                }
                // save forst point select
                listPoints.add(latLng);
                //Create marker
                MarkerOptions markerOptions=new MarkerOptions();
                markerOptions.position(latLng);
                if (listPoints.size()==1)
                {
                    // add first marker
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
//                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(R.drawable.ic_red_location));

                }
                else
                {
                    // Add second marker
                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED));
//                    markerOptions.icon(BitmapDescriptorFactory.defaultMarker(R.drawable.ic_blue_location));
                }
                mMap.addMarker(markerOptions);

                if (listPoints.size()==2)
                {
                    // create URL to get request from first marker to second marker
                    String url= getRequest(listPoints.get(0),listPoints.get(1));
                    TaskRequestDirection taskRequestDirection=new TaskRequestDirection();
                    taskRequestDirection.execute(url);


                }

            }
        });

//        init();

        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    private String getRequest(LatLng origion, LatLng dest) {

        // value of origion
        String str_org= "origin=" + origion.latitude + "," + origion.longitude;
        // value of destination
        String str_dest="destination=" + dest.latitude + "," + dest.longitude;
        // set value enable the sensor
        String sensor ="sensor=false";
        // Mode for find direction
        String mode= "mode=driving ";
        // Build the full param
        String param= str_org + "&" + str_dest + "&" + sensor + "&" + mode;
        // output formate
        String output="json";
        // CREATE URL to request
        String url="https://maps.googleapis.com/maps/api/directions/" + output + "?" + param;
        return url;
    }
    private String requestDirection(String reqUrl) throws IOException {
        String responseString = "";
        InputStream inputStream = null;
        HttpURLConnection httpURLConnection = null;
        try {
            URL url = new URL(reqUrl);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            // get the response result
            inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            StringBuffer stringBuffer = new StringBuffer();
            String line = "";
            while ((line = bufferedReader.readLine()) != null)
            {
                stringBuffer.append(line);
            }
            responseString = stringBuffer.toString();
            bufferedReader.close();
            inputStreamReader.close();

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (inputStream != null)
            {
                inputStream.close();
            }
            httpURLConnection.disconnect();
        }
        return responseString;
    }


    @SuppressLint("MissingPermission")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode)
        {
            case LOCATION_REQUEST:
                if (grantResults.length > 0 && grantResults[0]==  PackageManager.PERMISSION_GRANTED)
                {
                    mMap.setMyLocationEnabled(true);
                }
                break;
        }
    }

    public class TaskRequestDirection extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String responseString="";
            try {
                responseString=requestDirection(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return responseString;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            // parse JSON here
            TaskParser taskParser=new TaskParser();
            taskParser.execute(s);

        }
    }

    public    class TaskParser extends AsyncTask<String, Void, List<List<HashMap<String, String>>> >
    {

        @Override
        protected List<List<HashMap<String, String>>> doInBackground(String... strings) {
            JSONObject jsonObject=null;
            List<List<HashMap<String, String>>> route=null;
            try {
                jsonObject=new JSONObject(strings[0]);
                DirectionsParser directionsParser=new DirectionsParser();
                route=directionsParser.parse(jsonObject);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return route;
        }

        @Override
        protected void onPostExecute(List<List<HashMap<String, String>>> lists) {
            // Get list route and display into map
            ArrayList point=null;
            PolylineOptions polylineOptions=null;

            for (List<HashMap<String, String>> path : lists)
            {
                point=new ArrayList();
                polylineOptions=new PolylineOptions();

                for (HashMap<String, String> pointt : path){

                    double lat=Double.parseDouble(pointt.get("lat"));
                    double lon=Double.parseDouble(pointt.get("lon"));

                    point.add(new LatLng(lat,lon));
                }
                polylineOptions.addAll(point);
                polylineOptions.width(8);
                polylineOptions.color(Color.BLUE);
                polylineOptions.geodesic(true);
            }

            if (polylineOptions !=null)
            {
                mMap.addPolyline(polylineOptions);
            }
            else

            {
                Toast.makeText(MapsActivity.this, "Direction not found !", Toast.LENGTH_SHORT).show();
            }
        }
    }



    public void ShowPopup() {
        TextView txtclose;
        Button btnOk;
        myDialog.setContentView(R.layout.popup_design);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        btnOk = (Button) myDialog.findViewById(R.id.btn_popup_ok);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                myDialog.dismiss();
                showCarDetailPopup();

            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }



    public void showCarDetailPopup() {
        TextView txtclose;
        Button confirmCarDetail;
        myDialog.setContentView(R.layout.popup_design_car_detail);
        txtclose =(TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("X");
        confirmCarDetail = (Button) myDialog.findViewById(R.id.btn_popup_car_detail);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        confirmCarDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               startActivity(new Intent(getApplicationContext(), OrderSummary.class));


            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}

