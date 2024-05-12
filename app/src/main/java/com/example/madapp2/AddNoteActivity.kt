package com.example.madapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madapp2.databinding.ActivityAddNoteBinding

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding
    private lateinit var db:NoteDataBaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= NoteDataBaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title=binding.titleEditTextt.text.toString()
            val content=binding.contentEditText.text.toString()
            val note=Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Booking Saved",Toast.LENGTH_SHORT).show()


        }

    }
}