package android.vm.youmove;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Davide on 25/01/2017.
 */

public class MainActivity extends AppCompatActivity{

    public static final String TRANSPORT = "mezzoDiTrasporto";

    TextView chooseTv;
    Button buttonBus;
    Button buttonTrain;
    Button buttonPlane;
    MainActivity activity = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        chooseTv = (TextView) findViewById(R.id.choose_tv);

        buttonBus = (Button) findViewById(R.id.ButtonBus);
        buttonBus.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SearchActivity.class);
                intent.putExtra(TRANSPORT, "Bus");
                startActivity(intent);
            }
        });

        buttonTrain = (Button) findViewById(R.id.ButtonTrain);
        buttonTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SearchActivity.class);
                intent.putExtra(TRANSPORT, "Train");
                startActivity(intent);
            }
        });

        buttonPlane = (Button) findViewById(R.id.ButtonPlane);
        buttonPlane.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity, SearchActivity.class);
                intent.putExtra(TRANSPORT, "Plane");
                startActivity(intent);
            }
        });

    }

}
