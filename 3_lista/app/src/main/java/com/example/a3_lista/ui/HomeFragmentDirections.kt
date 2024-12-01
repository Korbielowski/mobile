//package com.example.a3_lista.ui
//
//import android.os.Bundle
//import androidx.navigation.NavDirections
//import com.example.a3_lista.R
//
//class HomeFragmentDirections {
//    companion object {
//        // Function to navigate to ExerciseDetailFragment
//        fun actionHomeFragmentToExerciseDetailFragment(exerciseList: ExerciseList): NavDirections {
//            val bundle = Bundle().apply {
//                // Put the ExerciseList object in the bundle, assuming ExerciseList is Parcelable
//                putParcelable("exerciseList", exerciseList)
//            }
//            return object : NavDirections {
//                override fun getActionId(): Int {
//                    return R.id.action_homeFragment_to_exerciseDetailFragment
//                }
//
//                override fun getArguments(): Bundle {
//                    return bundle
//                }
//            }
//        }
//    }
//}