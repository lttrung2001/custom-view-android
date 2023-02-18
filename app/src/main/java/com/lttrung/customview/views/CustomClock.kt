package com.lttrung.customview.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import android.widget.TextView
import com.lttrung.customview.R
import java.text.SimpleDateFormat
import java.util.*

class CustomClock(context: Context?, attrs: AttributeSet?) : View(context, attrs) {
    private var mPaint: Paint
    private var mFormatTime: SimpleDateFormat
    private var mFormatDate: SimpleDateFormat
    private var mYTitle: Int
    private var mXTitle: Int
    private var mWidthStrock: Int
    private var mColorStrock: Int

    private lateinit var mCanvas: Canvas

    init {
        val typedArray = context!!.obtainStyledAttributes(attrs, R.styleable.CustomClock)
        mColorStrock = typedArray.getColor(R.styleable.CustomClock_width_strock_circle, Color.GREEN)
        mWidthStrock =
            typedArray.getDimensionPixelOffset(R.styleable.CustomClock_width_strock_circle, 20)
        mXTitle = typedArray.getDimensionPixelOffset(R.styleable.CustomClock_x_title, 200)
        mYTitle = typedArray.getDimensionPixelOffset(R.styleable.CustomClock_y_title, 200)
        typedArray.recycle()

        mFormatDate = SimpleDateFormat("dd/MM/yyyy")
        mFormatTime = SimpleDateFormat("hh:mm:ss")
        mPaint = Paint()
        mPaint.isAntiAlias = true
        //set style cho paint
        //set style cho paint
        mPaint.style = Paint.Style.STROKE
        //set size text
        //set size text
        mPaint.textSize = 150F
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.let {
            this.mCanvas = canvas
            val rectOval = RectF(
                mWidthStrock / 2F, mWidthStrock / 2F,
                width - mWidthStrock / 2F, width - mWidthStrock / 2F
            )
            mPaint.strokeWidth = mWidthStrock.toFloat()
            mPaint.color = mColorStrock
            mCanvas.drawOval(rectOval, mPaint)

            mPaint.strokeWidth = 10F
            mPaint.color = Color.parseColor("#8BC34A")
            mPaint.textAlign = Paint.Align.CENTER
            val smileText = "Smile"
            mCanvas.drawText(smileText, width.toFloat() / 2, 600F, mPaint)

            drawDate()
        }
    }

    fun drawDate(date: Date = Date()) {
        val strDate = mFormatDate.format(date)

        mPaint.textSize = 100F
        mCanvas.drawText(strDate, width.toFloat() / 2, 750F, mPaint)

        val strTime = mFormatTime.format(date)
        mCanvas.drawText(strTime, width.toFloat() / 2, 900F, mPaint)
    }
}