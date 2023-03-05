package space.irsi7.tictak

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import space.irsi7.tictak.contract.Navigator
import space.irsi7.tictak.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainer) as NavHostFragment
        navController = navHost.navController

        val view = binding.root
        setContentView(view)
    }

    private fun launchDestination(destinationId: Int){
        navController.navigate(destinationId)
    }

    override fun showFullScreenClock() {
        launchDestination(R.id.clockFullSizeFragment)
    }

    override fun showTableClock() {
        launchDestination(R.id.tableClockFragment)
    }


    override fun goBack() {
        navController.popBackStack()
    }

}