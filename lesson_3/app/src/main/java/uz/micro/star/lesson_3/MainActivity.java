package uz.micro.star.lesson_3;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {
    private Button[][] buttons = new Button[5][5];
    private ArrayList<Integer> numbers;
    private Coordinate object;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadViews();
        loadNumbers();
        shuffleNumbers();
        loadDataToViews();
    }

    private void loadViews() {
        buttons = new Button[4][4];
        ViewGroup group = findViewById(R.id.group);
        for (int i = 0; i < group.getChildCount(); i++) {
            buttons[i / 4][i % 4] = (Button) group.getChildAt(i);
            buttons[i / 4][i % 4].setOnClickListener(this::click);
            buttons[i / 4][i % 4].setTag(new Coordinate(i / 4, i % 4));
        }
    }

    private void loadNumbers() {
        numbers = new ArrayList<>();
        for (int i = 1; i <= 15; i++) {
            numbers.add(i);
        }
    }

    private void shuffleNumbers() {
        Collections.shuffle(numbers);
    }

    @SuppressLint("SetTextI18n")
    private void loadDataToViews() {
        object = new Coordinate(3, 3);
        for (int i = 0; i < 16; i++) {
            buttons[i / 4][i % 4].setText(i < 15 ? numbers.get(i) + "" : "");
            buttons[i / 4][i % 4].setBackgroundResource(i < 15 ? R.drawable.button_background : R.drawable.button_background_empty);
        }
    }

    public void restart(View view) {
        shuffleNumbers();
        loadDataToViews();
    }

    private void click(View view) {
        Button button = (Button) view;
        Coordinate c = (Coordinate) button.getTag();
        int delX = Math.abs(c.getX() - object.getX());
        int delY = Math.abs(c.getY() - object.getY());
        if (delX + delY == 1) {
            Button objectButton = buttons[object.getX()][object.getY()];
            objectButton.setText(button.getText());
            button.setText("");
            objectButton.setBackgroundResource(R.drawable.button_background);
            button.setBackgroundResource(R.drawable.button_background_empty);
            object.update(c);
        }
    }

    public void finish(View view) {
        finish();
    }
}
