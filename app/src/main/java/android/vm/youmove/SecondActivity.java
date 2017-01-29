package android.vm.youmove;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class SecondActivity extends Activity {

    private static final String VM_COURSE = "VM Sviluppo";
    TextView nameTV;
    Intent intent;
    String username;
    RecyclerView listRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    ListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        nameTV = (TextView) findViewById(R.id.name_tv);

        intent = getIntent();
        username = intent.getStringExtra(MainActivity.USERNAME_KEY);

        nameTV.setText("Hai selezionato: " + username);

        listRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        adapter = new ListAdapter();

        listRecyclerView.setLayoutManager(layoutManager);
        listRecyclerView.setAdapter(adapter);
        fetchStudents();

        //adapter.setData(new ArrayList<ElementList>());


    }

    private void fetchStudents(){

        ArrayList<ElementList> vmList = new ArrayList<>();

        ElementList e1 = new ElementList();
        e1.setNome("Bottone Valerio");
        e1.setDescrizione(VM_COURSE);

        ElementList e2 = new ElementList();
        e2.setNome("Calderone Luca");
        e2.setDescrizione(VM_COURSE);

        ElementList e3 = new ElementList();
        e3.setNome("Camposeo Francesco");
        e3.setDescrizione(VM_COURSE);

        ElementList e4 = new ElementList();
        e4.setNome("Crispi Danilo");
        e4.setDescrizione(VM_COURSE);

        vmList.add(e1);
        vmList.add(e2);
        vmList.add(e3);
        vmList.add(e4);

        adapter.setData(vmList);
    }


}
