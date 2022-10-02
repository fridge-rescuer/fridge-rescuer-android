package com.fridgerescuer.presentation.views.myfridge.addingr

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import com.fridgerescuer.presentation.R

class IngrSearchAdapter (

    private val contextAct: Context,
    private val resource: Int,
    private val list: MutableList<String>
): ArrayAdapter<String>(contextAct, resource, list),
    Filterable {

    override fun getCount(): Int = list.size
    override fun getItem(position: Int): String = list[position]
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = LayoutInflater.from(contextAct).inflate(R.layout.item_search_complete, null, false)
        val textView: TextView = view.findViewById(R.id.search_complete_text)
        textView.text = list[position]
        return view
    }

    override fun getFilter(): Filter = mfilter

    private var mfilter: Filter = object: Filter() {
        override fun performFiltering(constraint: CharSequence?): Filter.FilterResults {

            val results = FilterResults()
            val query =
                if (constraint != null && constraint.isNotEmpty()) autoComplete(constraint.toString())
                else arrayListOf()

            results.values = query
            results.count = query.size
            return results
        }

        private fun autoComplete(input: String): MutableList<String> {
            val results = arrayListOf<String>()

            for (i in list) {
                results.add(i)
            }
            return results
        }

        override fun publishResults(constraint: CharSequence?, results: Filter.FilterResults) {
            if (results.count > 0) notifyDataSetChanged()
            else notifyDataSetInvalidated()
        }
    }

    fun getObject(position: Int) = list[position]

    fun setData(changedList: List<String>) {
        list.clear()
        list.addAll(changedList)
    }
}