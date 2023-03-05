package space.irsi7.tictak

import android.content.Context
import android.icu.util.Calendar
import android.icu.util.TimeZone
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.animation.LinearInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import space.irsi7.tictak.databinding.TicTakBinding

class TicTakViewV2(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int,
    defStyleRes: Int
): FrameLayout(context, attrs, defStyleAttr, defStyleRes) {

    private val binding: TicTakBinding

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int  ) : this(context, attrs, defStyleAttr, 0)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context) : this(context, null)

    init {
        val inflater = LayoutInflater.from(context)
        inflater.inflate(R.layout.tic_tak, this, true)
        binding = TicTakBinding.bind(this)
    }
    /**Инициализирует часы
     * */
    fun startClock(){
        //Получаем время с эпохи UNIX, берём поправку на время системы
        val time = Calendar.getInstance().timeInMillis + TimeZone.getDefault().rawOffset

        //Инициализируем секундную, минутную, секундную стрелки
        startHand(binding.secondHand, timeToDegrees(time, MINUTE_MILLIS), MINUTE_MILLIS)
        startHand(binding.minuteHand, timeToDegrees(time, HOUR_MILLIS), HOUR_MILLIS)
        startHand(binding.hourHand, timeToDegrees(time, HALF_DAY_MILLIS), HALF_DAY_MILLIS)
    }
    /**Выставляет стрелку в правильное положение:
     *  hand - стрелка (ImageView), которую будем поваричивать;
     *  fromDegree - начальный градус поворота стрелки, с которого запускается бесконечная анимация;
     *  duration - длительность цикла анимации
    */
    private fun startHand(hand: ImageView, fromDegree: Float, duration: Long){
        var runnable: Runnable? = null
        runnable = Runnable {
            //Поворот на стрелки, после которого она показывает правилное время
            hand.rotation = fromDegree
            //Запуск анимации с циклом равным минуте, часу или 12 часам
            hand.animate()
                .rotation(360f + fromDegree)
                .setDuration(duration)
                .setInterpolator(LinearInterpolator())
                //Зацикливание анимации
                .withEndAction(runnable)
                .start()
        }
        runnable.run()
    }
    /**Принимает: time - время с эпохи UNIX, duration - константа, по которой мы понимаем
     * градус для какой стрелки нам нужен, возвращает градус поворота
     */
    private fun timeToDegrees(time: Long, duration: Long): Float{
        return when(duration){
            //Секундная стрелка
            MINUTE_MILLIS -> ((time % MINUTE_MILLIS) / SECOND_MILLIS.toFloat()) * 6
            //Минутная стрелка
            HOUR_MILLIS -> ((time % HOUR_MILLIS) / MINUTE_MILLIS.toFloat()) * 6
            //Часовая стрелка
            HALF_DAY_MILLIS -> ((time % HALF_DAY_MILLIS) / HOUR_MILLIS.toFloat()) * 30
            //
            else -> 0f
        }
    }

    /**Константы, сколько миллисекунд в секунде, минуте, часе, половине дня
     */
    companion object{
        private const val SECOND_MILLIS: Long = 1000
        private const val MINUTE_MILLIS: Long = 60*1000
        private const val HOUR_MILLIS: Long = 60*60*1000
        private const val HALF_DAY_MILLIS: Long = 12*60*60*1000
    }

}