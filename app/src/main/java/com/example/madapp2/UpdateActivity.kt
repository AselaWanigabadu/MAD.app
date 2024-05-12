package com.example.madapp2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madapp2.databinding.ActivityMainBinding
import com.example.madapp2.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateBinding
    private lateinit var db:NoteDataBaseHelper
    private var noteId:Int =-1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db= NoteDataBaseHelper(this)

        noteId=intent.getIntExtra("note_id",-1)
        if(noteId==-1){
            finish()
            return
        }
        val note=db.getNotedByID(noteId)
        binding.updateTitleEditTextt.setText(note.title)
        binding.updateContentEditText.setText(note.content)

        binding.updateSaveButton.setOnClickListener{
            val newTitle=binding.updateTitleEditTextt.text.toString()
            val newContent=binding.updateContentEditText.text.toString()
            val updateNote=Note(noteId,newTitle,newContent)
            db.updateNote(updateNote)
            finish()
            Toast.makeText(this,"Changes Saved !",Toast.LENGTH_SHORT).show()


        }
    }
}