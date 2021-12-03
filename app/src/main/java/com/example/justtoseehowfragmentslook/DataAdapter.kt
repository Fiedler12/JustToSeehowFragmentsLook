package com.example.uxindividualassignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.justtoseehowfragmentslook.R


class DataAdapter(private val dataSet: MutableList<Letter>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = itemView.findViewById(R.id.letter)
        fun bind(letter: String) {
            textView.text = letter
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.game_letter, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        if (dataSet[position].isShown == true) {
            val finalString: String = dataSet[position].letter.toString()
            viewHolder.bind(finalString)
        }
        else {
            val finalString: String = " "
            viewHolder.bind(finalString)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}