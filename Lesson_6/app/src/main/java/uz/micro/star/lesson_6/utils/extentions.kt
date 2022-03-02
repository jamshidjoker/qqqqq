package uz.micro.star.lesson_6.utils

import android.widget.Toast
import uz.micro.star.lesson_6.MainActivity

fun MainActivity.toast(message:String){
    Toast.makeText(this,message,Toast.LENGTH_LONG).show()
}