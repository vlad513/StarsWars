package com.star_wars.presentation.more

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.star_wars.R
import com.star_wars.databinding.FragmentMoreInfoBinding
import com.star_wars.presentation.menu.main.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MoreInfoFragment : DialogFragment() {
    private val args: MoreInfoFragmentArgs by navArgs()
    lateinit var binding: FragmentMoreInfoBinding
    private val viewModel by viewModel<MoreViewModel>()

    override fun onResume() {
        super.onResume()
        val params: ViewGroup.LayoutParams = dialog!!.window!!.attributes
        params.width = ViewGroup.LayoutParams.MATCH_PARENT
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT
        dialog!!.window!!.attributes = params as WindowManager.LayoutParams
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoreInfoBinding.inflate(layoutInflater)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            TvName.text = "${resources.getString(R.string.name)} ${args.peoples.name}"
            TvGender.text = "${resources.getString(R.string.gender)} ${args.peoples.gender}"
            TvStarship.text =
                "${resources.getString(R.string.starship)} ${args.peoples.starships.count()}"

        }
        viewModel.getPlanets(args.peoples.homeworld?.takeLast(2).toString())

        lifecycleScope.launchWhenCreated {
            viewModel.planetSharedFlow.collect {
                binding.TvPlanets.text = "${resources.getString(R.string.planet)} ${it?.name}"
                binding.TvPlanetsDiam.text =
                    "${resources.getString(R.string.diametr)} ${it?.diameter}"
                binding.TvPlanetsPopulars.text =
                    "${resources.getString(R.string.population)} ${it?.population}"
            }
        }
    }
}