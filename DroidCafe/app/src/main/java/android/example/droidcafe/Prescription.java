package android.example.droidcafe;

public class Prescription {
     String title;
    String dosage;
    int image;
    int wait;
    String rxNum;
    String date;

    public Prescription(String title, String dosage) {
        this.title = title;
        this. dosage = dosage;
        this.image = R.drawable.medicine;
        this.wait = R.drawable.ic_wait;
        this.rxNum = "";
        this.date = "";
    }
}
