package uz.micro.star.lesson_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity1 : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var system: TextView
    private lateinit var textUsername: EditText
    private lateinit var inputAge: EditText
    private lateinit var inputPhoneNumber: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        button = findViewById(R.id.button)
        system = findViewById(R.id.system)
        textUsername = findViewById(R.id.username)
        inputAge = findViewById(R.id.age)
        inputPhoneNumber = findViewById(R.id.phoneNumber)

        button.setOnClickListener {
            enterToSystem()
        }

    }

    fun enterToSystem() {
        if (textUsername.text.toString().length >= 3) {
            if (inputAge.text.toString().isNotEmpty() && inputAge.text.toString()
                    .toInt() in 16..100
            ) {
                system.text = "Succesfully"
            }else{
                Toast.makeText(this, "Please enter correct age", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Please enter correct name", Toast.LENGTH_SHORT).show()
        }
    }
}

