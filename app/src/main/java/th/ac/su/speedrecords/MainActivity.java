package th.ac.su.speedrecords;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;

import java.util.Locale;

import th.ac.su.speedrecords.model.dataRecord;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayoutManager lm = new LinearLayoutManager(MainActivity.this);

        Addrecord add = new Addrecord();

        // เข้าถึง  RecyclerView ใน layout
        RecyclerView rv = findViewById(R.id.list);
        rv.setLayoutManager(lm); // กำหนด layout manager ให้กับ RecyclerView
        rv.setAdapter(add); // กำหนด adapter ให้กับ RecyclerView

        Button buttonsave = findViewById(R.id.button_save);
        buttonsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textDistance = findViewById(R.id.editTextMeter);
                String distance = textDistance.getText().toString();
                double distanceVar = Double.parseDouble(distance);

                EditText textTime = findViewById(R.id.editTextSecond);
                String time = textTime.getText().toString();
                double timeVar = Double.parseDouble(time);

                double resulf = (distanceVar/1000)/(timeVar/3600);
                String strResulf = String.format(Locale.getDefault(), "%.2f", resulf);
            }
        });
    }

}

class Addrecord extends RecyclerView.Adapter<Addrecord.MyViewHolder> {

    private dataRecord[] data = {
            new dataRecord(" KM/H","METERS,"+" SECONDS")
    };
    Addrecord() {
    }
    @NonNull
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_show_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.wordTextView.setText(data[position].word);
        holder.wordTextView2.setText(data[position].word2);
    }

    public int getItemCount() {
        return data.length;
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView wordTextView;
        TextView wordTextView2;
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            wordTextView = itemView.findViewById(R.id.text_result);
            wordTextView2 = itemView.findViewById(R.id.text_data);
        }
    }
}
