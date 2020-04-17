package android.example.droidcafe;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

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

                //int listSize = prescriptionList.size();

                // Add a new word to the wordList.
                //prescriptionList.addLast(new Prescription());
                // Notify the adapter, that the data has changed.
                //mRecyclerView.getAdapter().notifyItemInserted(listSize);
                // Scroll to the bottom.
                //mRecyclerView.smoothScrollToPosition(listSize);
                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);
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


