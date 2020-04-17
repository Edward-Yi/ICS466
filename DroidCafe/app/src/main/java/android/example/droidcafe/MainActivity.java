package android.example.droidcafe;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<Prescription> prescriptionList = new LinkedList<>();
    private RecyclerView mRecyclerView;
    private Adapter mAdapter;
    private RelativeLayout mRelativeLayout;
    private Context mContext;
    private PopupWindow mPopupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mContext = getApplicationContext();
        mRelativeLayout = (RelativeLayout) findViewById(R.id.rl);
        String prescriptionName = getIntent().getStringExtra(OrderActivity.PRESCRIPTION_NAME);
        String dosageNumber = getIntent().getStringExtra(OrderActivity.DOSAGE);
/*
        if (dosageNumber != null && prescriptionName != null) {
            int listSize = prescriptionList.size();
            // Add a item to the list
            prescriptionList.addLast(new Prescription(prescriptionName, dosageNumber));
            // Notify the adapter, that the data has changed.
            mRecyclerView.getAdapter().notifyItemInserted(listSize);
            // Scroll to the bottom.
            mRecyclerView.smoothScrollToPosition(listSize);
        }
*/

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(LAYOUT_INFLATER_SERVICE);

                // Inflate the custom layout/view
                View customView = inflater.inflate(R.layout.popup, null);
                mPopupWindow = new PopupWindow(customView,
                        900,
                        1600);


                // Get a reference for the custom view close button
                ImageButton closeButton = (ImageButton) customView.findViewById(R.id.close);

                // Set a click listener for the popup window close button
                closeButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                });

                ImageButton scan = (ImageButton) customView.findViewById(R.id.camera);

                // Set a click listener for the popup window close button
                scan.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Dismiss the popup window
                        mPopupWindow.dismiss();
                    }
                });


                ImageButton manual = (ImageButton) customView.findViewById(R.id.manual);

                // Set a click listener for the popup window close button
                manual.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                        startActivity(intent);

                        mPopupWindow.dismiss();
                    }
                });

                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER, 0, 0);
            }

        });

        mRecyclerView = findViewById(R.id.recyclerview);
        mAdapter = new Adapter(this, prescriptionList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (dosageNumber != null && prescriptionName != null) {
            int listSize = prescriptionList.size();
            // Add a item to the list
            prescriptionList.addLast(new Prescription(prescriptionName, dosageNumber));
            // Notify the adapter, that the data has changed.
            mRecyclerView.getAdapter().notifyItemInserted(listSize);
            // Scroll to the bottom.
            mRecyclerView.smoothScrollToPosition(listSize);
        }
    }
}


