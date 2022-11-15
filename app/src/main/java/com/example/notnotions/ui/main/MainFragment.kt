package com.example.notnotions.ui.main

import android.app.ListActivity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListPopupWindow
import android.widget.ListView
import androidx.fragment.app.Fragment
import androidx.fragment.app.ListFragment
import androidx.room.Room
import com.example.notnotions.*
import com.example.notnotions.databinding.FragmentMainBinding
import com.example.notnotions.ui.Tools
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.NonDisposableHandle.parent


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

      val listValues = ArrayList<String>()
      listValues.add("Android")
      listValues.add("iOS")
      listValues.add("Symbian")
      listValues.add("Blackberry")
      listValues.add("Windows Phone")

      val adapter: ArrayAdapter<String> = ArrayAdapter(requireContext(), R.layout.row_element_layout, R.id.listText, listValues)
      listElement.adapter=adapter

      listElement.setOnItemClickListener { parent, view, position, id ->
        if (position==0){
            val intent = Intent(activity, NewElementActivity::class.java)
            startActivity(intent)
        }
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