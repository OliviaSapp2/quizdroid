An application that will allow users to take multiple-choice quizzes, now we will write the code to check the questions periodically, store the data, and allow for preferences.

Refactor the TopicRepository to read a local JSON file (data/questions.json) to use as the source of the Topics and Questions.

The application should provide a "Preferences" action bar item that brings up a "Preferences" activity containing the application's configurable settings: URL to use for question data, and how often to check for new downloads measured in minutes. If a download is currently under way, these settings should not take effect until the next download starts.

keep in mind in the next part, you're going to download that JSON file, so make sure that your code to open the file is flexible enough to read from a different location on the device

putting the file into the "assets" folder of the Android Studio project is easy, but can't be overwritten by what's downloaded
