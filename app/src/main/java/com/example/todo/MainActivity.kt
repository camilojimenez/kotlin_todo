package com.example.todo

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayOf("first").toMutableList()
        items.add("camilo")
        items.add("andres")

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.adapter = ItemAdapter(items)

        val newTaskInput: TextInputEditText = findViewById<TextInputEditText>(R.id.textInputEditText)
        val addBtn = findViewById<Button>(R.id.addBtn)
        addBtn.setOnClickListener{
            items.add(newTaskInput.text.toString())
            recyclerView.adapter = ItemAdapter(items)
            newTaskInput.text.clear()
        }
    }

}