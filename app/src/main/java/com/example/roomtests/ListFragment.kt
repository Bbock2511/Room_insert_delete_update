package com.example.roomtests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomtests.adapter.ListAdapter
import com.example.roomtests.database.viewmodel.UserViewModel
import com.example.roomtests.databinding.FragmentListBinding

class ListFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: FragmentListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        val adapter = ListAdapter(mUserViewModel)
        val recyclerView = binding.recyclerViewUsers
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mUserViewModel.readAllData.observe(viewLifecycleOwner) { user ->
            adapter.setData(user)
        }


        binding.addUserButton.setOnClickListener{
            findNavController().navigate(R.id.action_listFragment_to_addUserFragment)
        }


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}