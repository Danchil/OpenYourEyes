package com.example.openyoureyes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.openyoureyes.Model.Sound
import com.example.openyoureyes.Model.SoundAdapter
import com.example.openyoureyes.databinding.ActivityMainBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
class SoundListFragment : Fragment() {
    private var mBinding: ActivityMainBinding ?= null
    private val binding get() = mBinding!!

    var SoundList = arrayListOf<Sound>(
        Sound(R.drawable.android, "벨소리1"),
        Sound(R.drawable.android, "벨소리2")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val Adapter = SoundAdapter(this, SoundList)
        binding.listView.adapter = Adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sound_list, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SoundListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SoundListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}