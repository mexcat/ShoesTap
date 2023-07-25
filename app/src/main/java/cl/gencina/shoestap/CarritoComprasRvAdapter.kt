package cl.gencina.shoestap

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Adapter
import androidx.recyclerview.widget.RecyclerView
import cl.gencina.shoestap.databinding.CarritoComprasItemBinding
import cl.gencina.shoestap.modelo.Shoes
import cl.gencina.shoestap.vista.CarritoComprasFragment
import coil.load

public class CarritoComprasRvAdapter : RecyclerView.Adapter<CarritoComprasRvAdapter.ViewHolder>() {
    private lateinit var context:Context
    var listaZapatosTienda: MutableList<Shoes> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CarritoComprasRvAdapter.ViewHolder {
        context = parent.context
        return ViewHolder(
            CarritoComprasItemBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: CarritoComprasRvAdapter.ViewHolder, position: Int) {
        val item = listaZapatosTienda[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listaZapatosTienda.size
    }

    fun setData(shoes: MutableList<Shoes>){
        this.listaZapatosTienda = shoes
    }


    inner class ViewHolder(private val binding : CarritoComprasItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item:Shoes){
            binding.tvNombreItemCarrito.text = item.nombre

            binding.ivImageCarrito.load(item.url)
            binding.ibDeleteItemCarrito.setOnClickListener {
                listaZapatosTienda.remove(item)
            }

        }
    }

}