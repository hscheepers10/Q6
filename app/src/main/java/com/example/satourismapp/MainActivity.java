package com.example.satourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

import java.net.IDN;

public class MainActivity extends AppCompatActivity {

    //Declare variables.
    SQLiteHelper sqLiteHelper;
    TextView result;
    Spinner transferOption;
    String id;
    int spinnerChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.resTv);

        //Adding Places.
        sqLiteHelper = new SQLiteHelper(this);

        //Populating Database.
        sqLiteHelper.addPlace(new PlaceDetails("1","Gauteng","Union Buildings"));
        sqLiteHelper.addPlace(new PlaceDetails("2","Western Cape","Table Mountain"));
        sqLiteHelper.addPlace(new PlaceDetails("3","KwaZulu Natal","uShaka Marine World"));
        sqLiteHelper.addPlace(new PlaceDetails("4","Eastern Cape","Addo Elephant National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("5","Northern Cape","Augrabies Falls National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("6","Mpumalanga","Kruger National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("7","Limpopo","Mapungubwe National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("8","North West","Sun City Resort"));
        sqLiteHelper.addPlace(new PlaceDetails("9","Free State","Free State National Botanical Garden"));


        transferOption = (findViewById(R.id.spinner));
        spinnerChoice = transferOption.getSelectedItemPosition();

        PlaceDetails curPlace;
        String id;
            switch (spinnerChoice) {
                case 0:
                    id = "1";
                    curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(id, null, null));
                    result.setText(curPlace.getPlace());
                    break;
                case 1:
                    id = "2";
                    curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(id, null, null));
                    result.setText(curPlace.getPlace());
                    break;
                case 2:
                    id = "3";
                    curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(id, null, null));
                    result.setText(curPlace.getPlace());
                    break;
                case 3:
                    id = "4";
                    curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(id, null, null));
                    result.setText(curPlace.getPlace());
                    break;
                case 4:
                    id = "5";
                    curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(id, null, null));
                    result.setText(curPlace.getPlace());
                    break;
                case 5:
                    id = "6";
                    curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(id, null, null));
                    result.setText(curPlace.getPlace());
                    break;
                case 6:
                    id = "7";
                    curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(id, null, null));
                    result.setText(curPlace.getPlace());
                    break;
                case 7:
                    id = "8";
                    curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(id, null, null));
                    result.setText(curPlace.getPlace());
                    break;
                case 8:
                    id = "9";
                    curPlace = sqLiteHelper.getPLaceDetails(new PlaceDetails(id, null, null));
                    result.setText(curPlace.getPlace());
                    break;
            }
   }
}