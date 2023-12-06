package com.example.habittrainer

data class Habit (val title:String, val description: String, val image:Int)

fun getSampleHabits():List<Habit>{
    return listOf(
        Habit("Go for a walk",
            "A nice walk in the sun get you ready for the day ahead",
            R.drawable.walk),

        Habit("Drink water",
            "A nice cup of water keeps you hydrated",
            R.drawable.water),

    )
}