package uz.micro.star.lesson_1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var button: Button
    lateinit var edittext: EditText
    lateinit var text: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button = findViewById(R.id.button)
        edittext = findViewById(R.id.edittext)
        text = findViewById(R.id.text)
//        button.setOnClickListener(object : View.OnClickListener{
//            override fun onClick(p0: View?) {
//  Toast.makeText(this, "Salom KOtlin", Toast.LENGTH_SHORT).show()
//            }
//        })

        button.setOnClickListener {
            val s:String=edittext.text.toString()
            text.text = s
        }
    }
}