package cl.gencina.shoestap

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.gencina.shoestap.databinding.PrincipalItemBinding
import cl.gencina.shoestap.modelo.Shoes
import coil.load

public class PrincipalRvAdapter : RecyclerView.Adapter<PrincipalRvAdapter.ViewHolder>() {
    private lateinit var context:Context
    var listaZapatosTienda: List<Shoes> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PrincipalRvAdapter.ViewHolder {
        context = parent.context
        return ViewHolder(
            PrincipalItemBinding.inflate(LayoutInflater.from(context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PrincipalRvAdapter.ViewHolder, position: Int) {
        val item = listaZapatosTienda[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return listaZapatosTienda.size
    }

    fun setData(shoes: List<Shoes>){
        this.listaZapatosTienda = shoes
    }

    inner class ViewHolder(private val binding : PrincipalItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(item:Shoes){
            binding.tvNombre.text = item.nombre
            binding.tvPrecio.text = item.precio.toString()
            binding.ivProducto.load(item.url)
            binding.cvItemPrincipal.setOnClickListener {
                var bundle = Bundle()
                bundle.putInt("id", item.id)
                Navigation.findNavController(binding.root).navigate(R.id.action_initialListFragment_to_detailProductFragment, bundle)
            }
        }
    }

}