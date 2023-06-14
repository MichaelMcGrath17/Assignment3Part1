package com.example.assignment3part1

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import java.lang.Exception

class MainViewModel(private val sharedPreferences: SharedPreferences) : ViewModel() {
    lateinit var onListAdded: (() -> Unit)


    val lists: MutableList<Int> by lazy {
        retrieveLists()
    }
    private fun retrieveLists(): MutableList<Int> {
        val sharedPreferencesContents = sharedPreferences.all
        var maxIndex = 1
        try {
           maxIndex = sharedPreferencesContents.get("max").toString().toInt()
        } catch (e : Exception) {

        }
        val factLists = ArrayList<Int>()

        /**
         * TODO
         * write for loop that will recreate the list of factorials
         */
        for (i in 1..maxIndex + 1) {
            factLists.add(factorial(i))
        }
        return factLists
    }

    fun saveFact(list: Int) {
        sharedPreferences
            .edit().putInt("max", list)
            .apply()
        lists.add(factorial(list + 1))
        onListAdded.invoke()
    }

    fun factorial(fac: Int): Int {
        var factorial: Int = 1
        for (i in 1..fac){
            factorial *= i
        }
        return factorial
    }
}