package space.irsi7.tictak

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import space.irsi7.tictak.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //binding.TicTak.startClock()
        val view = binding.root
        setContentView(view)
    }

    override fun onResume() {
        binding.TicTak.startClock()
        super.onResume()
    }
}