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
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.simpelindes.R


class HomeFragment : Fragment() {
    private lateinit var shared: SharedPreferences
    private var uid:Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        shared = context!!.getSharedPreferences("com.example.simpelindes", Context.MODE_PRIVATE)
        uid = shared.getInt("UID",-1)
        if(uid == -1) {
            val intent = Intent(context, LoginActivity::class.java)
            startActivity(intent)
        }

        var cardInformation = view.findViewById<CardView>(R.id.cardInformation)
        var cardCreateLetter = view.findViewById<CardView>(R.id.cardCreateLetter)
        var cardSearch = view.findViewById<CardView>(R.id.cardSearch)
        var cardRiwayat = view.findViewById<CardView>(R.id.cardRiwayat)
        var cardStructureOrganization = view.findViewById<CardView>(R.id.cardStructureOrganization)
        var cardAbout = view.findViewById<CardView>(R.id.cardAbout)

        cardInformation.setOnClickListener{
            var action = HomeFragmentDirections.actionInformationFragment()
            Navigation.findNavController(view).navigate(action)
        }

        cardCreateLetter.setOnClickListener{
            var action = HomeFragmentDirections.actionListLetterFragment()
            Navigation.findNavController(view).navigate(action)
        }

        cardSearch.setOnClickListener{
            var action = HomeFragmentDirections.actionSearchFragment()
            Navigation.findNavController(view).navigate(action)
        }
        cardRiwayat.setOnClickListener{
            var action = HomeFragmentDirections.actionHistoryFragment()
            Navigation.findNavController(view).navigate(action)
        }

        cardStructureOrganization.setOnClickListener{
            var action = HomeFragmentDirections.actionStructureOrganizationFragment()
            Navigation.findNavController(view).navigate(action)
        }
        cardAbout.setOnClickListener{
            var action = HomeFragmentDirections.actionAboutFragment()
            Navigation.findNavController(view).navigate(action)
        }


    }

}