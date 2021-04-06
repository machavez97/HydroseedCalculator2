package com.example.hydroseedcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView SiteSizeLabel, ApplicationRateLabel, TankSizeLabel, MixRateLabel, NumberOfBagsLabel,
    NumberOfTrucksLabel, BagsOutput, NumberOfTrucksOutput;
    EditText SiteSizeInput;
    EditText TankSizeInput;
    EditText MixingRateInput;
    EditText ApplicationRateInput;
    EditText projectNameInput;
    Button calculate;
    double numBags, numTrucks, siteSize, tankSize, mixingRate, appRate;
    int bagSize = 50, acre = 43560;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BagsOutput = (TextView)findViewById(R.id.BagsOutput);
        NumberOfTrucksOutput = (TextView)findViewById(R.id.NumberOfTrucksOutput);

        NumberOfBagsLabel = (TextView)findViewById(R.id.NumberOfBagsLabel);
        NumberOfTrucksLabel = (TextView)findViewById(R.id.NumberOfTrucksLabel);
        projectNameInput = (EditText)findViewById(R.id.projectNameInput);

        SiteSizeInput = (EditText) findViewById(R.id.SiteSizeInput);
        TankSizeInput = (EditText) findViewById(R.id.TankSizeInput);
        MixingRateInput = (EditText) findViewById(R.id.MixingRateInput);
        ApplicationRateInput = (EditText) findViewById(R.id.ApplicationRateInput);



        calculate = (Button)findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                siteSize = Double.parseDouble(SiteSizeInput.getText().toString());
                tankSize = Double.parseDouble(TankSizeInput.getText().toString());
                mixingRate = Double.parseDouble(MixingRateInput.getText().toString());
                appRate = Double.parseDouble(ApplicationRateInput.getText().toString());
                numBags =  java.lang.Math.ceil(siteSize / acre * appRate / bagSize);
                numTrucks = java.lang.Math.ceil(siteSize / acre * appRate/ mixingRate / tankSize);
                BagsOutput.setText(String.valueOf(numBags));
                NumberOfTrucksOutput.setText(String.valueOf(numTrucks));


                //projectNameInput = projectNameInput.getText().toString();
            }
        });





    }
}