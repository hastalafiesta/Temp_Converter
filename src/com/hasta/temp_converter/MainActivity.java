package com.hasta.temp_converter;


import java.text.DecimalFormat;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Spinner initial_temp, conv_to;
	private EditText value;
	private double conv;
	private Button btn;
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        initial_temp = (Spinner)
                findViewById(R.id.type); 
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(MainActivity.this, R.array.temp, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        initial_temp.setAdapter(adapter);
        
        conv_to = (Spinner)
                findViewById(R.id.conv_to);        
        conv_to.setAdapter(adapter);
        tv=(TextView)findViewById(R.id.tv);
        btn=(Button)findViewById(R.id.avanti);
        value=(EditText)findViewById(R.id.value);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
            	convertTemp();           	
            }
        });
     }
	public String format(double temp, String sym, String sym2) {
		DecimalFormat f = new DecimalFormat("00.00");
		String string = f.format(temp);
		tv.setBackgroundResource(R.drawable.custom);
		tv.setPadding(10, 10, 10, 10);
        tv.setText(value.getText().toString()+sym2+" corrispondono a "+string+sym);
        return string;  
        
	}
	public void convertTemp(){
		if (initial_temp.getSelectedItem().equals("celsius")&& conv_to.getSelectedItem().equals("fahrenheit")){			
			conv=(Float.parseFloat(value.getText().toString())*1.8)+32;
			format(conv, "° F", "° C");
		}else if(initial_temp.getSelectedItem().equals("celsius")&& conv_to.getSelectedItem().equals("kelvin")){
			conv=Float.parseFloat(value.getText().toString())+273.15;
			format(conv, "° K", "° C");
		}else if (initial_temp.getSelectedItem().equals("fahrenheit")&& conv_to.getSelectedItem().equals("celsius")){
			conv=(Float.parseFloat(value.getText().toString())-32)/1.8;
			format(conv, "° C", "° F");
		}else if (initial_temp.getSelectedItem().equals("fahrenheit")&& conv_to.getSelectedItem().equals("kelvin")){
			conv=(Float.parseFloat(value.getText().toString())+459.67)/1.8;
			format(conv, "° K", "° F");
		}else if (initial_temp.getSelectedItem().equals("kelvin")&& conv_to.getSelectedItem().equals("celsius")){
			conv=Float.parseFloat(value.getText().toString())-273.15;
			format(conv, "° C", "° K");
		}else if (initial_temp.getSelectedItem().equals("kelvin")&& conv_to.getSelectedItem().equals("fahrenheit")){
			conv=Float.parseFloat(value.getText().toString())*1.8-459.67;
			format(conv, "° F", "° K");
		}
		
	}
}


