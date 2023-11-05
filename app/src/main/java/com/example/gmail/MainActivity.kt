package com.example.gmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val users: Array<String> = arrayOf("HUST", "CTSV", "Le Ba Vui", "Tuto.com", "support")
        val text_des :Array<String> = arrayOf("Data-0", "Data-1", "Data-2", "Data-3",
            "Data-4")
        val adapter: ArrayAdapter<String> = ArrayAdapter(
            this,
            R.layout.item_view,
            R.id.user_name,
            users
            )
        val listView: ListView = findViewById(R.id.my_list)
        listView.adapter = adapter
//        listView.setOnItemClickListener { adapterView, view, i, l -> txtMsg.text =
//            "Position: $i\nData: ${items[i]}"}

    }
}