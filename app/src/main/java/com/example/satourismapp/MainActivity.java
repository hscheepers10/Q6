package com.example.satourismapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declare variables.
    SQLiteHelper sqLiteHelper;
    TextView resTv;
    Spinner spinner;
    int spinnerValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Adding Places.
        sqLiteHelper = new SQLiteHelper(this);

        sqLiteHelper.addPlace(new PlaceDetails("1","Gauteng","Union Buildings"));
        sqLiteHelper.addPlace(new PlaceDetails("2","Western Cape","Table Mountain"));
        sqLiteHelper.addPlace(new PlaceDetails("3","KwaZulu Natal","uShaka Marine World"));
        sqLiteHelper.addPlace(new PlaceDetails("4","Eastern Cape","Addo Elephant National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("5","Northern Cape","Augrabies Falls National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("6","Mpumalanga","Kruger National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("7","Limpopo","Mapungubwe National Park"));
        sqLiteHelper.addPlace(new PlaceDetails("8","North West","Sun City Resort"));
        sqLiteHelper.addPlace(new PlaceDetails("9","Free State","Free State National Botanical Garden"));

        //Getting data from DB.
        spinnerValue = spinner.getSelectedItemPosition();
        switch (spinnerValue){
            case 0:


//                PlaceDetails place1 = sqLiteHelper.getPLaceDetails(new PlaceDetails("1",null,null));
                resTv = sqLiteHelper.getPLaceDetails(new PlaceDetails("1",null,null).getPlace());
                break;
        }
    }
}