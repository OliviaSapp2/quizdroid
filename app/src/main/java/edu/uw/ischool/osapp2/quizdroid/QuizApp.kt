package edu.uw.ischool.osapp2.quizdroid

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log

class QuizApp : Application() {
    lateinit var topicRepository: TopicRepository

    val TAG = QuizApp:: class.java.canonicalName
    override fun onCreate() {
        super.onCreate()
        topicRepository = InMemoryTopicRepository()
        Log.i(TAG, "application created")
    }

    override fun onTerminate() {
        super.onTerminate()
        Log.i(TAG, "App is down")
    }
}