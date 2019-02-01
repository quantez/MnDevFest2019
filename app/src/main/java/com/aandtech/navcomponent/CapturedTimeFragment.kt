package com.aandtech.navcomponent


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_captured_time.*

class CapturedTimeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_captured_time, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = CapturedTimeFragmentArgs.fromBundle(arguments ?: throw Exception("we need arguments to continue"))
        currentTimeText.text = args.capturedTime

        (activity as MainActivity).showBottomNav(false)
    }


}
