package com.example.myquizallis.domain

import com.google.gson.annotations.SerializedName

data class TriviaCategoriesResponse(


    @SerializedName("trivia_categories")
    val triviaCategories: List<TriviaCategories>
) {
    data class TriviaCategories(
        @SerializedName("id")
        val id: Int,

        @SerializedName("name")
        val name: String,

        @SerializedName("difficulty")
        val difficulty: String,

        @SerializedName("correct_answer")
        val correct_answer: String,

        @SerializedName("incorrect_answers")
        val incorrect_answers: ArrayList<String>,

        @SerializedName("question")
        val question: String,

        @SerializedName("type")
        val type: String,
    ) {

        val incorrectAnswerWithCorrectAnswer: ArrayList<String>
            get() {
                incorrectAnswerWithCorrectAnswer.addAll(incorrect_answers)
                incorrectAnswerWithCorrectAnswer.add(correct_answer)
                incorrectAnswerWithCorrectAnswer.shuffle()
                return incorrectAnswerWithCorrectAnswer
            }
    }
}


