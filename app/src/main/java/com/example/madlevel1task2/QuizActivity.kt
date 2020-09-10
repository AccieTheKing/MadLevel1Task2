package com.example.madlevel1task2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.madlevel1task2.databinding.ActivityQuizBinding

class QuizActivity : AppCompatActivity() {
    private lateinit var binding: ActivityQuizBinding
    var questionArray: ArrayList<String> = arrayListOf()
    var txtFieldOne = "";
    var txtFieldTwo = ""
    var txtFieldThree = ""
    var txtFieldFour = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        updateView()

        binding.btnSubmit.setOnClickListener {
            checkInputFields()
        }
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

    private fun updateView() {
        questionArray.clear()
        for (i in 0..8) questionArray.add(chooseRandomLetter()) // new questions
        // set questions in the correct label
        for (i in 0 until questionArray.size) matchInputs(i, questionArray[i])
        binding.txtFieldAnswerOne.text.clear()
        binding.txtFieldAnswerTwo.text.clear()
        binding.txtFieldAnswerThree.text.clear()
        binding.txtFieldAnswerFour.text.clear()
    }

    private fun checkInputFields() {
        var correct = true
        txtFieldOne = binding.txtFieldAnswerOne.text.toString()
        txtFieldTwo = binding.txtFieldAnswerTwo.text.toString()
        txtFieldThree = binding.txtFieldAnswerThree.text.toString()
        txtFieldFour = binding.txtFieldAnswerFour.text.toString()

        for (i in 0 until questionArray.size) {
            if (i < 2) {
                correct = checkCorrectAnswers(questionArray[i], questionArray[i + 1], txtFieldOne)
            } else if (i in 2..3) {
                correct = checkCorrectAnswers(questionArray[i], questionArray[i + 1], txtFieldTwo)
            } else if (i in 4..5) {
                correct = checkCorrectAnswers(questionArray[i], questionArray[i + 1], txtFieldThree)
            } else if (i in 6..7) {
                correct = checkCorrectAnswers(questionArray[i], questionArray[i + 1], txtFieldFour)
            }
        }

        if (correct) onAnswerCorrect()
        else onAnswerInCorrect()

        updateView()
    }


    /**
     * This method will map the question value to the correct label
     */
    private fun matchInputs(index: Int, value: String) {
        when (index) {
            0 -> binding.lblQuestionOne.text = value
            1 -> binding.lblQuestionTwo.text = value
            2 -> binding.lblQuestionThree.text = value
            3 -> binding.lblQuestionFour.text = value
            4 -> binding.lblQuestionFive.text = value
            5 -> binding.lblQuestionSix.text = value
            6 -> binding.lblQuestionSeven.text = value
            else -> {
                binding.lblQuestionEight.text = value
            }
        }
    }

    /**
     * This method will check if the given values are correct
     */
    private fun checkCorrectAnswers(
        valueOne: String,
        valueTwo: String,
        userAnswer: String
    ): Boolean {
        if (valueOne == ConjunctionLetters.T.toString() &&
            valueTwo == ConjunctionLetters.T.toString() &&
            userAnswer == ConjunctionLetters.T.toString() ||
            valueOne == ConjunctionLetters.T.toString() &&
            valueTwo == ConjunctionLetters.F.toString() &&
            userAnswer == ConjunctionLetters.F.toString() ||
            valueOne == ConjunctionLetters.F.toString() &&
            valueTwo == ConjunctionLetters.T.toString() &&
            userAnswer == ConjunctionLetters.F.toString() ||
            valueOne == ConjunctionLetters.F.toString() &&
            valueTwo == ConjunctionLetters.F.toString() &&
            userAnswer == ConjunctionLetters.F.toString()
        ) return true
        return false
    }


    private fun onAnswerCorrect() {
        Toast.makeText(this, getString(R.string.ConjunctionView_answer_correct), Toast.LENGTH_SHORT)
            .show()
        updateView()
    }

    private fun onAnswerInCorrect() {
        Toast.makeText(
            this,
            getString(R.string.ConjunctionView_answer_incorrect),
            Toast.LENGTH_SHORT
        ).show()
    }
}