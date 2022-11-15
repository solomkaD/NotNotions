package com.example.notnotions.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.ListFragment
import com.example.notnotions.R

class ElementListAdapter: ListFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val listValues: ArrayList<String> = ArrayList()
        listValues.add("Android")
        listValues.add("iOS")
        listValues.add("Symbian")
        listValues.add("Blackberry")
        listValues.add("Windows Phone")
        val adapter: ArrayAdapter<String> = ArrayAdapter(requireActivity(), R.layout.fragment_main, R.id.listElements, listValues)
        listAdapter = adapter
    }

}