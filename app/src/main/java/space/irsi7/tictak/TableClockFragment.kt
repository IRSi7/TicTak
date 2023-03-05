package space.irsi7.tictak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import space.irsi7.tictak.databinding.FragmentClockFullSizeBinding
import space.irsi7.tictak.databinding.FragmentTableClockBinding

class TableClockFragment : Fragment() {
    private lateinit var binding: FragmentTableClockBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTableClockBinding.inflate(inflater, container, false)
        binding.clockOne.startClock()
        binding.clockTwo.startClock()
        binding.clockThree.startClock()
        binding.clockFour.startClock()
        binding.clockFive.startClock()
        binding.clockSix.startClock()
        return binding.root
    }
}