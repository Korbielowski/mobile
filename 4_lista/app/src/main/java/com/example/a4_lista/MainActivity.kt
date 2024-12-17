package com.example.quizapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.a4_lista.ui.theme._4_listaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _4_listaTheme {
                QuizApp()
            }
        }
    }
}

data class Question(
    val text: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

val questions = listOf(
    Question(
        text = "Jaką właściwość ciała określa stosunek masy do objętości?",
        options = listOf("Prędkość", "Energia kinetyczna", "Gęstość", "Temperatura"),
        correctAnswerIndex = 2
    ),
    Question(
        text = "Co to jest H2O?",
        options = listOf("Woda", "Tlen", "Wodór", "Hel"),
        correctAnswerIndex = 0
    ),
    Question(
        text = "Która planeta jest najbliżej Słońca?",
        options = listOf("Ziemia", "Wenus", "Mars", "Merkury"),
        correctAnswerIndex = 3
    ),
    Question(
        text = "Jak nazywa się najmniejsza cząstka pierwiastka chemicznego?",
        options = listOf("Atom", "Molekuła", "Jądro", "Elektron"),
        correctAnswerIndex = 0
    ),
    Question(
        text = "Ile nóg ma pająk?",
        options = listOf("6", "8", "10", "12"),
        correctAnswerIndex = 1
    ),
    Question(
        text = "Który pierwiastek ma symbol O?",
        options = listOf("Wodór", "Tlen", "Azot", "Hel"),
        correctAnswerIndex = 1
    ),
    Question(
        text = "Ile godzin ma jedna doba?",
        options = listOf("12", "24", "48", "36"),
        correctAnswerIndex = 1
    ),
    Question(
        text = "Jak nazywa się najdłuższa rzeka świata?",
        options = listOf("Nil", "Amazonka", "Jangcy", "Missisipi"),
        correctAnswerIndex = 1
    ),
    Question(
        text = "Który kraj ma największą powierzchnię?",
        options = listOf("Rosja", "Kanada", "Chiny", "USA"),
        correctAnswerIndex = 0
    ),
    Question(
        text = "Co oznacza skrót WWW?",
        options = listOf("World Wide Web", "Wireless Web Wide", "Web World Wide", "Wide World Web"),
        correctAnswerIndex = 0
    )
)

@Composable
fun QuizApp() {
    var currentQuestionIndex by remember { mutableIntStateOf(0) }
    var score by remember { mutableIntStateOf(0) }`
    var showResult by remember { mutableStateOf(false) }

    if (showResult) {
        ResultScreen(score, questions.size) {
            currentQuestionIndex = 0
            score = 0
            showResult = false
        }
    } else {
        QuestionScreen(
            question = questions[currentQuestionIndex],
            currentQuestionIndex = currentQuestionIndex,
            totalQuestions = questions.size,
            onAnswerSelected = { isCorrect ->
                if (isCorrect) {
                    score++
                }
                if (currentQuestionIndex < questions.size - 1) {
                    currentQuestionIndex++
                } else {
                    showResult = true
                }
            }
        )
    }
}

@Composable
fun QuestionScreen(
    question: Question,
    currentQuestionIndex: Int,
    totalQuestions: Int,
    onAnswerSelected: (Boolean) -> Unit
) {
    Scaffold(
        topBar = {
                Text(
                    "Pytanie ${currentQuestionIndex + 1}/$totalQuestions",
                    style = MaterialTheme.typography.headlineLarge,
                    modifier = Modifier.fillMaxWidth().padding(20.dp),
                    textAlign = TextAlign.Center
                )
        },
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                LinearProgressIndicator(
                    progress = { (currentQuestionIndex + 1).toFloat() / totalQuestions },
                    modifier = Modifier.fillMaxWidth(),
                )

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = question.text,
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
                question.options.forEachIndexed { index, option ->
                    Button(
                        onClick = { onAnswerSelected(index == question.correctAnswerIndex) },
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(option)
                    }
                }
            }
        }
    )
}

@Composable
fun ResultScreen(score: Int, totalQuestions: Int, onRestart: () -> Unit) {
    Scaffold(
        content = { padding ->
            Column(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Gratulacje Użytkowniku",
                    style= MaterialTheme.typography.headlineLarge,
                    textAlign = TextAlign.Center,
                    color = Color.Green
                )
                Spacer(modifier = Modifier.height(100.dp))
                Text(
                    text = "Twój wynik: $score z $totalQuestions",
                    style = MaterialTheme.typography.headlineSmall,
                    textAlign = TextAlign.Center
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(onClick = onRestart) {
                    Text("Zagraj ponownie")
                }
            }
        }
    )
}
