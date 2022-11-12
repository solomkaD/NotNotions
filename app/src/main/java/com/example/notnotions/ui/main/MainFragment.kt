package com.example.notnotions.ui.main

import android.R
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.notnotions.AppDatabase
import com.example.notnotions.Element
import com.example.notnotions.ElementsDao
import com.example.notnotions.NewElementActivity
import com.example.notnotions.databinding.FragmentMainBinding
import com.example.notnotions.ui.Tools
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
//      val mainViewModel =
//            ViewModelProvider(this).get(MainViewModel::class.java)

      _binding = FragmentMainBinding.inflate(inflater, container, false)
      val root: View = binding.root

      val buttonNewElement: FloatingActionButton = binding.buttonNewElement
      val listElement: ListView = binding.listElement


      val db = Room.databaseBuilder(requireContext(), AppDatabase::class.java, "nn_db")
          .allowMainThreadQueries()
          .build()
      val elementsDao: ElementsDao = db.getElementsDao()


      val list: List<Element> = Tools(elementsDao).getElement()

      val adapter = ArrayAdapter(requireContext(), R.layout.simple_list_item_1, list)
      listElement.adapter = adapter


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