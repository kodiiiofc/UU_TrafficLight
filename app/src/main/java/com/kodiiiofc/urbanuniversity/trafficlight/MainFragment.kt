package com.kodiiiofc.urbanuniversity.trafficlight

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import com.google.android.material.transition.Hold
import com.google.android.material.transition.MaterialElevationScale
import com.kodiiiofc.urbanuniversity.trafficlight.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private var navigateUpButtonSwitcher: NavigateUpButtonSwitcher? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigateUpButtonSwitcher = context as NavigateUpButtonSwitcher
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        navigateUpButtonSwitcher?.switchNavigateUpButton(false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.redBtn.setOnClickListener {
            navigateUpButtonSwitcher?.switchNavigateUpButton(true)
            val action = MainFragmentDirections.actionMainFragmentToLightFragment("СТОП!", R.color.red, R.color.dark_red)
            val extras = FragmentNavigatorExtras(
                binding.redBtn to "btn"
            )
            findNavController().navigate(action, extras)

        }
        binding.yellowBtn.setOnClickListener {
            navigateUpButtonSwitcher?.switchNavigateUpButton(true)
            val action = MainFragmentDirections.actionMainFragmentToLightFragment("Внимание!", R.color.yellow, R.color.dark_yellow)
            val extras = FragmentNavigatorExtras(
                binding.yellowBtn to "btn"
            )
            findNavController().navigate(action, extras)
        }
        binding.greenBtn.setOnClickListener {
            navigateUpButtonSwitcher?.switchNavigateUpButton(true)
            val action = MainFragmentDirections.actionMainFragmentToLightFragment("Движение разрешено!", R.color.green, R.color.dark_green)
            val extras = FragmentNavigatorExtras(
                binding.greenBtn to "btn"
            )
            findNavController().navigate(action, extras)
        }
    }


}
