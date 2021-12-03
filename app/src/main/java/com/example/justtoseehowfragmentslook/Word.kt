package com.example.uxindividualassignment2

class Word(word: String) {
    var charList = mutableListOf<Letter>()
    init {
        for (element in word) run {
            val letter = Letter(element)
            charList.add(letter)
        }
    }

    fun getLetter(index: Int): String {
        return charList[index].letter.toString()
    }
}