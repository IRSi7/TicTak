package space.irsi7.tictak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import space.irsi7.tictak.databinding.FragmentClockFullSizeBinding
import space.irsi7.tictak.databinding.FragmentMenuBinding

class ClockFullSizeFragment : Fragment() {

    private lateinit var binding: FragmentClockFullSizeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentClockFullSizeBinding.inflate(inflater, container, false)
        binding.clock.startClock()
        return binding.root
    }
}