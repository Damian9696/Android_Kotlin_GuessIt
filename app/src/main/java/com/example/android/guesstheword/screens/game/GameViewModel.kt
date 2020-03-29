package com.example.android.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

/**
 * Created by Damian on 29.03.2020 18:46
 */

class GameViewModel : ViewModel(){


    init {
        Log.i("GameViewModel","GameViewModel created!")
    }

    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel","onCleared destroyed!")

    }
}