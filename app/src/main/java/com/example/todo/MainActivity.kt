package com.example.todo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
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

        val onDelete: (Int) -> Unit = { position: Int ->
            Log.d("CAMILO", "here - " + position)
            items.removeAt(position)
        }

        val adapter = ItemAdapter(items, onDelete)
        recyclerView.adapter = adapter



        val newTaskInput: TextInputEditText =
            findViewById<TextInputEditText>(R.id.textInputEditText)
        val addBtn = findViewById<Button>(R.id.addBtn)
        addBtn.setOnClickListener {
            items.add(newTaskInput.text.toString())
            adapter.notifyDataSetChanged()
            newTaskInput.text?.clear()
        }
    }
}