package com.example.classnavigationtest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.classnavigationtest.R
import com.example.classnavigationtest.entities.User
import com.google.android.material.snackbar.Snackbar


class FirstFragment : Fragment() {

    lateinit var v : View
    lateinit var buttonLogin : Button
    lateinit var username : EditText
    lateinit var password : EditText

    var myUser : User = User("alan", "1234")
    var mySecondUser : User = User("juan", "1234")
    var myThirdUser : User = User("carlos", "4321")

    var userList : MutableList<User> = mutableListOf()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_first, container, false)

        buttonLogin = v.findViewById(R.id.buttonLogin)
        username = v.findViewById(R.id.username)
        password = v.findViewById(R.id.password)

        userList.add(myUser)
        userList.add(mySecondUser)
        userList.add(myThirdUser)

        return v
    }

    override fun onStart() {
        super.onStart()

        buttonLogin.setOnClickListener(){
            var inputName = username.text.toString()
            var inputPass = password.text.toString()

            var found = false
            var i = 0

            while (!found && i < userList.size){
                if(userList[i].name.equals(inputName)){
                    if (userList[i].password.equals(inputPass)){
                        found = true
                        val action = FirstFragmentDirections.actionFirstFragmentToSecondFragment(inputName)
                        findNavController().navigate(action)
                    } else{
                    i++
                    }
                } else{
                    i++
                }
//                Snackbar.make(v, "Usuario o contraseña incorrectos.", Snackbar.LENGTH_SHORT).show()
            }

        }
    }


}