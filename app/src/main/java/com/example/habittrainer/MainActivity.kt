package com.example.habittrainer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Intents
import android.view.Menu
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.habittrainer.databinding.ActivityCreateHabitBinding
import com.example.habittrainer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setupUi()
        setContentView(binding.root)
    }

    private fun setupUi() {

        //add description to the description text view
        //binding.descriptionTextView.text = "A refreshing glass of water gets you hydrated."

        //add title to the title text view
        //binding.titleTextView.text = "Drink water"

        //add image res to the image view
        //binding.iconImageView.setImageResource(R.drawable.water)

        //
        with(binding.mainRecyclerView) {
            //
            setHasFixedSize(true)
            //LayoutManager
            layoutManager = LinearLayoutManager(this@MainActivity)

            //initialise the adapter
            adapter = HabitsAdapter(getSampleHabits())
        }

        //move to add habit activity when action bar is selected
        binding.addhabitFloatingActionBar.setOnClickListener {
            val intent = Intent(this, createHabitActivity::class.java)
            startActivity(intent)
        }
    }
}