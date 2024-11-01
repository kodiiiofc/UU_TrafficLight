package com.kodiiiofc.urbanuniversity.trafficlight

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.transition.TransitionInflater
import com.kodiiiofc.urbanuniversity.trafficlight.databinding.FragmentLightBinding

class LightFragment : Fragment() {
    private var _binding: FragmentLightBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedElementEnterTransition =
TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.fade)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLightBinding.inflate(layoutInflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: LightFragmentArgs by navArgs()
        binding.textTv.text = args.text
        binding.textTv.setTextColor(args.textColor)
        binding.root.setBackgroundResource(args.backgroundColor)
    }
}