package com.example.assignment3part1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.core.view.get
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.example.assignment3part1.databinding.ActivityMainBinding
import com.example.assignment3part1.ui.main.MainViewModelFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(PreferenceManager.getDefaultSharedPreferences(this))
        ).get(MainViewModel::class.java)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragmentContainerView,
                    MainFragment.newInstance()
                ).commitNow()
        }
        binding.floatingActionButton.setOnClickListener {
            viewModel.saveFact(viewModel.lists.size)
        }
    }

    private fun showCreateListDialog() {
        val dialogTitle = getString(R.string.title)
        val positiveButtonTitle = getString(R.string.add)
        val builder = AlertDialog.Builder(this)
        val listTitleEditTest = EditText(this)
        listTitleEditTest.inputType = InputType.TYPE_CLASS_TEXT
        builder.setTitle(dialogTitle)
        builder.setView(listTitleEditTest)
        builder.setPositiveButton(positiveButtonTitle) { dialog, _ ->
            dialog.dismiss()
            viewModel.saveFact(viewModel.lists.size)
        }
        builder.create().show()
    }


}