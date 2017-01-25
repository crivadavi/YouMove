package android.vm.youmove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Davide on 25/01/2017.
 */

public class MainActivity extends Activity{

    public static final String USERNAME_KEY = "username";

    TextView welcomeTv;
    Button changeButton;
    EditText changeTextEdit;
    Activity activity = this;
    String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        welcomeTv = (TextView) findViewById(R.id.welcome_tv);

        changeButton = (Button) findViewById(R.id.changeButton);
        changeTextEdit = (EditText) findViewById(R.id.change_text_edit);
        changeButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //welcomeTv.setText(changeTextEdit.getText());
                username = changeTextEdit.getText().toString();
                Intent intent = new Intent(activity, SecondActivity.class);
                intent.putExtra(USERNAME_KEY, username);
                intent.putExtra("age", 18);
                startActivity(intent);
            }
        });



    }



}
