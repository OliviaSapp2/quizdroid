package edu.uw.ischool.osapp2.quizdroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import topics

class TopicOverviewActivity : AppCompatActivity() {
    private lateinit var topicName: TextView
    private lateinit var topicDescription: TextView
    private lateinit var questionCount: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_topic_overview)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        topicName = findViewById(R.id.topic_name)
        topicDescription = findViewById(R.id.topic_description)
        questionCount = findViewById(R.id.question_count)

        val topicIndex = intent.getIntExtra("topicIndex", 0)
        val topic = topics[topicIndex]

        topicName.text = topic.name
        topicDescription.text = topic.description
        questionCount.text = "Total Questions: ${topic.questions.size}"

        findViewById<Button>(R.id.begin_button).setOnClickListener {
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("topicIndex", topicIndex)
            intent.putExtra("questionIndex", 0) // Start from the first question
            startActivity(intent)
        }
    }
}