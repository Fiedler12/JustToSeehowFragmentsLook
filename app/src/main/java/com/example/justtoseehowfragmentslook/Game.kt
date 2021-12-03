package com.example.uxindividualassignment2

class Game {
    var gameState: GameState
    var points: Int
    var health: Int
    var gameIsActive: Boolean
    var word: Word
    val wordOptions: MutableList<String> = mutableListOf("FURTHER", "KITCHEN", "AMERICAN", "SATISFACTION", "BEAUTIFUL", "BOUQUET", "DISGUISE", "GENERATION")

    init {
        gameState = GameState.SPIN
        points = 0
        gameIsActive = true
        health = 5
        word = Word(wordOptions[(0..wordOptions.size).random()])
    }
}