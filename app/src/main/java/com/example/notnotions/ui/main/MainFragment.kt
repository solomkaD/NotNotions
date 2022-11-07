package com.example.notnotions.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.notnotions.MainActivity
import com.example.notnotions.NewElementActivity
import com.example.notnotions.databinding.FragmentMainBinding
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
    val mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)

    _binding = FragmentMainBinding.inflate(inflater, container, false)
    val root: View = binding.root

      val buttonNewElement: FloatingActionButton = binding.buttonNewElement

      buttonNewElement?.setOnClickListener{
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