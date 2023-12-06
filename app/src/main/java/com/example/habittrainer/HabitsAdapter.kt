package com.example.habittrainer

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.habittrainer.databinding.SinlgeCardBinding

class HabitsAdapter(val habits:List<Habit>) : RecyclerView.Adapter<HabitsAdapter.HabitViewHolder>() {

    //private lateinit var binding: SinlgeCardBinding

class HabitViewHolder(val card: View): RecyclerView.ViewHolder(card.rootView){
    val titleTextView: TextView
    val descriptionTextView: TextView
    val imageView: ImageView

    init {
        titleTextView = card.findViewById(R.id.title_textView)
        descriptionTextView = card.findViewById(R.id.description_textView)
        imageView = card.findViewById(R.id.icon_imageView)
    }


}

    //create a view holder object
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HabitViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.sinlge_card, parent,false)
        return HabitViewHolder(view)

    }

    override fun getItemCount()=habits.size

    override fun onBindViewHolder(holder: HabitViewHolder, position: Int) {

        holder.apply {
            var habit = habits[position]
            titleTextView.text = habit.title
            descriptionTextView.text = habit.description
            imageView.setImageResource(habit.image)
        }
    }

}