import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.openyoureyes.HomeFragment
import com.example.openyoureyes.R
import com.example.odop.databinding.ActivityNaviBinding


private const val TAG_PEOPLE = "people_fragment"
private const val TAG_HOME = "home_fragment"
private const val TAG_TOOL = "tool_fragment"

class NaviActivity : AppCompatActivity() {

    private lateinit var binding : ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setFragment(TAG_HOME, HomeFragment())

        binding.navigationView.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.peopleFragment -> setFragment(TAG_PEOPLE, peopleFragment())
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.toolFragment-> setFragment(TAG_TOOL, toolFragment())
            }
            true
        }
    }

    private fun setFragment(tag: String, fragment: Fragment) {
        val manager: FragmentManager = supportFragmentManager
        val fragTransaction = manager.beginTransaction()

        if (manager.findFragmentByTag(tag) == null){
            fragTransaction.add(R.id.mainFrameLayout, fragment, tag)
        }

        val people = manager.findFragmentByTag(TAG_PEOPLE)
        val home = manager.findFragmentByTag(TAG_HOME)
        val tool = manager.findFragmentByTag(TAG_TOOL)

        if (people != null){
            fragTransaction.hide(people)
        }

        if (home != null){
            fragTransaction.hide(home)
        }

        if (tool != null) {
            fragTransaction.hide(tool)
        }

        if (tag == TAG_PEOPLE) {
            if (people!=null){
                fragTransaction.show(people)
            }
        }
        else if (tag == TAG_HOME) {
            if (home != null) {
                fragTransaction.show(home)
            }
        }

        else if (tag == TAG_TOOL){
            if (tool != null){
                fragTransaction.show(tool)
            }
        }

        fragTransaction.commitAllowingStateLoss()
    }
}