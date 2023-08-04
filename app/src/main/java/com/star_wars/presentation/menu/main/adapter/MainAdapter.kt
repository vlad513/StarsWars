package com.star_wars.presentation.menu.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.star_wars.R
import com.star_wars.databinding.ItemPeopleBinding
import com.star_wars.domain.models.ModelDomainResults
import java.util.ArrayList


class MainAdapter(
    private var callback: AdapterMainCallback
) : RecyclerView.Adapter<MainAdapter.RepozHolder>() {
    private val repozList = ArrayList<ModelDomainResults?>()

    class RepozHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPeopleBinding.bind(itemView)


        @SuppressLint("SimpleDateFormat", "SetTextI18n")
        fun bind(item: ModelDomainResults?, callback: AdapterMainCallback, position: Int) =
            with(binding) {
                TvName.text = item?.name
                TvGender.text = item?.gender
                TvStarship.text = item?.starships?.count().toString()
                ImView.setOnClickListener {
                    ImView.load(R.drawable.star_filled)
                    item?.let { callback.favorite(it) }
                }
                CardView.setOnClickListener {
                    item?.let { it1 -> callback.send(peoples = it1) }
                }

            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepozHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_people, parent, false)
        return RepozHolder(view)
    }

    override fun onBindViewHolder(holder: RepozHolder, position: Int) {
        holder.bind(repozList[position], callback, position)
    }

    override fun getItemCount(): Int {
        return repozList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun addRepoz(it: List<ModelDomainResults?>) {
        repozList.clear()
        repozList.addAll(it)
        notifyDataSetChanged()
    }


}