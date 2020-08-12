package com.doubleslash.ddamiapp.activity.login

import android.content.Context
import android.util.AttributeSet
import androidx.constraintlayout.widget.ConstraintLayout
import com.doubleslash.ddamiapp.R
import kotlinx.android.synthetic.main.chip_custom.view.*


//class CustomBaseView @JvmOverloads constructor(
//        context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
//) : ConstraintLayout(context, attrs, defStyleAttr) {
//    init {
//        LayoutInflater.from(context).inflate(R.layout.chip_custom, this, true)
//    }
//}

open class CustomBaseView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0)
    : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.chip_custom, this)
        et_chip_name.text = ""
    }

    fun setChipName(name: String) {
        et_chip_name.text = name
    }
}