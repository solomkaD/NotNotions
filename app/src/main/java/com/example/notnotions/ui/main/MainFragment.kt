package com.example.notnotions.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.notnotions.*
import com.example.notnotions.databinding.FragmentMainBinding
import com.example.notnotions.Tools
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainFragment : Fragment() {

private var _binding: FragmentMainBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
      _binding = FragmentMainBinding.inflate(inflater, container, false)
      val root: View = binding.root

      val db = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "nn_db")
          .allowMainThreadQueries()
          .build()
      val elementsDao: ElementsDao = db.getElementsDao()
      val list: List<String> = Tools(elementsDao).getElement()

      val listElement: ListView = binding.listElements

      val adapter: ArrayAdapter<String> = ArrayAdapter(requireContext(), R.layout.row_element_layout, R.id.listText, list)
      listElement.adapter=adapter

      listElement.setOnItemClickListener { parent, _, position, _ ->
          val selectedItem: String = parent.getItemAtPosition(position).toString()
          //val element: Element = Tools(elementsDao).getElementByLabel(selectedItem)
          val intent = Intent(activity, NewElementActivity::class.java).apply {
              putExtra("element", selectedItem)
          }
//          Toast.makeText(requireContext(), selectedItem, Toast.LENGTH_LONG).show()
      }


      val buttonNewElement: FloatingActionButton = binding.buttonNewElement
      buttonNewElement.setOnClickListener{
          val intent = Intent(activity, NewElementActivity::class.java)
          startActivity(intent)
      }

      return root
  }

  override fun onDestroyView() {
      super.onDestroyView()
      _binding = null
  }
}