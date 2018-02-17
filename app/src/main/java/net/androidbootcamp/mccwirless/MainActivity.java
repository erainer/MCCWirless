package net.androidbootcamp.mccwirless;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {


    double promo1;
    double promo2;
    double promo3;
    RadioGroup radGroup;
    int radioChecked = -1;
    double bill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result = (TextView) findViewById(R.id.result);
        Button calculate = (Button) findViewById(R.id.btnCalculate);

        RadioButton r1 = (RadioButton) findViewById(R.id.rad1);
        RadioButton r2 = (RadioButton) findViewById(R.id.rad2);
        RadioButton r3 = (RadioButton) findViewById(R.id.rad3);
        radGroup = (RadioGroup) findViewById(R.id.radGroup);



        radGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                System.out.println("results = " + checkedId);
                bill = 0;
                double monthly = 40;
                double multiple = 60;
                switch(checkedId){
                    case R.id.rad1:
                        promo1 = monthly+ 10;
                        bill = promo1;
                        break;
                    case R.id.rad2: promo2 = monthly * .10;
                        multiple -= promo2;
                        bill = multiple;
                        break;
                    case R.id.rad3:
                        promo3 = 10*.05;
                        monthly += promo3;
                        bill  = monthly;
                        break;
                    default: break;
                }
            }
        });

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat currency = new DecimalFormat("$###,###.##");
                result.setText(String.valueOf(currency.format(bill)));
            }
        });

    }
}
