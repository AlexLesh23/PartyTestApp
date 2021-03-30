package com.bsc.msc.testapp.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bsc.msc.testapp.R
import com.bsc.msc.testapp.presentation.adapter.GuestsRecyclerViewAdapter
import com.bsc.msc.testapp.presentation.viewmodel.PartyViewModel

class PartyFragment : Fragment(R.layout.fragment_party) {
    private val partyViewModel: PartyViewModel by activityViewModels()
    private lateinit var guestsAdapter: GuestsRecyclerViewAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val guestsRecyclerView = view.findViewById<RecyclerView>(R.id.guestsRecyclerView)
        guestsAdapter = GuestsRecyclerViewAdapter(emptyList(), requireContext())
        guestsRecyclerView.apply {
            setHasFixedSize(true)
            adapter = guestsAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        loadData()
    }

    private fun loadData() {
        partyViewModel.loadPartyInfo().observe(viewLifecycleOwner, Observer {
            guestsAdapter.modelItems = it
            guestsAdapter.notifyDataSetChanged()
        })
    }
}