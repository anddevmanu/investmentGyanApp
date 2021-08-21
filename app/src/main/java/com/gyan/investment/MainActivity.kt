package com.gyan.investment

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var appBarConfiguration: AppBarConfiguration
    val a: Int = 10000
    val b: Boolean = true
    private lateinit var etAmount: EditText
    private lateinit var etRoi: EditText
    private lateinit var etTime: EditText
    private lateinit var btnSubmit: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        etAmount = findViewById(R.id.et_amount)
        etRoi = findViewById(R.id.et_roi)
        etTime = findViewById(R.id.et_time)
        btnSubmit = findViewById(R.id.btn_submit)
        tvResult=findViewById(R.id.tv_result)
        btnSubmit.setOnClickListener(this)

//        1st tab.   FD Calculator
//                2nd tab  RD Calculator
//        3rd tab.  Loan Calculator
//                4 th tab  SIP Calculator
//        5th tab.  PPF Calculator with detail
//                6th tab   detailed EPF Calculator
//                7th tab. Nsc Calculator with detail


                // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.btn_submit -> {
                // do some work here
                val amount:Double=etAmount.text.toString().toDouble()
                val time:Double=etTime.text.toString().toDouble()
                val roi:Double=etRoi.text.toString().toDouble()

               val amountWitInterest: Double = amount*(Math.pow(((1+(roi/(100*4)))).toDouble(),(4*time).toDouble()))

                Log.e("FD Amount",amountWitInterest.toString() +amount.toString()+time.toString()+roi.toString())
                tvResult.setText(amountWitInterest.toString())

            }
        }
    }
}

