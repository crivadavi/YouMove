package android.vm.youmove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.StringBuilderPrinter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Davide on 25/01/2017.
 */

public class MainActivity extends Activity{

    public static final String USERNAME_KEY = "username";

    TextView welcomeTv;
    Button changeButton;
    //EditText changeTextEdit;
    MainActivity activity = this;
    //String username;
    Spinner transportSpinner;
    String itemSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeTv = (TextView) findViewById(R.id.welcome_tv);

        //changeTextEdit = (EditText) findViewById(R.id.change_text_edit);

        transportSpinner = (Spinner) findViewById(R.id.transport_spinner);

        transportSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                itemSelected = (String) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                itemSelected = (String) parent.getItemAtPosition(0);
            }
        });

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.transport_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        transportSpinner.setAdapter(adapter);

        changeButton = (Button) findViewById(R.id.changeButton);

        changeButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //welcomeTv.setText(changeTextEdit.getText());
                //username = changeTextEdit.getText().toString();
                Intent intent = new Intent(activity, SecondActivity.class);
                intent.putExtra(USERNAME_KEY, itemSelected);
                startActivity(intent);
            }
        });



    }



}
