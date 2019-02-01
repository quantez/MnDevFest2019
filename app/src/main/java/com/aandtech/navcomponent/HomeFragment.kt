package com.aandtech.navcomponent


import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.NavHostFragment
import com.aandtech.navcomponent.utils.TimeUtils.Companion.formattedDateTime
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        currentTimeText.text = formattedDateTime()

        timeButton.setOnClickListener {
            val capturedTime = currentTimeText.text.toString()
            val action = HomeFragmentDirections.actionHomeFragmentToCapturedTimeFragment(capturedTime)
            NavHostFragment.findNavController(this).navigate(action)
        }
    }

    override fun onResume() {
        super.onResume()
        (activity as MainActivity).showBottomNav(true)
    }

}
