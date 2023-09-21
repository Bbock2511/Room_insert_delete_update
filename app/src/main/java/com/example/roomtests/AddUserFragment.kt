package com.example.roomtests

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomtests.database.models.User
import com.example.roomtests.database.viewmodel.UserViewModel
import com.example.roomtests.databinding.FragmentAddUserBinding

class AddUserFragment : Fragment() {

    private var _binding: FragmentAddUserBinding? = null
    private val binding get() = _binding!!

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddUserBinding.inflate(inflater, container, false)

        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.saveButton.setOnClickListener{
            insertUserToDatabase()
        }

        return binding.root
    }

    private fun insertUserToDatabase() {
        val firstName = binding.inputName.text.toString()
        val lastName = binding.inputLastName.text.toString()
        val age = binding.inputAge.text.toString()

        if (inputCheck(firstName, lastName, age)){
            val user = User(0, firstName, lastName, age.toInt())

            mUserViewModel.addUser(user)
            Toast.makeText(context, "Usuário adicionado!", Toast.LENGTH_LONG).show()
            findNavController().navigate(R.id.action_addUserFragment_to_listFragment)
        } else{
            Toast.makeText(context, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: String): Boolean{
        return !(firstName.isEmpty() || lastName.isEmpty() || age.isEmpty())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}