package edu.uw.ischool.osapp2.quizdroid

import QuizScore
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import topics

class AnswerActivity : AppCompatActivity() {
    private lateinit var yourAnswer: TextView
    private lateinit var correctAnswer: TextView
    private lateinit var correctCount: TextView
    private lateinit var nextButton: Button
    private lateinit var finishButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_answer)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        yourAnswer = findViewById(R.id.your_answer)
        correctAnswer = findViewById(R.id.correct_answer)
        correctCount = findViewById(R.id.correct_count)
        nextButton = findViewById(R.id.next_button)
        finishButton = findViewById(R.id.finish_button)

        val topicIndex = intent.getIntExtra("topicIndex", 0)
        val questionIndex = intent.getIntExtra("questionIndex", 0)
        val selectedOptionIndex = intent.getIntExtra("selectedOptionIndex", -1)
        val correctAnswerIndex = intent.getIntExtra("correctAnswerIndex", -1)

        val question = topics[topicIndex].questions[questionIndex]
        yourAnswer.text = "Your Answer: ${question.options[selectedOptionIndex]}"
        correctAnswer.text = "Correct Answer: ${question.options[correctAnswerIndex]}"

        correctCount.text = "You have ${QuizScore.correctAnswersCount} out of ${questionIndex + 1} correct"

        if (questionIndex < topics[topicIndex].questions.size - 1) {
            //not the last question
            nextButton.setOnClickListener {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra("topicIndex", topicIndex)
                intent.putExtra("questionIndex", questionIndex + 1)
                startActivity(intent)
            }
        } else {
            //last question answered
            finishButton.visibility = View.VISIBLE
            nextButton.visibility = View.GONE
            finishButton.setOnClickListener {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

                //reset score to 0 for the next quiz
                QuizScore.correctAnswersCount = 0
            }
        }
    }
}

