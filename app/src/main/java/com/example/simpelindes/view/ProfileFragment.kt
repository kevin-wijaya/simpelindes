package com.example.simpelindes.view

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.simpelindes.R

class ProfileFragment : Fragment() {
    private lateinit var shared: SharedPreferences
    private var uid:Int = -1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shared = context!!.getSharedPreferences("com.example.simpelindes", Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = shared.edit()
        uid = shared.getInt("UID",-1)


        var buttonLogout = view.findViewById<Button>(R.id.buttonLogout)

        buttonLogout.setOnClickListener {
            editor.remove("UID")
            editor.apply()
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}