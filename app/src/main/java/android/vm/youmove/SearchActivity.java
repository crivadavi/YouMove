package android.vm.youmove;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Davide on 30/01/2017.
 */

public class SearchActivity extends AppCompatActivity{

    //intent ricevuti e inviati
    Intent intentFrom;
    Intent intentSearch;

    //textview desctittiva
    TextView transportTV;

    //inserimento città di partenza e destinazione
    EditText departure;
    EditText destination;

    TextView dateDisplay;
    Button pickDate;
    DatePicker datePicker;
    int year;
    int month;
    int day;

    Button searchButton;

    //prelevamento mezzo di trasporto scelto
    String transport;
    SearchActivity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        ActionBar ab = getSupportActionBar();

        try {
            ab.setDisplayHomeAsUpEnabled(true);
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        transportTV = (TextView) findViewById(R.id.transport_tv);
        departure = (EditText) findViewById(R.id.departure);
        destination = (EditText) findViewById(R.id.destination);

        dateDisplay = (TextView) findViewById(R.id.dateDisplay);
        pickDate = (Button) findViewById(R.id.pickDate);

        searchButton = (Button) findViewById(R.id.search_button);

        intentFrom = getIntent();

        if( intentFrom!= null){

            transport = intentFrom.getStringExtra(MainActivity.TRANSPORT);
            transportTV.setText("Hai selezionato: " + transport);

            pickDate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showDialog(0);
                    datePicker.init(2016,2,1,null);
                }
            });

            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    intentSearch = new Intent(activity, SecondActivity.class);
                    startActivity(intentSearch);
                }
            });

        }
    }


}
