package com.hasta.temp_converter;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private AutoCompleteTextView type, conv_to;
	private EditText value;
	private double conv;
	private Button btn;
	private TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ArrayAdapter<String> paths = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.temp));
        type = (AutoCompleteTextView)
                findViewById(R.id.type);        
        type.setAdapter(paths);
        
        conv_to = (AutoCompleteTextView)
                findViewById(R.id.conv_to);        
        conv_to.setAdapter(paths);
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
	
	public void convertTemp(){
		if (type.getText().toString().equals("celsius")&& conv_to.getText().toString().equals("fahrenheit")){
			conv=(Float.parseFloat(value.getText().toString())*1.8)+32;
			tv.setText(String.valueOf(conv)+"° F");
		}else if(type.getText().toString().equals("celsius")&& conv_to.getText().toString().equals("kelvin")){
			conv=Float.parseFloat(value.getText().toString())+273.15;
			tv.setText(String.valueOf(conv)+"° K");
		}else if (type.getText().toString().equals("fahrenheit")&& conv_to.getText().toString().equals("celsius")){
			conv=(Float.parseFloat(value.getText().toString())-32)/1.8;
			tv.setText(String.valueOf(conv)+"° C");
		}else if (type.getText().toString().equals("fahrenheit")&& conv_to.getText().toString().equals("kelvin")){
			conv=(Float.parseFloat(value.getText().toString())+459.67)/1.8;
			tv.setText(String.valueOf(conv)+"° K");
		}else if (type.getText().toString().equals("kelvin")&& conv_to.getText().toString().equals("celsius")){
			conv=Float.parseFloat(value.getText().toString())-273.15;
			tv.setText(String.valueOf(conv)+"° C");
		}else if (type.getText().toString().equals("kelvin")&& conv_to.getText().toString().equals("fahrenheit")){
			conv=Float.parseFloat(value.getText().toString())*1.8-459.67;
			tv.setText(String.valueOf(conv)+"° F");
		}
		
	}
}


