package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

/**
 * Created by Damian on 05.04.2020 16:17
 */
class ScoreViewModel(finalScore: Int) : ViewModel() {

    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    //keeping this type of logic out of xml code
    val currentScoreString: LiveData<String> = Transformations.map(score) {
        it.toString()
    }

    private val _eventPlayAgain = MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain

    init {
        Log.i("ScoreViewModel", "Final score is $finalScore")
        _score.value = finalScore
    }

    fun onPlayAgain() {
        _eventPlayAgain.value = true
    }

    fun eventPlayAgainComplete() {
        _eventPlayAgain.value = false
    }

}