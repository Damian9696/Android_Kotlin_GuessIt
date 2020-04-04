package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Damian on 29.03.2020 18:46
 */

class GameViewModel : ViewModel() {

    /*
    The current word, nullable MutableLiveData

    Encapsulation, value of word would be modified only in GameViewModel class.
    Access to word in GameFragment must be only in non-mutable version.
    */
    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    /*
    The current score, nullable MutableLiveData

    Encapsulation, value of score would be modified only in GameViewModel class.
    Access to score in GameFragment must be only in non-mutable version.
     */
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    // The list of words - the front of the list is the next word to guess
    private lateinit var wordList: MutableList<String>

    init {
        Log.i("GameViewModel", "GameViewModel created!")
        _eventGameFinish.value = false
        resetList()
        nextWord()
        _score.value = 0
    }

    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
                "queen",
                "hospital",
                "basketball",
                "cat",
                "change",
                "snail",
                "soup",
                "calendar",
                "sad",
                "desk",
                "guitar",
                "home",
                "railway",
                "zebra",
                "jelly",
                "car",
                "crow",
                "trade",
                "bag",
                "roll",
                "bubble"
        )
        wordList.shuffle()
    }

    /**
     * Moves to the next word in the list
     */
    private fun nextWord() {
        //Select and remove a word from the list
        if (wordList.isEmpty()) {
            _eventGameFinish.value = true
        } else {
            _word.value = wordList.removeAt(0)
        }
    }

    /** Methods for buttons presses **/

    fun onSkip() {
        //First creating of live data, value holds null, so must used nullable operator ?.
        _score.value = (score.value)?.minus(1)
        nextWord()
    }

    fun onCorrect() {
        //First creating of live data, value holds null, so must used nullable operator ?.
        _score.value = (score.value)?.plus(1)
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "onCleared destroyed!")

    }

    /**
     * Represent that, event game finish has handled
     */
    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }
}