package com.example.madlevel1task2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.madlevel1task2.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding

    var lblQuestionOne: String = ConjunctionLetters.T.toString();
    var lblQuestionTwo: String = ConjunctionLetters.F.toString();
    var lblQuestionThree: String = ConjunctionLetters.F.toString();
    var lblQuestionFour: String = ConjunctionLetters.F.toString();
    var lblQuestionFive: String = ConjunctionLetters.F.toString();
    var lblQuestionSix: String = ConjunctionLetters.F.toString();
    var lblQuestionSeven: String = ConjunctionLetters.F.toString();
    var lblQuestionEight: String = ConjunctionLetters.F.toString();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateView()
    }

    private enum class ConjunctionLetters {
        T, F
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
        binding.lblQuestionOne.text = getString(R.string.ConjunctionView_question_label_one, lblQuestionOne)
        binding.lblQuestionTwo.text = getString(R.string.ConjunctionView_question_label_two, lblQuestionTwo)
        binding.lblQuestionThree.text = getString(R.string.ConjunctionView_question_label_three, lblQuestionThree)
        binding.lblQuestionFour.text = getString(R.string.ConjunctionView_question_label_four, lblQuestionFour)
        binding.lblQuestionFive.text = getString(R.string.ConjunctionView_question_label_five, lblQuestionFive)
        binding.lblQuestionSix.text = getString(R.string.ConjunctionView_question_label_six, lblQuestionSix)
        binding.lblQuestionSeven.text = getString(R.string.ConjunctionView_question_label_seven, lblQuestionSeven)
        binding.lblQuestionEight.text = getString(R.string.ConjunctionView_question_label_eight, lblQuestionEight)
    }

    private fun onAnswerCorrect(){
        Toast.makeText(this,getString(R.string.ConjunctionView_answer_correct), Toast.LENGTH_SHORT).show()
    }

    private fun onAnswerInCorrect(){
        Toast.makeText(this,getString(R.string.ConjunctionView_answer_incorrect), Toast.LENGTH_SHORT).show()
    }
}