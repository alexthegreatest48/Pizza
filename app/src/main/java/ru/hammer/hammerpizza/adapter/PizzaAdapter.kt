package ru.hammer.hammerpizza.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.hammer.hammerpizza.dto.Pizza
import ru.hammer.hammerpizza.databinding.CardPizzaBinding
import ru.hammer.hammerpizza.view.load


class PizzaAdapter() : RecyclerView.Adapter<PizzaViewHolder>() {
    var list = emptyList<Pizza>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PizzaViewHolder {
        val binding = CardPizzaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PizzaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PizzaViewHolder, position: Int) {
        val pizza = list[position]
        holder.bind(pizza)
    }

    override fun getItemCount(): Int = list.size
}

class PizzaViewHolder(
    private val binding: CardPizzaBinding
) : RecyclerView.ViewHolder(binding.root){
    fun bind(pizza: Pizza){
        binding.apply{
            name.text = pizza.name
            photo.load("http://10.0.2.2:9999/avatars/${pizza.photo}")
            ingridients.text = pizza.ingridients
        }
    }

}
