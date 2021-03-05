package com.example.week_2_task

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text
import kotlin.random.Random

/**
 * Activity for the second implementation that adds three fragments randomly to
 * the backstack using a button and pops them from the backstack using another button.
 * Each instance of the fragment keeps the position of the fragment in the stack
 */


class SecondImplementationActivity : AppCompatActivity() {

    private lateinit var btnAddFragment: Button
    private lateinit var btnRemove: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_implementation)

        // Initializes both buttons used for adding and removing
        btnAddFragment = findViewById(R.id.btnAddFragment)
        btnRemove = findViewById(R.id.btnRemove)

        /* Generates a random number from 1 - 3 to add any of the three fragments to the stack
         * upon clicking the add fragment button
         */
        btnAddFragment.setOnClickListener {
            val fragToDisplay = Random.nextInt(1, 4)
            displayFragment(fragToDisplay)
        }

        // Removes the topmost fragment from the backstack
        btnRemove.setOnClickListener {
            supportFragmentManager.popBackStack()
        }

    }

    /**
     * This takes in a random number integer between 1 and 3
     * Creates a new transaction with the fragment manager and displays the fragment by
     * adding it to the backstack when the number received matches the condition
     * @param fragToDis: Random number generated
     */

    private fun displayFragment(fragToDis: Int) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val count = fragmentManager.backStackEntryCount

        when (fragToDis) {
            1 -> {
                val firstFragment = FirstFragment.newInstance(count)
                fragmentTransaction.add(R.id.fragment_container, firstFragment)
                    .addToBackStack(null)
                    .setReorderingAllowed(true).commit()
            }
            2 -> {
                val secondFragment = SecondFragment.newInstance(count)
                fragmentTransaction.add(R.id.fragment_container, secondFragment)
                    .addToBackStack(null)
                    .setReorderingAllowed(true).commit()
            }
            3 -> {
                val thirdFragment = ThirdFragment.newInstance(count)
                fragmentTransaction.add(R.id.fragment_container, thirdFragment)
                    .addToBackStack(null)
                    .setReorderingAllowed(true).commit()

            }
        }

    }
}