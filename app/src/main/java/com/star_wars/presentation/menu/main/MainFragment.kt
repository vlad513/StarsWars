package com.star_wars.presentation.menu.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.star_wars.databinding.FragmentMainBinding
import com.star_wars.domain.models.ModelDomainResults
import com.star_wars.presentation.menu.favorite.FavoriteFragmentDirections
import com.star_wars.presentation.menu.main.adapter.AdapterMainCallback
import com.star_wars.presentation.menu.main.adapter.FavoriteAdapter
import com.star_wars.presentation.menu.main.adapter.MainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainFragment : Fragment(), AdapterMainCallback {
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        MainAdapter(this)
    }
    private val viewModel by viewModel<MainViewModel>()
    lateinit var binding: FragmentMainBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rcView.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.peoplesByFlow.collect {
                it?.let { it1 -> adapter.addRepoz(it1) }
            }
        }

        binding.EditText.doAfterTextChanged {
            if (binding.EditText.text.count() >= 2)
                viewModel.getSearch(query = binding.EditText.text.toString())
        }
    }

    override fun favorite(peoples: ModelDomainResults) {
        viewModel.addFavorite(peoples = peoples)
    }

    override fun send(peoples: ModelDomainResults) {
        findNavController().navigate(
            MainFragmentDirections.actionMainFragmentToMoreInfoFragment(
                peoples = peoples
            )
        )
    }

}