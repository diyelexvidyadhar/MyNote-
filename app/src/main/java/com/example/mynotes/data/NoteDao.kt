package com.example.mynotes.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mynotes.data.models.Note

@Dao
interface NoteDao {
    @Insert
    suspend fun addNote(note: Note)

    @Update
    suspend fun updateNote(note: Note)

    @Delete
    suspend fun deleteNote(note: Note)

    @Query("SELECT * FROM note ORDER BY id DESC")
    fun getAllNotes():LiveData<List<Note>>
}