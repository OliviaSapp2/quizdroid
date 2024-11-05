package edu.uw.ischool.osapp2.quizdroid

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var topicListView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        topicListView = findViewById(R.id.topic_list)

        val topics = (application as QuizApp).topicRepository.getTopics()
        val adapter = TopicAdapter(this, topics)
        topicListView.adapter = adapter

        topicListView.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(this, TopicOverviewActivity::class.java)
            intent.putExtra("topicIndex", position)
            startActivity(intent)
        }
    }
}

//made a new version of the ArrayAdapter, to display two things in the list view
class TopicAdapter(private val context: Context, private val topics: List<Topic>) : BaseAdapter() {

    override fun getCount(): Int = topics.size
    override fun getItem(position: Int): Topic = topics[position]
    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false)

        val titleTextView = view.findViewById<TextView>(R.id.title)
        val descriptionTextView = view.findViewById<TextView>(R.id.topic_short_description)
        val iconImageView = view.findViewById<ImageView>(R.id.icon)

        val topic = getItem(position)
        titleTextView.text = topic.title
        descriptionTextView.text = topic.shortDescription
        iconImageView.setImageResource(topic.icon)

        return view
    }
}
