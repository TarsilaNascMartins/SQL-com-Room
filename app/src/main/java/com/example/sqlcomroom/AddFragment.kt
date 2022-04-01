package com.example.sqlcomroom

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.sqlcomroom.databinding.FragmentAddBinding
import com.example.sqlcomroom.model.User
import com.example.sqlcomroom.model.UserViewModel

class AddFragment : Fragment() {

    private lateinit var binding: FragmentAddBinding
    private lateinit var mainViewModel : UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        mainViewModel = UserViewModel(context)

        // Inflate the layout for this fragment
        binding = FragmentAddBinding.inflate(
            layoutInflater, container, false
        )

        binding.buttonCadastrar.setOnClickListener(){

            inserirBanco()
        }

        return binding.root
    }

    fun validar(nome: String, sobrenome: String, idade: String):Boolean{
        return !(nome.isEmpty() || sobrenome.isEmpty() ||idade.isEmpty() )
    }

    fun inserirBanco(){

        val nome = binding.editNome.text.toString()
        val sobrenome = binding.editNome.text.toString()
        val idade = binding.editTextNumber.text.toString()

        if (validar(nome, sobrenome,idade)) {
            val user = User (0, nome, sobrenome, idade.toInt())
            mainViewModel.addUser(user)
            Toast.makeText(context, "Usuário Cadastrado", Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
    }

}


