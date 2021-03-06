package com.example.quecomohoy.ui.searchrecipes.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.quecomohoy.R
import com.example.quecomohoy.data.model.Ingredient
import com.example.quecomohoy.ui.searchrecipes.IngredientsFragment
import com.squareup.picasso.Picasso

class IngredientsAdapter(val onIngredientClick: (Ingredient) -> Unit) : RecyclerView.Adapter<IngredientsAdapter.ViewHolder>() {
    val data: MutableList<Ingredient> = listOf<Ingredient>().toMutableList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.search_ingredient_item, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = data[position]
        holder.fill(recipe)
        holder.itemView.setOnClickListener {
            onIngredientClick(recipe)
            Toast.makeText(holder.itemView.context, recipe.name, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun updateData(newData: List<Ingredient>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView = view.findViewById(R.id.recipe_name)
        var picture: ImageView = view.findViewById(R.id.recipe_pic)

        fun fill(ingredient: Ingredient) {
            name.text = ingredient.name
            if(ingredient.picture.isNotEmpty()){
                Picasso.get().load(ingredient.picture).fit().into(picture)
            }
        }
    }
}