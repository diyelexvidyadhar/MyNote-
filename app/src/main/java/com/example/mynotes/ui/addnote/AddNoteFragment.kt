package com.example.mynotes.ui.addnote

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.mynotes.R
import com.example.mynotes.data.models.Note
import com.example.mynotes.data.viewmodel.NoteViewModel
import com.example.mynotes.databinding.FragmentAddNoteBinding
import com.example.mynotes.ui.FragmentViewModel


class AddNoteFragment : Fragment() {
    private val mFragmentViewModel: FragmentViewModel by viewModels()
    private val mNoteViewModel: NoteViewModel by viewModels()
    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val _binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        binding = _binding
        setHasOptionsMenu(true)

        binding.textDate.setText(mFragmentViewModel.dateTime())
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_add)
            insertDataToDb()
        return super.onOptionsItemSelected(item)
    }

    private fun insertDataToDb() {
        val mtitle = binding.title.text.toString()
        val mSubtitle = binding.subtitle.text.toString()
        val mDescription = binding.description.text.toString()
        val mDateTime = binding.textDate.text.toString()
        val mImagePath = "image"
        val mWebUrl = "google"
        val mColor = "color"
        val newNote = Note(
            0,
            mtitle,
            mSubtitle,
            mDescription,
            mDateTime,
            mImagePath,
            mWebUrl,
            mColor
        )
        mNoteViewModel.addNote(newNote)
        Toast.makeText(context, "Note saved successfully", Toast.LENGTH_SHORT).show()
    }

}