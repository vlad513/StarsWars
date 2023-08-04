package com.star_wars.presentation.menu.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.star_wars.databinding.FragmentFavoriteBinding
import com.star_wars.domain.models.ModelDomainFavorite
import com.star_wars.presentation.menu.favorite.adapter.mapToCallback
import com.star_wars.presentation.menu.main.adapter.AdapterFavoriteCallback
import com.star_wars.presentation.menu.main.adapter.FavoriteAdapter
import com.star_wars.presentation.menu.main.adapter.MainAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class FavoriteFragment : Fragment(), AdapterFavoriteCallback {
    private val adapter by lazy(LazyThreadSafetyMode.NONE) {
        FavoriteAdapter(this)
    }
    private val viewModel by viewModel<FavoriteViewModel>()
    lateinit var binding: FragmentFavoriteBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoriteBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.getDatabase()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.RcView.adapter = adapter

        lifecycleScope.launchWhenCreated {
            viewModel.peoplesByFlow.collect {
                it?.let { it1 -> adapter.addRepoz(it1) }
            }
        }
    }

    override fun delete(peoples: ModelDomainFavorite, position: Int) {
        viewModel.deleteDatabase(peoples = peoples)
        adapter.removeItem(position)
    }

    override fun send(peoples: ModelDomainFavorite) {
        findNavController().navigate(
            FavoriteFragmentDirections.actionFavoriteFragmentToMoreInfoFragment(
                peoples = mapToCallback(peoples)
            )
        )
    }


}