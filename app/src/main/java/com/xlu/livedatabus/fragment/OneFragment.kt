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
import com.xlu.livedatabus.util.viewBinding


const val  LiveTag = "OneFragment"

class OneFragment : Fragment(R.layout.fragment_one) {

    private val binding by viewBinding(FragmentOneBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        LiveDataBus.with<String>(LiveTag2).observe(viewLifecycleOwner, Observer {
            binding.textView.text = it
        })

        initClick()
    }

    private fun initClick() {
        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_oneFragment_to_twoFragment)
        }

        binding.button.setOnClickListener {
            LiveDataBus.with<String>(LiveTag).postData("从OneFragment发送的消息")
        }
    }
}