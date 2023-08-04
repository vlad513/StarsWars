package com.star_wars.presentation.menu.main.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.star_wars.R
import com.star_wars.databinding.ItemPeopleBinding
import com.star_wars.domain.models.ModelDomainFavorite
import java.util.ArrayList


class FavoriteAdapter(
    private var callback: AdapterFavoriteCallback
) : RecyclerView.Adapter<FavoriteAdapter.RepozHolder>() {
    private var repozList = ArrayList<ModelDomainFavorite?>()

    class RepozHolder(
        itemView: View
    ) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemPeopleBinding.bind(itemView)


        @SuppressLint("SimpleDateFormat", "SetTextI18n")
        fun bind(item: ModelDomainFavorite?, callback: AdapterFavoriteCallback, position: Int) =
            with(binding) {
                ImView.load(R.drawable.star_filled)
                TvName.text = item?.name
                TvGender.text = item?.gender
                TvStarship.text = item?.starships?.count().toString()
                ImView.setOnClickListener {
                    item?.let { callback.delete(it,position) }
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
    fun addRepoz(it: List<ModelDomainFavorite?>) {
        repozList.clear()
        repozList.addAll(it)
        notifyDataSetChanged()
    }
    @SuppressLint("NotifyDataSetChanged")
    fun removeItem(position:Int) {
        repozList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, repozList.size)
    }

}