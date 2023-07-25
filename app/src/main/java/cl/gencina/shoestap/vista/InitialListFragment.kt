package cl.gencina.shoestap.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cl.gencina.shoestap.InfoProductos
import cl.gencina.shoestap.PrincipalRvAdapter
import cl.gencina.shoestap.databinding.FragmentInitialListBinding
import cl.gencina.shoestap.modelo.Shoes

class InitialListFragment : Fragment() {
    private lateinit var binding : FragmentInitialListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentInitialListBinding.inflate(layoutInflater, container, false)
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        val adapter = PrincipalRvAdapter()
        adapter.setData(InfoProductos().returnShoeList())
        binding.rvListaPrincipal.adapter = adapter
    }

}