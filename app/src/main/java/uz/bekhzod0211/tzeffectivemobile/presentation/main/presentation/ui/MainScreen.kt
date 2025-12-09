package uz.bekhzod0211.tzeffectivemobile.presentation.main.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.HiltAndroidApp
import uz.bekhzod0211.tzeffectivemobile.databinding.ScreenMainBinding
import uz.bekhzod0211.tzeffectivemobile.presentation.main.presentation.adapter.CourseAdapter
import uz.bekhzod0211.tzeffectivemobile.presentation.main.presentation.vm.MainViewModel

@HiltAndroidApp
class MainScreen: Fragment(){
    var _binding: ScreenMainBinding? = null
    private val binding: ScreenMainBinding
    get() = _binding!!
    private val vm: MainViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ScreenMainBinding.inflate(layoutInflater)


        vm.courses.observe(viewLifecycleOwner){
            binding.rvCourses.adapter = CourseAdapter(it)
        }
        return binding.root
    }






}