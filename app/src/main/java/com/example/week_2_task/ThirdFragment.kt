package com.example.week_2_task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


// Fragment Initialization Parameters
private const val ARG_FRAG3_STACK_POSITION = "frag3Position"

class ThirdFragment : Fragment() {

    private var frag3Position: Int? = null

    // Getting the frag3Position upon new Instance creation
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            frag3Position = it.getInt(ARG_FRAG3_STACK_POSITION)
        }
    }

    companion object {
        /**
         * This creates a new instance of the
         * Third fragment using the provided parameters.
         * @param frag3Position Parameter 1.
         * @return A new instance of fragment ThirdFragment.
         */

        // Arguments are stored through bundles and collected upon creation of the new instance
        fun newInstance(frag3Position: Int) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_FRAG3_STACK_POSITION, frag3Position)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_third, container, false)

        // Finds the textView in the fragment and appends the the position in the stack to it
        rootView.findViewById<TextView>(R.id.txtThirdFragPosition).text =
            getString(R.string.third_frag_stack_postion, frag3Position)
        return rootView
    }

}