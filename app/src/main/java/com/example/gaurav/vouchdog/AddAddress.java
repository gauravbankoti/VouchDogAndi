package com.example.gaurav.vouchdog;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class AddAddress extends AppCompatActivity {
    private LinearLayout  container;
    private EditText textIn;
    private Button  buttonAdd;
    Spinner s6,s7;
    EditText ed8,ed36,ed24,ed23,ed25,ed26;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_address);

        container = (LinearLayout) findViewById(R.id.linearLayout9);
        textIn = (EditText) findViewById(R.id.editText26);
        buttonAdd = (Button) findViewById(R.id.button);

        s6=(Spinner)findViewById(R.id.spinner13);
        s7=(Spinner)findViewById(R.id.spinner14);


        ed8=(EditText)findViewById(R.id.editText8);
        ed36=(EditText)findViewById(R.id.editText36);
        ed24=(EditText)findViewById(R.id.editText24);
        ed23=(EditText)findViewById(R.id.editText23);
        ed25=(EditText)findViewById(R.id.editText25);
        ed26=(EditText)findViewById(R.id.editText26);



        buttonAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                LayoutInflater layoutInflater =
                        (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                final View addView = layoutInflater.inflate(R.layout.row, null);
                TextView textOut = (TextView)addView.findViewById(R.id.textout);



                String add1=ed24.getText().toString();
                String add2= ed23.getText().toString();
                String coun1=s6.getSelectedItem().toString();
                String coun2=ed8.getText().toString();
                String stat1=s7.getSelectedItem().toString();
                String stat2=ed36.getText().toString();
                String city=ed25.getText().toString();
                String pin=ed26.getText().toString();
                textOut.append("Address1:-"+add1+"\n");
                textOut.append("Address2:-"+add2+"\n");

                if(coun1=="Others")
                {
                    textOut.append("Country:-"+coun2+"\n");
                }
                else
                {
                    textOut.append("Country:-"+coun1+"\n");
                }


                if(stat1=="State")
                {
                    textOut.append("State:-"+stat2+"\n");
                }
                else
                {
                    textOut.append("State:-"+stat1+"\n");
                }
                textOut.append("City:-"+city+"\n");
                textOut.append("Pin/Zip Code:-"+pin+"\n");







               // textOut.setText(textIn.getText().toString());
                Button buttonRemove = (Button)addView.findViewById(R.id.remove);
                buttonRemove.setOnClickListener(new View.OnClickListener(){

                    @Override
                    public void onClick(View v) {
                        ((LinearLayout)addView.getParent()).removeView(addView);
                    }});

                container.addView(addView);
            }});



        String str2[]={"Country","Australia","Canada","India","New Zealand","Singapore","United Kingdom","United States","Others"};
        ArrayAdapter<String> spinnerArrayAdapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, str2);
        spinnerArrayAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s6.setAdapter(spinnerArrayAdapter4);

        String str10[]={"State"};
        ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item, str10);
        spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        s7.setAdapter(spinnerArrayAdapter5);


        s6.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==1)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str4[]={"State","Australian Capital Terrotory","New South Wales","Northern Territory","Queensland","South Australia","Tasmania","Victoria","Western Australia"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddAddress.this,android.R.layout.simple_spinner_dropdown_item, str4);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);


                }
                else if(position==2)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str5[]={"State","Alberta","British Columbia","Manitoba","New Brunswick","Newfoundland and Labrador","Northwest Territories","Nova Scotia","Nunavut","Ontario","Prince Edward Island","Quebec","Saskatchewan","Yukon"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddAddress.this,android.R.layout.simple_spinner_dropdown_item, str5);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);


                }

                else if(position==3)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str3[]={"State","Andhara Pradesh","Arunanchal Pradesh","Assam","Bihar","Chhattisgarh","Goa","Gujrat","Haryana","Himanchal Pradesh","Jammu and Kashmir",
                            "Jharkhand","Karnataka","Kerala","Madhya Pradesh","Maharastra","Manipur","Meghalaya","Mizoram","Nagaland","Odisha(Orissa)","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana",
                            "Tripura","Uttar Pradesh","Uttarakhand","West Bengal"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddAddress.this,android.R.layout.simple_spinner_dropdown_item, str3);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);

                }
                else if(position==4)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str6[]={"State","Auckland","Canterbur","Wellington","Waikato","Bay of Plenty","Manawatu-Wanganui","Otago","Hawke's Bay","Northland","Taranaki","Southland","Nelson","Gisborne","Marlborough","Tasman","West Coast"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddAddress.this,android.R.layout.simple_spinner_dropdown_item, str6);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);

                }

                else if(position==5)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str7[]={"State","Singapore"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddAddress.this,android.R.layout.simple_spinner_dropdown_item, str7);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);


                }
                else if(position==6) {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str8[] = {"State", "London", "West Midlands", "Lancashire", "Nottinghamshire", "Cheshire", "Staffordshire", "Derbyshire", "Norfolk", "West Sussex", "Northamptonshire", "Oxfordshire", "Devon", "Suffolk",
                            "Lincolnshire", "Gloucestershire", "Leicestershire", "Cambridgeshire", "East Sussex", "Durham", "Bristol", "Warwickshire", "Buckinghamshire", "North Yorkshire", "Bedfordshire", "Cumbria",
                            "Somerset", "Cornwall", "Wiltshire", "Shropshire", "Leicester", "Worcestershire", "Kingston upon Hull", "Plymouth", "Stoke-on-Trent", "Derby", "Dorset", "Nottingham", "Southampton", "Brighton and Hove",
                            "Herefordshire", "Northumberland", "Portsmouth", "East Riding of Yorkshire", "Luton", "Blackpool", "North East Lincolnshire", "Middlesbrough", "Stockton-on-Tees", "Blackburn with Darwen", "Torbay",
                            "Poole", "Windsor and Maidenhead", "North Lincolnshire", "Bath and North East Somerset", "Slough", "Halton", "Isle of Wight", "Bracknell Forest", "Hartlepool", "Darlington", "West Berkshire",
                            "Redcar and Cleveland", "Wokingham", "Rutland"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddAddress.this, android.R.layout.simple_spinner_dropdown_item, str8);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);
                }
                else if(position==7)
                {
                    ed36.setVisibility(View.GONE);
                    s7.setVisibility(View.VISIBLE);
                    String str9[]={"State","Alabama", "Alaska", "Arizona", "Arkansas", "Armed Forces America", "Armed Forces Pacific", "California", "Colorado", "Connecticut", "Delaware", "District of Columbia", "Florida", "Georgia",
                            "Hawaii", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", "Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", "Nebraska",
                            "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", "North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", "South Dakota",
                            "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", "Wisconsin", "Wyoming"};
                    ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddAddress.this,android.R.layout.simple_spinner_dropdown_item, str9);
                    spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                    s7.setAdapter(spinnerArrayAdapter5);
                    ed8.setVisibility(View.GONE);

                }
                else if(position==8)
                {

                    ed8.setVisibility(View.VISIBLE);
                    ed36.setVisibility(View.VISIBLE);
                    s7.setVisibility(View.GONE);
                    ed8.setFocusable(true);

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                String str10[]={"State"};
                ArrayAdapter<String> spinnerArrayAdapter5 = new ArrayAdapter<String>(AddAddress.this,android.R.layout.simple_spinner_dropdown_item, str10);
                spinnerArrayAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
                s7.setAdapter(spinnerArrayAdapter5);
            }
        });


    }
}
