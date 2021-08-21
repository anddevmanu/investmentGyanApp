package com.gyan.investment.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.gyan.investment.R

class SipCalculatorFragment:Fragment() , View.OnClickListener {

    private lateinit var etAmount: EditText
    private lateinit var etRoi: EditText
    private lateinit var etTime: EditText
    private lateinit var btnSubmit: Button
    private lateinit var tvResult: TextView

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?):
            View? {

//        galleryViewModel =
//                ViewModelProvider(this).get(GalleryViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_gallery, container, false)
        val textView: TextView = root.findViewById(R.id.text_gallery)

        etAmount = root.findViewById(R.id.et_amount)
        etRoi = root.findViewById(R.id.et_roi)
        etTime = root.findViewById(R.id.et_time)
        btnSubmit = root.findViewById(R.id.btn_submit)
        tvResult=root.findViewById(R.id.tv_result)
        btnSubmit.setOnClickListener(this)

//        galleryViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        return root
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