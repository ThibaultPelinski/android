package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.ListBinding

class ProductsListFragment : Fragment() {

    private lateinit var binding: ListBinding

    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val products = Nutritional(
            name = "Petit pois et carottes",
            brand = "Cassegrain",
            ingredients = listOf(
                "Petits pois 66%",
                "eau",
                "garniture 2.8%(salade, oignon grelot) ",
                "sucre",
                "sel",
                "arôme naturel"
            ),
            barres = "Code barres : 3083680085304",
            quantité = "Quantité : 400 g (280 g net égoutté)",
            vendu = "Vendu en : France, Japon, Suisse",
            url = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
            substance = "Substances allergènes : Aucune",
            additifs = "Additifs : Aucun"
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())

    }
}
