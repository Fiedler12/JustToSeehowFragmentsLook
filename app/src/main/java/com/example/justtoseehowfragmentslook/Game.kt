package com.example.uxindividualassignment2

class Game {
    var gameState: GameState
    var points: Int
    var health: Int
    var gameIsActive: Boolean
    var word: Word

    init {
        gameState = GameState.SPIN
        points = 0
        gameIsActive = true
        health = 5
        word = Word("FURTHER")
    }
}