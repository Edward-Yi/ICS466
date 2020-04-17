package android.example.droidcafe;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    private LinkedList<Prescription> prescriptionList;
    private LayoutInflater mInflater;

    public Adapter(Context context,
                   LinkedList<Prescription> list) {
        mInflater = LayoutInflater.from(context);
        this.prescriptionList = list;
    }

    @Override
    public Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.prescription,
                parent, false);
        return new Holder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(Adapter.Holder holder, int position) {
        Prescription mCurrent = prescriptionList.get(position);
        holder.viewItem.setText(mCurrent.title);
        holder.time.setText(mCurrent.timeTo);
        holder.image.setImageResource(mCurrent.image);
        holder.taken.setImageResource(mCurrent.wait);
    }

    @Override
    public int getItemCount() {
        return prescriptionList.size();
    }

    class Holder extends RecyclerView.ViewHolder {
        public final TextView viewItem;
        public final TextView time;
        public final ImageView image;
        public final ImageView taken;
        final Adapter mAdapter;

        public Holder(View itemView, Adapter adapter) {
            super(itemView);
            viewItem = itemView.findViewById(R.id.word);
            time = itemView.findViewById(R.id.time);
            image = itemView.findViewById(R.id.custom);
            taken = itemView.findViewById(R.id.taken);

            this.mAdapter = adapter;
        }
    }
}

