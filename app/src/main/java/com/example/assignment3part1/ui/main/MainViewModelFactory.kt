package com.example.assignment3part1.ui.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.assignment3part1.MainViewModel

class MainViewModelFactory(private val sharedPreferences: SharedPreferences)
    : ViewModelProvider.Factory
{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(sharedPreferences) as T
    }
}