package com.hfad.beeradviser;

import android.app.Activity;

import android.os.Bundle;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends Activity {

    private BeerExpert expert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    //called when the user clicks the button
    public void onClickFindBeer(View view) {
        //get a reference to the TextView
        TextView brands = (TextView) findViewById(R.id.brands);

        //get a reference to the Spinner
        Spinner color = (Spinner) findViewById(R.id.color);

        //get the selected item in the spinner
        String beerType = String.valueOf(color.getSelectedItem());

        //get recommendations from the beer expert class
        List<String> brandsList = expert.getBrands(beerType);
        StringBuilder brandsFormatted = new StringBuilder();

        for (String brand : brandsList) {
            brandsFormatted.append(brand).append('\n');
        }

        //display the beers
        brands.setText(brandsFormatted);

    }
}