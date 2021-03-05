package com.example.week_2_task

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider


/**
 * The main activity for the first implementation of the task
 * This shows the various lifecycle of an activity and displays a corresponding text
 * to match the lifecycle the activity is undergoing .
 * Also, keeps a count of the number of times orientation change occurs and the
 * corresponding orientation.
 *
 * Finally, an intent to launch the next activity for the second implementation by clicking on the
 * first textView.
 */

class MainActivity : AppCompatActivity() {

    /* Declares the textViews present in the layout of the activity using lateinit which is
     * initialized in the onCreate to make it available for use in other methods
     */
    private lateinit var txtActivityLifecycle: TextView
    private lateinit var txtCounterNdOrientation: TextView

    private val tag = this::class.simpleName

    // Creates a reference to the main activity Viewmodel class such that when an activity is recreated, the reference is received
    // and initial creation is delayed until it is required
    private val viewModel by lazy {
        ViewModelProvider(this)[MainActivityViewModel::class.java]
    }


    //=============================================================================//
    /**
     * Demonstrates the various lifecycle of an activity using handlers to
     * post delay when necessary in order to update the text field of the
     * current lifecycle.
     */
    //==============================================================================//


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCounterNdOrientation = findViewById(R.id.txtCounterNdOrientation)
        txtActivityLifecycle = findViewById(R.id.txtActivityLifecycle)

        /* Changes the counter upon creation if the activity is newly created, updates
         * the text field with the initial values of the counter, upon each orientation
         * the counter gets updated
         */
        if (savedInstanceState != null) {
            changeCounter()
        } else {
            getOrientationAndScore()
        }

        txtActivityLifecycle.text = getString(R.string.on_create_lifecycle)

        // Launches the second activity to demonstrate addition of fragments to a backstack
        txtActivityLifecycle.setOnClickListener {
            val intent = Intent(this, SecondImplementationActivity::class.java)
            startActivity(intent)
        }
        Log.d(tag, "On Create")

    }

    override fun onStart() {
        super.onStart()
        Handler(Looper.getMainLooper()).postDelayed({
            txtActivityLifecycle.text = getString(R.string.on_start_lifecycle)
        }, 2000)
        Log.d(tag, "On Start")

    }

    override fun onResume() {
        super.onResume()
        Handler(Looper.getMainLooper()).postDelayed({
            txtActivityLifecycle.text = getString(R.string.on_resume_lifecycle)
        }, 3000)
        Log.d(tag, "On Resume")
    }

    override fun onPause() {
        super.onPause()
        txtActivityLifecycle.text = getString(R.string.on_pause_lifecycle)

        Log.d(tag, "On Pause")
    }

    override fun onStop() {
        super.onStop()
        Handler(Looper.getMainLooper()).postDelayed({
            txtActivityLifecycle.text = getString(R.string.on_stop_lifecycle)
        }, 2000)
        Log.d(tag, "On Stop")
    }

    override fun onRestart() {
        super.onRestart()
        Handler(Looper.getMainLooper()).postDelayed({
            txtActivityLifecycle.text = getString(R.string.on_restart_lifecycle)
        }, 1000)
        Log.d(tag, "On Restart")
    }

    override fun onDestroy() {
        Toast.makeText(applicationContext, "On Destroy..", Toast.LENGTH_SHORT).show()
        txtActivityLifecycle.text = getString(R.string.on_destroy_lifecycle)
        Log.d(tag, "On Destroy")
        super.onDestroy()

    }


    /**
     * Gets the current counter from the viewmodel upon an orientation change
     * Increments by 1 and updates the appropriate text field
     */
    private fun changeCounter() {
        viewModel.counter = viewModel.counter + 1
        getOrientationAndScore()
    }

    /**
     * Gets the current orientation from the activity resources and updates the
     * text field with the current counter and orientation configuration
     */
    private fun getOrientationAndScore() {
        val orientation = this.resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            txtCounterNdOrientation.text = getString(R.string.portrait_mode_counter, viewModel.counter)
        } else {
            txtCounterNdOrientation.text = getString(R.string.landscape_mode_counter, viewModel.counter)
        }
    }


}