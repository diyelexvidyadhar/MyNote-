package com.example.mynotes.ui.notes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mynotes.R
import com.example.mynotes.adapter.NotesAdapter
import com.example.mynotes.data.viewmodel.NoteViewModel
import com.example.mynotes.databinding.FragmentNotesBinding


class NotesFragment : Fragment() {
    private val mNoteViewModel: NoteViewModel by viewModels()
    private val notesAdapter: NotesAdapter by lazy { NotesAdapter() }
    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        setupRecyclerView()
        mNoteViewModel.getAllData.observe(viewLifecycleOwner, Observer {
            notesAdapter.setData(it)
        })
        binding.addNotebutton.setOnClickListener {
            findNavController().navigate(R.id.NotesFragment_to_AddFragment)
        }
        return binding.root
    }

    private fun setupRecyclerView() {
        val recyclerView = binding.notesRecycler
        recyclerView.layoutManager =
            StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.adapter = notesAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}