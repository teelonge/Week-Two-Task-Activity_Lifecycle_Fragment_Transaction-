package com.example.week_2_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


// Fragment Initialization Parameter
private const val ARG_FRAG2_STACK_POSITION = "frag2Position"


class SecondFragment : Fragment() {

    private var frag2Position: Int? = null

    // Getting the previous state of the frag2Position upon recreation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            frag2Position = it.getInt(ARG_FRAG2_STACK_POSITION)
        }
    }


    companion object {
        /**
         * This creates a new instance of
         * Second fragment using the provided parameters.
         * @param frag2Position Parameter 1.
         * @return A new instance of fragment SecondFragment.
         */

        // Arguments are stored through bundles and collected upon creation of the new instance
        fun newInstance(frag2Position: Int) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_FRAG2_STACK_POSITION, frag2Position)
                }
            }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_second, container, false)

        // Finds the textView in the fragment and appends the the position in the stack to it
        rootView.findViewById<TextView>(R.id.txtSecondFragPosition).text =
            getString(R.string.second_frag_stack_postion, frag2Position)
        return rootView
    }

}