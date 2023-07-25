package cl.gencina.shoestap.vista

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import cl.gencina.shoestap.CarritoComprasRvAdapter
import cl.gencina.shoestap.InfoProductos
import cl.gencina.shoestap.R
import cl.gencina.shoestap.databinding.FragmentCarritoComprasBinding
import cl.gencina.shoestap.modelo.Shoes
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class CarritoComprasFragment : Fragment() {
    private var id: Int? = null

    private lateinit var binding:FragmentCarritoComprasBinding
    private lateinit var preferences :SharedPreferences
    var lista = mutableListOf<Shoes>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt("id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCarritoComprasBinding.inflate(layoutInflater, container, false)
        preferences = this.requireActivity().getSharedPreferences("carroCompras", Context.MODE_PRIVATE)
        initData()
        return binding.root
    }

    private fun initData() {
        var total = 0.0
        var gson = Gson()

        var listaData = preferences.getString("listaCarro", null)
        val type: Type = object : TypeToken<MutableList<Shoes?>?>() {}.type

        Log.e("listaData",listaData.toString())
        if(listaData != null) {
            lista = gson.fromJson(listaData, type)
        }
        lista.add(InfoProductos().getShoe(id!!))

        lista.forEach {
            total += it.precio
        }

        initApadter(lista)
        saveToShared(lista)
        binding.tvTotal.text = total.toString()
        binding.ibVolverCarrito.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_carritoComprasFragment_to_initialListFragment)
        }
    }

    fun removeElement(item:Shoes){

    }

    private fun saveToShared(lista: MutableList<Shoes>) {
        var gson = Gson()
        var listaGson = gson.toJson(lista)
        preferences.edit().clear().apply()
        preferences.edit().putString("listaCarro", listaGson).apply()
    }

    private fun initApadter(lista:MutableList<Shoes>) {
        val adapter = CarritoComprasRvAdapter()
        adapter.setData(lista)
        binding.rvListaCarrito.adapter = adapter
    }
}