package com.example.justtoseehowfragmentslook

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.justtoseehowfragmentslook.databinding.FragmentFirstBinding
import com.example.uxindividualassignment2.App
import com.example.uxindividualassignment2.DataAdapter
import com.example.uxindividualassignment2.GameState

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {
    val app = App()
    var pointsForGuess = 0
    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val submitBtn = getView()?.findViewById(R.id.submit_guess) as Button
        val editGuess = getView()?.findViewById(R.id.enter_guess) as EditText
        submitBtn.setOnClickListener {
            if (app.game.gameState == GameState.GUESS) {
                app.game.gameState = GameState.SPIN
                val guess = editGuess.text.toString()
                testGuess(guess)
                editGuess.text.clear()
            }
        }
        val spinBtn = getView()?.findViewById(R.id.spin) as Button
        spinBtn.setOnClickListener {
            if (app.game.gameState == GameState.SPIN) {
                spin()
            }
        }
        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.recycler_word) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val dataSet = app.game.word.charList
        recyclerView.adapter = DataAdapter(dataSet)
    }

    private fun spin() {
        val random = (1..10).random()
        val statusMessage = getView()?.findViewById(R.id.status_message) as TextView
        val health = getView()?.findViewById(R.id.health) as TextView
        when(random){
            1 -> {
                pointsForGuess = 100
                app.game.gameState = GameState.GUESS
                statusMessage.text = "You will get 100 points for a correct consonant! Please guess."
            }
            2 -> {
                pointsForGuess = 200
                app.game.gameState = GameState.GUESS
                statusMessage.text = "You will get 200 points for a correct consonant! Please guess."            }
            3 -> {
                pointsForGuess = 400
                app.game.gameState = GameState.GUESS
                statusMessage.text = "You will get 400 points for a correct consonant! Please guess."
            }
            4 -> {
                pointsForGuess = 800
                app.game.gameState = GameState.GUESS
                statusMessage.text = "You will get 800 points for a correct consonant! Please guess."
            }
            5 -> {
                pointsForGuess = 1600
                app.game.gameState = GameState.GUESS
                statusMessage.text = "You will get 1600 points for a correct consonant! Please guess."
            }
            6 -> {
                pointsForGuess = 2000
                app.game.gameState = GameState.GUESS
                statusMessage.text = "You will get 2000 points for a correct consonant! Please guess."
            }
            7 -> {
                pointsForGuess = 2500
                app.game.gameState = GameState.GUESS
                statusMessage.text = "You will get 2500 points for a correct consonant! Please guess."
            }
            8 -> {
                pointsForGuess = 3000
                app.game.gameState = GameState.GUESS
                statusMessage.text = "You will get 3000 points for a correct consonant! Please guess."
            }
            9 -> {
                statusMessage.text = "You get an ekstra life!"
                app.game.health++
                health.text = app.game.health.toString()
            }
            10 -> {
                statusMessage.text = "You lose a life.."
                app.game.health--
                health.text = app.game.health.toString()
            }
        }
    }

    fun testGuess(guess: String) {
        val health = getView()?.findViewById(R.id.health) as TextView
        val points = getView()?.findViewById(R.id.points) as TextView
        val guessChar = guess[0].uppercaseChar()
        val gameWord = app.game.word.charList
        var correctCounter = 0
        for(i in 0..gameWord.size-1) {
            if (guessChar.equals(gameWord[i].letter)) {
                gameWord[i].isShown = true
                correctCounter++
            }
        }
        if (correctCounter > 0) {
            app.game.points = app.game.points + pointsForGuess * correctCounter
            points.text = app.game.points.toString()
            giveMessage(guessChar.toString() + " is in the word.")
        } else {
            app.game.health--
            health.text = app.game.health.toString()
            giveMessage(guessChar.toString() + " is not in this word. You lose one HP.")
        }
        update()
    }

    fun update() {
        val recyclerView = getView()?.findViewById<RecyclerView>(R.id.recycler_word) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val dataSet = app.game.word.charList
        recyclerView.adapter = DataAdapter(dataSet)
    }


    fun giveMessage(message: String) {
            val statusMessage = getView()?.findViewById(R.id.status_message) as TextView
            statusMessage.text = message
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}