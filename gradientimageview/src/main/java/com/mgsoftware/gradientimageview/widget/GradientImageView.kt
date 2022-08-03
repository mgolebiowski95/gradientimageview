package com.mgsoftware.gradientimageview.widget

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.animation.LinearInterpolator
import androidx.appcompat.widget.AppCompatImageView
import com.mgsoftware.gradientimageview.R
import org.mini2Dx.gdx.math.Rectangle

class GradientImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {
    private var colors = mutableListOf<Int>()

    private val bounds = Rectangle()
    private val drawableBounds = Rectangle()

    private val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    var interpolator = LinearInterpolator()
        set(value) {
            field = value
            updateBitmap()
            invalidate()
        }

    private lateinit var bitmap: Bitmap

    init {
        fillPaint.color = Color.WHITE

        val a =
            context.obtainStyledAttributes(attrs, R.styleable.GradientImageView, defStyleAttr, 0)
        if (a.hasValue(R.styleable.GradientImageView_GradientImageView_colorList)) {
            val colorsId =
                a.getResourceId(R.styleable.GradientImageView_GradientImageView_colorList, 0)
            colors.addAll(a.resources.getIntArray(colorsId).toList())
        }
        a.recycle()
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        bounds.set(0f, 0f, w.toFloat(), h.toFloat())
        updateBitmap()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.drawBitmap(bitmap, drawableBounds.x, drawableBounds.y, null)
    }

    override fun setImageResource(resId: Int) {
        super.setImageResource(resId)
        updateBitmap()
    }

    private fun updateBitmap() {
        drawableBounds.set(
            0f,
            0f,
            drawable.intrinsicWidth.toFloat(),
            drawable.intrinsicHeight.toFloat()
        )
        drawableBounds.fitInside(bounds)

        // prepare new bitmap
        bitmap = Bitmap.createBitmap(
            drawableBounds.width.toInt(),
            drawableBounds.height.toInt(),
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)

        // draw original drawable
        drawable.bounds.set(
            0,
            0,
            drawableBounds.width.toInt(),
            drawableBounds.height.toInt()
        )
        drawable.draw(canvas)

        // tint this drawable with paint (gradient)
        if (colors.isNotEmpty()) {
            updateShader()
            canvas.drawRect(
                0f,
                0f,
                drawableBounds.width,
                drawableBounds.height,
                fillPaint
            )
        }
    }

    fun setColors(newColors: List<Int>) {
        colors.clear()
        colors.addAll(newColors)
        updateBitmap()
        invalidate()
    }

    fun setColors(newColors: Array<Int>) {
        colors.clear()
        colors.addAll(newColors)
        updateBitmap()
        invalidate()
    }

    fun setColors(newColors: IntArray) {
        colors.clear()
        colors.addAll(newColors.toList())
        updateBitmap()
        invalidate()
    }

    private fun updateShader() {
        val step = 1f / (colors.size - 1)
        val shader = LinearGradient(
            0f,
            0f,
            0f,
            drawableBounds.height,
            colors.toIntArray(),
            FloatArray(colors.size) { a ->
                val fa = interpolator.getInterpolation(a * step)
                Log.d("echo", "$a => $fa")
                fa
            },
            Shader.TileMode.REPEAT
        )
        fillPaint.shader = shader
        fillPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)
    }

    companion object {
        var debug = false
    }
}