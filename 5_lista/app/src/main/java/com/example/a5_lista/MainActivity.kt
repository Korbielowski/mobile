package com.example.a5_lista

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
//import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlin.random.Random
import com.example.a5_lista.ui.theme._5_listaTheme

data class Exercise(val content: String, val points: Int)
data class Subject(val name: String)
data class ExerciseList(val exercises: List<Exercise>, val subject: Subject, val grade: Double, val number: Int)

val subjects = listOf(
    Subject("Matematyka"),
    Subject("PUM"),
    Subject("Fizyka"),
    Subject("Elektronika"),
    Subject("Algorytmy")
)

fun generateDummyData(): List<ExerciseList> {
    val loremIpsum = listOf(
        "Lorem ipsum dolor sit amet",
        "Consectetur adipiscing elit",
        "Sed do eiusmod tempor incididunt",
        "Ut labore et dolore magna aliqua",
        "Ut enim ad minim veniam",
        "Quis nostrud exercitation ullamco laboris",
        "Nisi ut aliquip ex ea commodo consequat",
        "Duis aute irure dolor in reprehenderit",
        "In voluptate velit esse cillum dolore",
        "Eu fugiat nulla pariatur"
    )

    val subjects_map: MutableMap<Subject, Int> = mutableMapOf(
        Pair(Subject("Matematyka"), 0),
        Pair(Subject("PUM"), 0),
        Pair(Subject("Fizyka"), 0),
        Pair(Subject("Elektronika"), 0),
        Pair(Subject("Algorytmy"), 0)
    )

    return List(20) {
        val exercisesCount = Random.nextInt(1, 11)
        val exercises = List(exercisesCount) {
            Exercise(
                content = loremIpsum.random(),
                points = Random.nextInt(1, 11)
            )
        }
        val subject = subjects.random()
        val grade = Random.nextDouble(3.0, 5.1).let { Math.round(it * 2) / 2.0 }

        val sub = subjects_map[subject]
        var new_sub = 0
        if(sub != null) {
            new_sub = sub.plus(1)
            subjects_map[subject] = new_sub
        }
        ExerciseList(
            exercises = exercises,
            subject = subject,
            grade = grade,
            number = new_sub,
        )
    }
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val exerciseLists = generateDummyData()
        setContent {
            _5_listaTheme {
                TaskGradeApp(exerciseLists)
            }
        }
    }
}

@Composable
fun TaskGradeApp(exerciseLists: List<ExerciseList>) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = "taskList",
            Modifier.padding(paddingValues)
        ) {
            composable("taskList") {
                TaskListScreen(exerciseLists, navController)
            }
            composable("grades") {
                GradesScreen(exerciseLists)
            }
            composable("taskDetails/{listIndex}") { backStackEntry ->
                val listIndex = backStackEntry.arguments?.getString("listIndex")?.toIntOrNull()
                listIndex?.let {
                    TaskDetailsScreen(exerciseLists[it])
                }
            }
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    NavigationBar {
        NavigationBarItem(
            label = { Text("Listy Zadań") },
            selected = navController.currentBackStackEntry?.destination?.route == "taskList",
            onClick = { navController.navigate("taskList") },
            icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = null) }
        )
        NavigationBarItem(
            label = { Text("Oceny") },
            selected = navController.currentBackStackEntry?.destination?.route == "grades",
            onClick = { navController.navigate("grades") },
            icon = { Icon(Icons.Default.Star, contentDescription = null) }
        )
    }
}

@Composable
fun TaskListScreen(exerciseLists: List<ExerciseList>, navController: NavHostController) {
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                "Moje Listy",
                style = MaterialTheme.typography.headlineMedium,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(exerciseLists) { exerciseList ->
                    ListItem(
                        headlineContent = { Text("${exerciseList.subject.name}\t | \tLista ${exerciseList.number}", fontWeight = FontWeight.Bold) },
                        supportingContent = {
                            Text("Ocena: ${exerciseList.grade} | Zadania: ${exerciseList.exercises.size}")
                        },
                        modifier = Modifier
                            .padding(8.dp)
                            .clickable {
                                navController.navigate("taskDetails/${exerciseLists.indexOf(exerciseList)}")
                            }
                    )
                }
            }
        }
}

@Composable
fun GradesScreen(exerciseLists: List<ExerciseList>) {
    val gradesBySubject = exerciseLists
        .groupBy { it.subject.name }
        .mapValues { (_, lists) -> lists.map { it.grade }.average() }
Column (
    modifier = Modifier
    .fillMaxSize()
    .padding(16.dp),
    verticalArrangement = Arrangement.spacedBy(16.dp)){

    Text(
        "Moje Oceny",
        style = MaterialTheme.typography.headlineMedium,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(gradesBySubject.entries.toList()) { (subject, averageGrade) ->
            ListItem(
                headlineContent = { Text(subject, fontWeight = FontWeight.Bold) },
                supportingContent = { Text("Średnia ocena: %.2f".format(averageGrade)) },
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

}

@Composable
fun TaskDetailsScreen(exerciseList: ExerciseList) {
    Column (modifier = Modifier
        .fillMaxSize()
        .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(
            "${exerciseList.subject.name}\nLista ${exerciseList.number}",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )

        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {
            items(exerciseList.exercises) { exercise ->
                Column(modifier = Modifier.padding(8.dp)) {
                    Text("Zadanie: ${exerciseList.exercises.indexOf(exercise) + 1}", fontWeight = FontWeight.Bold)
                    Text(exercise.content)
                    Text("Punkty: ${exercise.points}")
                }
                HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))
            }
        }
    }

}
