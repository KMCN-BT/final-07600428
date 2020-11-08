package th.ac.su.speedrecords.model;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import th.ac.su.speedrecords.R;

public class dataRecord extends AppCompatActivity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_show_item);
        }

        public final String word;
        public final String word2;

        public dataRecord(String word, String word2) {
            this.word = word;
            this.word2 = word2;
        }

}

