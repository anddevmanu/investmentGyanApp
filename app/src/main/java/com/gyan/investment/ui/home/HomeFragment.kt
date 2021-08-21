package com.gyan.investment.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gyan.investment.R

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProvider(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val textView: TextView = root.findViewById(R.id.text_home)
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it


            //        1st tab.   FD Calculator
//                2nd tab  RD Calculator
//        3rd tab.  Loan Calculator
//                4 th tab  SIP Calculator
//        5th tab.  PPF Calculator with detail
//                6th tab   detailed EPF Calculator
//                7th tab. Nsc Calculator with detail
        })
        return root
    }
}
