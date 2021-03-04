package com.example.mynotes.ui.notes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.mynotes.R
import com.example.mynotes.adapter.NotesAdapter
import com.example.mynotes.data.viewmodel.NoteViewModel
import com.example.mynotes.databinding.FragmentNotesBinding
import com.example.mynotes.ui.FragmentViewModel



class NotesFragment : Fragment() {
    private val mFragmentViewModel: FragmentViewModel by viewModels()
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
        binding.lifecycleOwner = this
        binding.mFragmentViewModel = mFragmentViewModel
        setupRecyclerView()
        mNoteViewModel.getAllData.observe(viewLifecycleOwner, Observer {
            notesAdapter.setData(it)
        })
        updateNote()
        setHasOptionsMenu(true)
        return binding.root
    }

    private fun updateNote() {

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.notes_fragment_menu,menu)
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