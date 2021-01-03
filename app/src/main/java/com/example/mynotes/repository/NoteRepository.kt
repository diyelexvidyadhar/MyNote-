package com.example.mynotes.repository

import androidx.lifecycle.LiveData
import com.example.mynotes.data.models.Note
import com.example.mynotes.data.NoteDao

class NoteRepository(private val noteDao: NoteDao) {
    val getAllNotes: LiveData<List<Note>> =noteDao.getAllNotes()

    suspend fun insertNote(note: Note){
        noteDao.addNote(note)
    }
    suspend fun updateNote(note: Note){
        noteDao.updateNote(note)
    }
    suspend fun deleteNote(note: Note){
        noteDao.deleteNote(note)
    }

}