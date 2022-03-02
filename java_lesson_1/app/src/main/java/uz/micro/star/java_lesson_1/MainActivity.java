package uz.micro.star.java_lesson_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button myButton;
    private TextView myTextView;
    private int clickCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myButton = findViewById(R.id.myBtn);
        myTextView = findViewById(R.id.myText);
        myButton.setOnClickListener(view -> {
            clickCount++;
            myTextView.setText("Salom Dunyo: "+clickCount);
        });

    }
}