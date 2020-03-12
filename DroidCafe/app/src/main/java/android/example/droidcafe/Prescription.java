package android.example.droidcafe;

public class Prescription {
     String title;
    int dose;
    String dosage;
    String type;
    int time;
    String amount;
    String timeTo;
    int image;

    public Prescription() {
        this.title = "Prescription";
        this.dose = 1;
        this.type = "pill";
        this.dosage = dose + type;
        this.time = 1;
        this.amount = "Hour";
        this.timeTo = time + amount;
        this.image = R.drawable.medicine;
    }
}
