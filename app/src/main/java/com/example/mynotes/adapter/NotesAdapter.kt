package com.example.mynotes.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mynotes.data.models.Note
import com.example.mynotes.databinding.NotesContainerBinding

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {
    private var notesList = emptyList<Note>()

    class NoteViewHolder(private val binding: NotesContainerBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(note: Note) {
            binding.note = note
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): NoteViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = NotesContainerBinding.inflate(layoutInflater, parent, false)
                return NoteViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentItem = notesList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    fun setData(note: List<Note>) {
        this.notesList = note
        notifyDataSetChanged()
    }
}