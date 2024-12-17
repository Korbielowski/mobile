package com.example.ex3.views

import androidx.lifecycle.ViewModel
import com.example.ex3.data.Exercise
import com.example.ex3.data.ExerciseList
import com.example.ex3.data.Subject
import kotlin.random.Random

class MainViewModel : ViewModel() {
    var exerciseList_list: List<ExerciseList> = generateExerciseLists()

    fun generateExerciseLists() : MutableList<ExerciseList>{
        val x :MutableMap<String, Int> = mutableMapOf()
        val subjects = listOf("PUM", "Fizyka", "Algorytmy", "Matematyka", "Elektronika")
        val tmp_list : MutableList<ExerciseList> = mutableListOf()
        for(i in 1..20){
            var number = 1
            val subject: String = subjects[Random.nextInt(0, 5)]
            val exercises: MutableList<Exercise> = mutableListOf()
            val grade = 3.0f + Random.nextInt(((5.0f - 3.0f) / 0.5f).toInt() + 1) * 0.5f
            for(j in 1..Random.nextInt(1, 11)){
                val ranscore = Random.nextInt(1, 11)
                exercises.add(Exercise("Przykładowy tekst dla zadania", ranscore))
            }
            if(x.containsKey(subject)){
                number = x.getValue(subject)
            }
            tmp_list.add(ExerciseList(exercises, Subject(subject), grade, number, i))
            x.put(subject, number+1)
        }
        return tmp_list
    }

    fun getList(): List<ExerciseList> {return exerciseList_list}



    fun getSubjectsSummaryList() : List<ExerciseList> {
        val groupedBySubject = exerciseList_list.groupBy { it.subject.name }

        return groupedBySubject.map { (subjectName, lists) ->
            val meanGrade = lists.map { it.grade }.average()
            val listsCount = lists.count()

            ExerciseList().apply {
                subject = Subject(name = subjectName)
                grade = meanGrade.toFloat()
                listNum = listsCount
            }
        }
    }
}