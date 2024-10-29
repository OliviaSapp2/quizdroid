data class Question(
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)

data class Topic(
    val name: String,
    val description: String,
    val questions: List<Question>
)

val topics = listOf(
    Topic(
        name = "Math",
        description = "Test your math skills with some simple problems!",
        questions = listOf(
            Question("What is 2 + 2?", listOf("3", "4", "5", "6"), 1),
            Question("What is 5 x 5?", listOf("20", "25", "30", "35"), 1),
            Question("What is the square root of 64", listOf("6", "12", "7", "8"), 3)
        )
    ),
    Topic(
        name = "Physics",
        description = "Test your physics knowledge, based on how little I can remember on the topic myself.!",
        questions = listOf(
            Question("What does mc^2 = ?", listOf("E", "velocity", "acceleration", "m^2c"), 0),
            Question("What does acceleration = ?", listOf("change velocity/ change in time", "force / mass", "All of the above", "none of the above"), 2)
    )
    ),
    Topic(
        name = "Marvel Super Heroes",
        description = "How well do you know Marvel superheroes? (MCU)",
        questions = listOf(
            Question("Who is Iron Man", listOf("Peter Parker", "Tony Stark", "Happy Hogan", "Stan Lee"), 1)
        )
    )
)

