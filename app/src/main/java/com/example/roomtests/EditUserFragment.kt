package com.example.roomtests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.roomtests.database.models.User
import com.example.roomtests.database.viewmodel.UserViewModel
import com.example.roomtests.databinding.FragmentEditUserBinding

class EditUserFragment : Fragment() {

    private val args by navArgs<EditUserFragmentArgs>()

    private var _binding: FragmentEditUserBinding? = null
    private val binding get() = _binding!!

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditUserBinding.inflate(inflater, container, false)

        binding.inputName.setText(args.user.firstName)
        binding.inputLastName.setText(args.user.lastName)
        binding.inputAge.setText(args.user.userAge.toString())

        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.editButton.setOnClickListener {
            updateUser()
        }

        return binding.root
    }

    private fun updateUser() {
        val nameUpdate = binding.inputName.text.toString()
        val lastNameUpdate = binding.inputLastName.text.toString()
        val ageUpdate = binding.inputAge.text.toString()

        val updatedUser = User(args.user.uid, nameUpdate, lastNameUpdate, ageUpdate.toInt())

        mUserViewModel.updateUser(updatedUser)
        Toast.makeText(context, "Usuário editado!", Toast.LENGTH_LONG).show()
        findNavController().navigate(R.id.action_editUserFragment_to_listFragment)
    }

}
