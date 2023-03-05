package space.irsi7.tictak

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import space.irsi7.tictak.contract.navigator
import space.irsi7.tictak.databinding.ActivityMainBinding
import space.irsi7.tictak.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {

    private lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentMenuBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        binding.clock.startClock()
        binding.fullSizeClockButton.setOnClickListener { navigator().showFullScreenClock() }
        binding.tableClockButton.setOnClickListener{ navigator().showTableClock() }

        return binding.root
    }
}