An application that will allow users to take multiple-choice quizzes now we will refactor to use a domain model and an Application object
note that a future version of this codebase will require permissions to be set; this can be done now or later, as you wish.

Tasks
- Create a class called QuizApp extending android.app.Application and make sure it is referenced from the app manifest; override the onCreate() method to emit a message to the diagnostic log to ensure it is being loaded and run

- Use the "Repository" pattern to create a TopicRepository interface; create one implementation that simply stores elements in memory from a hard-coded list initialized on startup.

- Create domain objects for Topic and Question

- a Question is question text, four answers, and an integer saying which of the four answers is correct, a Topic is a title, short description, long description, and a collection of Question objects

- Provide a method or property on QuizApp for accessing the TopicRepository.

- Refactor the activities in the application to use the TopicRepository.

- On the topic list page, the title and the short description should come from the similar fields in the Topic object.

- On the topic overview page, the title and long description should come from the similar fields in the Topic object. The Question object should be similarly easy to match up to the UI.


