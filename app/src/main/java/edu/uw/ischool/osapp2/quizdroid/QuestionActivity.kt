package edu.uw.ischool.osapp2.quizdroid

import Question
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import topics

class QuestionActivity : AppCompatActivity() {
    private lateinit var questionText: TextView
    private lateinit var optionsGroup: RadioGroup
    private lateinit var submitButton: Button
    private var totalQuestions = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_question)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        questionText = findViewById(R.id.question_text)
        optionsGroup = findViewById(R.id.options_group)
        submitButton = findViewById(R.id.submit_button)

        val topicIndex = intent.getIntExtra("topicIndex", 0)
        val questionIndex = intent.getIntExtra("questionIndex", 0)
        val topic = topics[topicIndex]
        totalQuestions = topic.questions.size

        loadQuestion(topic.questions[questionIndex])

        submitButton.setOnClickListener {
            val selectedOptionIndex = optionsGroup.indexOfChild(findViewById<RadioButton>(optionsGroup.checkedRadioButtonId))
            if (selectedOptionIndex != -1) {
                if(selectedOptionIndex == topic.questions[questionIndex].correctAnswerIndex){
                    QuizScore.correctAnswersCount++
                }
                val intent = Intent(this, AnswerActivity::class.java)
                intent.putExtra("topicIndex", topicIndex)
                intent.putExtra("questionIndex", questionIndex)
                intent.putExtra("selectedOptionIndex", selectedOptionIndex)
                intent.putExtra("correctAnswerIndex", topic.questions[questionIndex].correctAnswerIndex)
                startActivity(intent)
            }
        }

        optionsGroup.setOnCheckedChangeListener { _, _ ->
            submitButton.visibility = View.VISIBLE
        }
    }

    private fun loadQuestion(question: Question) {
        questionText.text = question.questionText
        optionsGroup.removeAllViews()
        question.options.forEachIndexed { index, option ->
            val radioButton = RadioButton(this).apply {
                text = option
                id = View.generateViewId()
            }
            optionsGroup.addView(radioButton)
        }
    }
}