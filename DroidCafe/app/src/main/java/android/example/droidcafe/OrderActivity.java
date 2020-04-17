package android.example.droidcafe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OrderActivity extends AppCompatActivity {

    public static final String PRESCRIPTION_NAME = "com.example.android.droidcafe.extra.MESSAGE";
    public static final String DOSAGE = "com.example.android.droidcafe.extra.MESSAGE";
    private EditText mPrescriptionText;
    private EditText mDosageText;
    private EditText mRXNumber;
    private EditText mDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setTitle("Add a prescription");
        mPrescriptionText = findViewById(R.id.prescription_text);

        mDosageText = findViewById(R.id.dosage_text);

        mRXNumber = findViewById(R.id.rx_text);

        mDate = findViewById(R.id.date_text);

    }

    public void launchMainActivity(View view) {
        //Get the text inputs
        String prescriptionText = mPrescriptionText.getText().toString();
        String dosageText = mDosageText.getText().toString();
        String rxNumber = mRXNumber.getText().toString();
        String date = mDate.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(PRESCRIPTION_NAME, prescriptionText);

        Intent intent2 = new Intent(this, MainActivity.class);
        String message2 = mDosageText.getText().toString();
        intent2.putExtra(DOSAGE, message2);

        // Testing for blank fields
        if(prescriptionText.isEmpty()) {
            displayToast("Please enter the prescription name");
        }
        else if(dosageText.isEmpty()) {
            displayToast("Please enter the dosage number");
        }
        else if(rxNumber.isEmpty()) {
            displayToast("Please enter the RX number");
        }
        else if(date.isEmpty()) {
            displayToast("Please enter the date received");
        }
        else {
            startActivity(intent);
        }
    }

    /**
     * DisplayToast method used to display a toast
     * @param message The message to be displayed in the toast. 
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
}
