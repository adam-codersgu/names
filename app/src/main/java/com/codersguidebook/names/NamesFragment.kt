package com.codersguidebook.names

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import com.codersguidebook.names.databinding.FragmentNamesBinding
import com.codersguidebook.recyclerviewfastscroller.RecyclerViewScrollbar

class NamesFragment : Fragment() {

    private var _binding: FragmentNamesBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: NamesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNamesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = NamesAdapter()

        binding.recyclerView.adapter = adapter
        binding.recyclerView.itemAnimator = DefaultItemAnimator()
        binding.scrollbar.recyclerView = binding.recyclerView
        binding.recyclerView.addOnScrollListener(RecyclerViewScrollbar.OnScrollListener(binding.scrollbar))

        val names = resources.getStringArray(R.array.names).toList()
        adapter.names = names
        adapter.notifyItemRangeInserted(0, names.size)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}