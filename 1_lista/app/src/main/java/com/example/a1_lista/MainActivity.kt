package com.example.a1_lista

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBar.LayoutParams
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    val questions = populate_questions()
    var question_num  = 0
    var correct_answers = 0;

    fun populate_questions(): List<Map<Int, String>> {
        val questions = mutableListOf<Map<Int, String>>()
        questions.add(mapOf(0 to "Ile jest kontynentów?", 1 to "7", 2 to "8", 3 to "10", 4 to "5", 5 to "7"))
        questions.add(mapOf(0 to "Ile jest województw w Polsce?", 1 to "51", 2 to "34", 3 to "22", 4 to "16", 5 to "16"))
        questions.add(mapOf(0 to "Ile ludności mają Niemcy w milionach?", 1 to "40", 2 to "38", 3 to "84", 4 to "10", 5 to "84"))
        questions.add(mapOf(0 to "Kiedy Polska odzyskała niepodległość?", 1 to "1918", 2 to "1945", 3 to "1939", 4 to "1905", 5 to "1918"))
        questions.add(mapOf(0 to "Która planeta jest czwartą od Słońca?", 1 to "Wenus", 2 to "Mars", 3 to "Jowisz", 4 to "Ziemia", 5 to "Mars"))
        questions.add(mapOf(0 to "Jak nazywa się stolica Francji?", 1 to "Londyn", 2 to "Berlin", 3 to "Paryż", 4 to "Madryt", 5 to "Paryż"))
        questions.add(mapOf(0 to "Ile wynosi liczba π (pi) do dwóch miejsc po przecinku?", 1 to "3,12", 2 to "3,16", 3 to "3,14", 4 to "3,18", 5 to "3,14"))
        questions.add(mapOf(0 to "Który kontynent jest największy pod względem powierzchni?", 1 to "Afryka", 2 to "Azja", 3 to "Ameryka Północna", 4 to "Europa", 5 to "Azja"))
        questions.add(mapOf(0 to "Który kraj ma największą liczbę mieszkańców?", 1 to "Chiny", 2 to "Indie", 3 to "USA", 4 to "Rosja", 5 to "Indie"))
        questions.add(mapOf(0 to "Które morze leży na północ od Polski?", 1 to "Morze Bałtyckie", 2 to "Morze Czarne", 3 to "Morze Śródziemne", 4 to "Morze Kaspijskie", 5 to "Morze Bałtyckie"))

        return questions.shuffled()
    }

    fun next_question(view: View?) {
        if(question_num >= 10){
            return
        }
        var questionObj = questions.get(question_num)
        val group: RadioGroup = findViewById(R.id.group)
        val radiobtn_id = group.checkedRadioButtonId

        if (radiobtn_id == -1){
            return
        }

        if(group.findViewById<RadioButton>(radiobtn_id).text == questionObj.get(5)){
            correct_answers += 1
        }
        question_num += 1
        if(question_num >= 10){
            val end = findViewById<LinearLayout>(R.id.endGameOverlay)
            end.visibility = View.VISIBLE
            end.layoutParams.height = LayoutParams.MATCH_PARENT
            val grats = findViewById<TextView>(R.id.congrats)
            grats.visibility = View.VISIBLE
            val stats = findViewById<TextView>(R.id.stats)
            stats.visibility = View.VISIBLE
            stats.text = "Ilość poprawnych odpowiedzi: ".plus(correct_answers.toString())
            return
        }
        group.clearCheck()
        val progress_bar: ProgressBar = findViewById(R.id.progress)
        progress_bar.progress = question_num
        questionObj = questions.get(question_num)
        val which_question: TextView = findViewById(R.id.question_num)
        val question: TextView = findViewById(R.id.question)
        val first: RadioButton = findViewById(R.id.first)
        val second: RadioButton = findViewById(R.id.second)
        val third: RadioButton = findViewById(R.id.third)
        val fourth: RadioButton = findViewById(R.id.fourth)

        question.text = questionObj.get(0)
        first.text = questionObj.get(1)
        second.text = questionObj.get(2)
        third.text = questionObj.get(3)
        fourth.text = questionObj.get(4)
        which_question.text = question_num.plus(1).toString().plus("/10")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val which_question: TextView = findViewById(R.id.question_num)
        val question: TextView = findViewById(R.id.question)
        val first: RadioButton = findViewById(R.id.first)
        val second: RadioButton = findViewById(R.id.second)
        val third: RadioButton = findViewById(R.id.third)
        val fourth: RadioButton = findViewById(R.id.fourth)

        val questionObj = questions.get(question_num)
        question.text = questionObj.get(0)
        first.text = questionObj.get(1)
        second.text = questionObj.get(2)
        third.text = questionObj.get(3)
        fourth.text = questionObj.get(4)
        which_question.text = question_num.plus(1).toString().plus("/10")
    }
}