package com.example.week_2_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


// Fragment Initialization Parameters
private const val ARG_FRAG1_STACK_POSITION = "frag1Position"


class FirstFragment : Fragment() {

    private var frag1Position: Int? = null

    // Getting the previous state of the frag1Position upon recreation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            frag1Position = it.getInt(ARG_FRAG1_STACK_POSITION)
        }
    }


    companion object {
        /**
         * This creates a new instance of
         * First fragment using the provided parameters.
         * @param frag1Position Parameter 1.
         * @return A new instance of fragment FirstFragment.
         */

        // Arguments are stored through bundles and collected upon creation of the new instance
        fun newInstance(frag1Position: Int) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_FRAG1_STACK_POSITION, frag1Position)
                }
            }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_first, container, false)

        // Finds the textView in the fragment and appends the the position in the stack to it
        rootView.findViewById<TextView>(R.id.txtFirstFragPosition).text =
            getString(R.string.first_frag_stack_postion, frag1Position)
        return rootView
    }

}