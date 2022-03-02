package uz.micro.star.lesson_6

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import uz.micro.star.lesson_6.managers.TestManager
import uz.micro.star.lesson_6.models.QuestionData
import uz.micro.star.lesson_6.utils.toast

class MainActivity : AppCompatActivity() {
    private lateinit var questionTextView: TextView
    private val allVariationsViewGroup by lazy {
        ArrayList<ViewGroup>()
    }
    private var selectedVariationImageView: ImageView? = null
    private lateinit var nextBtn: Button
    private val questionsList by lazy { ArrayList<QuestionData>() }
    lateinit var testManager: TestManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getAllQuestions()
        testManager = TestManager(questionsList)
        loadView()
        loadDataToView()
    }

    private fun loadDataToView() {
        uncheck()
        questionTextView.text = testManager.getQuestion()
        (allVariationsViewGroup[0].getChildAt(1) as TextView).text = testManager.getVariantA()
        allVariationsViewGroup[0].setOnClickListener {
            selectVariation(it)
        }
        (allVariationsViewGroup[1].getChildAt(1) as TextView).text = testManager.getVariantB()
        allVariationsViewGroup[1].setOnClickListener {
            selectVariation(it)
        }
        (allVariationsViewGroup[2].getChildAt(1) as TextView).text = testManager.getVariantC()
        allVariationsViewGroup[2].setOnClickListener {
            selectVariation(it)
        }
        (allVariationsViewGroup[3].getChildAt(1) as TextView).text = testManager.getVariantD()
        allVariationsViewGroup[3].setOnClickListener {
            selectVariation(it)
        }
    }

    fun selectVariation(view: View) {
        val group = view as ViewGroup
        val selectedVariant = group.getChildAt(0) as ImageView
        uncheck()
        selectedVariant.setImageResource(R.drawable.ic_radio_button_checked_black_24dp)
        selectedVariationImageView = selectedVariant
    }

    private fun uncheck() {
        if (selectedVariationImageView != null) {
            selectedVariationImageView?.setImageResource(R.drawable.ic_radio_button_unchecked_black_24dp)
        }
    }

    private fun loadView() {
        questionTextView = findViewById(R.id.question)
        val viewGroup = findViewById<LinearLayout>(R.id.group)
        for (i in 0 until viewGroup.childCount) {
            if (viewGroup.getChildAt(i) is LinearLayout) {
                allVariationsViewGroup.add(viewGroup.getChildAt(i) as LinearLayout)
            }
        }
        nextBtn = findViewById(R.id.nextBtn)
        nextBtn.setOnClickListener {
            next()
        }
    }

    fun getAllQuestions() {
        questionsList.add(
            QuestionData(
                "Poytaxtimiz ?", "Buxoro",
                "Navoiy", "Samarqand", "Toshkent", "Toshkent"
            )
        )
        questionsList.add(
            QuestionData(
                "Eng kichik davlat", "Xitoy",
                "Vatikan", "Russia", "Ukraina", "Vatikan"
            )
        )
        questionsList.add(
            QuestionData(
                "2x2 nechi", "5",
                "1", "4", "53", "4"
            )
        )
        questionsList.add(
            QuestionData(
                "Ummon bu nima", "Guruh",
                "Davlat", "Okean", "Bilmadim", "Bilmadim"
            )
        )
    }

    fun next() {
        if (selectedVariationImageView != null) {
            val viewGroup = selectedVariationImageView!!.parent as LinearLayout
            val textview = viewGroup.getChildAt(1) as TextView
            testManager.checkAnswer(textview.text.toString())
            if (testManager.hasNextQuestion()) {
                loadDataToView()
            } else {
                toast("${testManager.correctAnswerCount} " +
                        "${testManager.wrongAnswerCount} ${testManager.percent}%")
            }
        } else {
            toast("Please choose one of variations ;)")
        }
    }
}