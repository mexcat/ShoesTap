package cl.gencina.shoestap.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import cl.gencina.shoestap.InfoProductos
import cl.gencina.shoestap.R
import cl.gencina.shoestap.databinding.FragmentDetailProductBinding
import coil.load


class DetailProductFragment : Fragment() {
    private var id: Int? = null
    private lateinit var binding:FragmentDetailProductBinding
    private var bundle: Bundle? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt("id")
            bundle = it
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailProductBinding.inflate(layoutInflater, container, false)

        initData()
        return binding.root
    }

    private fun initData() {
        binding.ibVolver.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_detailProductFragment_to_initialListFragment)
        }
        var item = id?.let { InfoProductos().getShoe(it) }
        binding.ivItem.load(item?.url)
        binding.tvNombreItem.text = item?.nombre
        binding.tvPrecioItem.text = item?.precio.toString()

        binding.btnAddCart.setOnClickListener {
            Navigation.findNavController(binding.root).navigate(R.id.action_detailProductFragment_to_carritoComprasFragment, bundle)
        }
    }
}