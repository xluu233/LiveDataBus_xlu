package com.xlu.livedatabus.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.xlu.livedatabus.R
import com.xlu.livedatabus.bus.LiveDataBus
import com.xlu.livedatabus.databinding.FragmentOneBinding
import com.xlu.livedatabus.databinding.FragmentTwoBinding
import com.xlu.livedatabus.util.viewBinding


const val  LiveTag2 = "TwoFragment"

class TwoFragment : Fragment(R.layout.fragment_two) {
    private val binding by viewBinding(FragmentTwoBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        LiveDataBus.with<String>(LiveTag).observe(viewLifecycleOwner, Observer {
            binding.textView2.text = it
        })


        initClick()
    }

    private fun initClick() {
        binding.button3.setOnClickListener {
            LiveDataBus.with<String>(LiveTag2).postData("this is two fragment")
            findNavController().navigateUp()
        }
    }
}