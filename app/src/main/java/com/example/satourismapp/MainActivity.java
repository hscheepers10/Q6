package com.example.satourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare variables.
    SQLiteHelper sqLiteHelper;
    TextView result;
    Spinner provinceSpinner;
    int spinnerChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.resTv);

        //Adding Places through the SQLite helper class.
        sqLiteHelper = new SQLiteHelper(this);

        //Populating Database using the addPlace method in the SQLite helper class.
        sqLiteHelper.addPlace(new PlaceDetails("1","Gauteng","Union Buildings"));
        sqLiteHelper.addPlace(new PlaceDetails("2","Western Cape","Table Mountain"));
        sqLiteHelper.addPlace(new PlaceDetails("3","KwaZulu Natal","uShaka Marine World"));
        sqLiteHelper.addPlace(new PlaceDetails("4","Eastern Cape","Addo Elephant National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("5","Northern Cape","Augrabies Falls National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("6","Mpumalanga","Kruger National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("7","Limpopo","Mapungubwe National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("8","North West","Sun City Resort"));
        sqLiteHelper.addPlace(new PlaceDetails("9","Free State","Free State National Botanical Garden"));

        //finding spinner in XML.
        provinceSpinner = (findViewById(R.id.spinner));

        //Spinner gets its onItemSelectedListener.
        provinceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            PlaceDetails curPlace;
            String sid;
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerChoice = provinceSpinner.getSelectedItemPosition();

                //Switch statement uses the spinnerChoice value to determine which case needs to be used.
                //the spinnerChoice value is derived from the spinner in XML's current position.
                switch (spinnerChoice){
                    case 0:
                        sid = "1";
                        curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(sid, null, null));
                        result.setText(curPlace.getPlace());
                        break;
                    case 1:
                        sid = "2";
                        curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(sid, null, null));
                        result.setText(curPlace.getPlace());
                        break;
                    case 2:
                        sid = "3";
                        curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(sid, null, null));
                        result.setText(curPlace.getPlace());
                        break;
                    case 3:
                        sid = "4";
                        curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(sid, null, null));
                        result.setText(curPlace.getPlace());
                        break;
                    case 4:
                        sid = "5";
                        curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(sid, null, null));
                        result.setText(curPlace.getPlace());
                        break;
                    case 5:
                        sid = "6";
                        curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(sid, null, null));
                        result.setText(curPlace.getPlace());
                        break;
                    case 6:
                        sid = "7";
                        curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(sid, null, null));
                        result.setText(curPlace.getPlace());
                        break;
                    case 7:
                        sid = "8";
                        curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(sid, null, null));
                        result.setText(curPlace.getPlace());
                        break;
                    case 8:
                        sid = "9";
                        curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(sid, null, null));
                        result.setText(curPlace.getPlace());
                        break;
                }
            }
            //If no item is selected, nothing is supposed to happen but this method is a package deal.
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                result.setText("Naaani");
            }
        });
   }
}