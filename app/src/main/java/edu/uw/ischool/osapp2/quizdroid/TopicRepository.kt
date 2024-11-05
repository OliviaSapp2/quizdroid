package edu.uw.ischool.osapp2.quizdroid

import android.graphics.drawable.Icon

interface TopicRepository {
    fun getTopics(): List<Topic>
}

class InMemoryTopicRepository : TopicRepository {
    private val topics = listOf(
        Topic(
            title = "Math",
            shortDescription = "Test your math skills",
            longDescription = "Addition, multiplication, and some other fun surprises!",
            questions = listOf(
                Question("What is 2 + 2?", listOf("3", "4", "5", "6"), 1),
                Question("What is 5 x 5?", listOf("20", "25", "30", "35"), 1),
                Question("What is the square root of 64", listOf("6", "12", "7", "8"), 3),
                Question("what is 5% of 50", listOf("5", "1", "2.5", "10"), 2)
            ),
            icon = R.drawable.calculate_icon
        ),
        Topic(
            title = "Physics",
            shortDescription = "Are you the next Albert Einstein?",
            longDescription = "Test your physics knowledge, based on how little I can remember on the topic myself!",
            questions = listOf(
                Question("What does mc^2 = ?", listOf("E", "velocity", "acceleration", "m^2c"), 0),
                Question("What does acceleration = ?", listOf("change velocity/ change in time", "force / mass", "All of the above", "none of the above"), 2)
            ),
            icon = R.drawable.bolt
        ),
        Topic(
            title = "Marvel Super Heroes",
            shortDescription = "How well do you know Marvel superheroes?",
            longDescription = "Test your knowledge on the MCU marvel superheros, with a few simple questions!",
            questions = listOf(
                Question("Who is Iron Man", listOf("Peter Parker", "Tony Stark", "Happy Hogan", "Stan Lee"), 1),
                Question("Who is the villain in Infinity War", listOf("Thanos", "Dr.Strange", "Green Goblin", "Mysterio"), 0),
                Question("What planet is Thor from", listOf("Earth", "Titan", "Mars", "Asgard"), 3),
            ),
            icon = R.drawable.movie
        )
    )

    override fun getTopics(): List<Topic> = topics
}
//domain objects for Topic and Question
data class Topic(
    val title: String,
    val shortDescription: String,
    val longDescription: String,
    val questions: List<Question>,
    val icon: Int
)

data class Question(
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)
