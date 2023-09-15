package com.example.navigationApp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.openyoureyes.HomeFragment
import com.example.openyoureyes.PeopleFragment
import com.example.openyoureyes.R
import com.example.openyoureyes.ToolFragment
import com.example.openyoureyes.databinding.ActivityNaviBinding

private const val TAG_PEOPLE = "people_fragment"
private const val TAG_HOME = "home_fragment"
private const val TAG_TOOL = "tool_fragment"


class NaviActivity : AppCompatActivity() {
    //뷰바인딩 사용
    private lateinit var binding: ActivityNaviBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNaviBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //맨 처음 보여줄 프래그먼트 설정
        setFragment(TAG_HOME, HomeFragment())

        //네비 항목 클릭 시 프래그먼트 변경하는 함수 호출
        // TODO : setOnNavigationItemSelectedListener가 deprecated되어서 대체했는데 setOnItemReselectedListener 는 뭐가 다른 거지?
        binding.mainNavi.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.peopleFragment -> setFragment(TAG_PEOPLE, PeopleFragment())
                R.id.homeFragment -> setFragment(TAG_HOME, HomeFragment())
                R.id.toolFragment -> setFragment(TAG_TOOL, ToolFragment())
            }
            true
        }

        /*        //프래그먼트 설정
                val resultFragmentId = intent.getIntExtra("selectFragmentId", 0)
                binding.mainNavi.selectedItemId = resultFragmentId*/

    }

    //프래그먼트 컨트롤 함수
    fun setFragment(tag: String, fragment: Fragment){
        val manager: FragmentManager = supportFragmentManager
        val ft: FragmentTransaction = manager.beginTransaction()

        //트랜잭션에 tag로 전달된 fragment가 없을 경우 add
        if(manager.findFragmentByTag(tag) == null){
            ft.add(R.id.mainNaviFragmentContainer, fragment, tag)
        }

        //작업이 수월하도록 manager에 add되어있는 fragment들을 변수로 할당해둠
        val people = manager.findFragmentByTag(TAG_PEOPLE)
        val home = manager.findFragmentByTag(TAG_HOME)
        val tool = manager.findFragmentByTag(TAG_TOOL)

        //모든 프래그먼트 hide
        if(people!=null){
            ft.hide(people)
        }
        if(home!=null){
            ft.hide(home)
        }
        if(tool!=null){
            ft.hide(tool)
        }

        //선택한 항목에 따라 그에 맞는 프래그먼트만 show
        if(tag == TAG_PEOPLE){
            if(people!=null){
                ft.show(people)
            }
        }
        else if(tag == TAG_HOME){
            if(home!=null){
                ft.show(home)
            }
        }
        else if(tag == TAG_TOOL){
            if(tool!=null){
                ft.show(tool)
            }
        }

        //마무리
        ft.commitAllowingStateLoss()
        //ft.commit()
    }//seFragment함수 끝
}