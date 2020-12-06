package com.zes.jetpackdemo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer

class BlankFragment3 : Fragment() {

    companion object {
        fun newInstance() = BlankFragment3()
    }

    private lateinit var viewModel: BlankViewModel

    private lateinit var tv_name: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_name = view.findViewById(R.id.tv_name)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(BlankViewModel::class.java)
        viewModel.getCurrentName().observe(viewLifecycleOwner, Observer {
//            Log.e("zes", it)
            tv_name.text = it.toString()
        })
    }

}