package com.kimchangyoun.rootbeerFresh.sample.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.updateLayoutParams
import androidx.recyclerview.widget.RecyclerView
import com.kimchangyoun.rootbeerFresh.sample.R
import com.kimchangyoun.rootbeerFresh.sample.RootItemResult
import kotlinx.android.extensions.LayoutContainer

class RootItemAdapter : RecyclerView.Adapter<RootItemAdapter.RootItemVH>() {
    private val items: MutableList<RootItemResult> = mutableListOf()

    fun update(results: List<RootItemResult>) {
        items.clear()
        items.addAll(results)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RootItemVH {
        val inflater = LayoutInflater.from(parent.context)
        return RootItemVH(
            inflater.inflate(
                R.layout.item_root_check,
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: RootItemVH, position: Int) = holder.bind(items[position])

    fun add(rootItemResult: RootItemResult) {
        items.add(rootItemResult)
        notifyItemInserted(items.size - 1)
    }

    fun clear() {
        items.clear()
        notifyDataSetChanged()
    }

    class RootItemVH(override val containerView: View) : RecyclerView.ViewHolder(containerView),
        LayoutContainer {
        fun bind(item: RootItemResult) {
            val rootItemText = containerView.findViewById<TextView>(R.id.rootItemText)
            val rootItemResultIcon = containerView.findViewById<ResultIconView>(R.id.rootItemResultIcon)

            rootItemText.text = item.text
            rootItemResultIcon.update(isRooted = item.result)
        }
    }
}
