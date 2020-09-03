package com.example.madlevel1task2

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.madlevel1task2.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding

    var lblQuestionOne: String = ConjunctionLetters.A.toString();
    var lblQuestionTwo: String = ConjunctionLetters.B.toString();
    var lblQuestionThree: String = ConjunctionLetters.B.toString();
    var lblQuestionFour: String = ConjunctionLetters.B.toString();
    var lblQuestionFive: String = ConjunctionLetters.B.toString();
    var lblQuestionSix: String = ConjunctionLetters.B.toString();
    var lblQuestionSeven: String = ConjunctionLetters.B.toString();
    var lblQuestionEight: String = ConjunctionLetters.B.toString();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateView()
    }

    private enum class ConjunctionLetters {
        A, B
    }

    private fun chooseRandomLetter(): String {
        val listLength = ConjunctionLetters.values().size - 1
        val randomIndex: Int = (0..listLength).random();
        val randomLetter: ConjunctionLetters = ConjunctionLetters.values()[randomIndex];

        return randomLetter.toString();
    }

    private fun updateQuestions() {
        lblQuestionOne = chooseRandomLetter()
        lblQuestionTwo = chooseRandomLetter()
        lblQuestionThree = chooseRandomLetter()
        lblQuestionFour = chooseRandomLetter()
        lblQuestionFive = chooseRandomLetter()
        lblQuestionSix = chooseRandomLetter()
        lblQuestionSeven = chooseRandomLetter()
        lblQuestionEight = chooseRandomLetter()
    }

    private fun updateView() {
        updateQuestions()
        binding.lblQuestionOne.text = getString(R.string.ConjuctionView_question_label_one, lblQuestionOne)
        binding.lblQuestionTwo.text = getString(R.string.ConjuctionView_question_label_two, lblQuestionTwo)
        binding.lblQuestionThree.text = getString(R.string.ConjuctionView_question_label_three, lblQuestionThree)
        binding.lblQuestionFour.text = getString(R.string.ConjuctionView_question_label_four, lblQuestionFour)
        binding.lblQuestionFive.text = getString(R.string.ConjuctionView_question_label_five, lblQuestionFive)
        binding.lblQuestionSix.text = getString(R.string.ConjuctionView_question_label_six, lblQuestionSix)
        binding.lblQuestionSeven.text = getString(R.string.ConjuctionView_question_label_seven, lblQuestionSeven)
        binding.lblQuestionEight.text = getString(R.string.ConjuctionView_question_label_eight, lblQuestionEight)
    }


}