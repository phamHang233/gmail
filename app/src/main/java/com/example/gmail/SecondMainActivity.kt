package com.example.gmail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondMainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity_main)

        val emailList = listOf(
            EmailItem("John Doe", "Meeting Tomorrow"),
            EmailItem("Alice Smith", "New Project Updates"),
            EmailItem("Bob Johnson", "Vacation Plans"),
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        val adapter = EmailAdapter(emailList)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setOnClickListener{

        }
    }
}

