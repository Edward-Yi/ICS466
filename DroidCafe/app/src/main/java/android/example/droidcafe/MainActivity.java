package android.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<Prescription> prescriptionList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView homePrescriptionLabel = findViewById(R.id.home_PrescriptionLabel);
        TextView homeDosageLabel = findViewById(R.id.home_DosageLabel);


        Intent intent = getIntent();
        String prescriptionName = intent.getStringExtra(OrderActivity.PRESCRIPTION_NAME);
        TextView textView = findViewById(R.id.prescription_name);
        textView.setText(prescriptionName);

        Intent intent2 = getIntent();
        String dosageNumber = intent2.getStringExtra(OrderActivity.DOSAGE);
        TextView dosageNum = findViewById(R.id.dosage_number);
        dosageNum.setText(dosageNumber);





        if(prescriptionName != null) {
            homePrescriptionLabel.setVisibility(View.VISIBLE);
            homeDosageLabel.setVisibility(View.VISIBLE);
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(MainActivity.this, OrderActivity.class);
                startActivity(intent);
            }

        });
        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new Adapter(this, prescriptionList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


