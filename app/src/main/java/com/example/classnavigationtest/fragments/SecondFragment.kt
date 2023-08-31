package com.example.classnavigationtest.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.classnavigationtest.R

class SecondFragment : Fragment() {

    lateinit var v : View
    lateinit var buttonLogout : Button
    lateinit var textWelcome : TextView

    var data = SecondFragmentArgs.fromBundle(requireArguments()).data
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        v = inflater.inflate(R.layout.fragment_second, container, false)
        textWelcome.text = "Welcome " + data
        buttonLogout = v.findViewById(R.id.buttonLogout)
        return v
    }



    override fun onStart() {
        super.onStart()

        buttonLogout.setOnClickListener(){
            findNavController().navigateUp()
        }
    }

}