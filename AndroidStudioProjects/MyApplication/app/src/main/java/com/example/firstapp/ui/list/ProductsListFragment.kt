package com.example.firstapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.model.Product
import com.example.firstapp.model.ServerResponse

import com.example.firstapp.databinding.ListBinding
import com.example.firstapp.databinding.ListItemBinding
import com.example.firstapp.model.ServerResponse.Response

class ProductsListFragment : Fragment(), ProductsListAdapter.OnProductItemClicked {

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


        val products = listOf(
            Response(
                name = "Nom du produit 1",
                brands = "",
                additives = "aucune",
                barcode = "029388383838",
                ingredients = listOf("Ingr1", "Ingr2")
                url_image = "https://www.aprifel.com/wp-content/uploads/2019/02/carotte.jpg",
                quantite = "20g",
                nutriscores = "E"

            ),
            Product(
                nom = "Nom du produit 1",
                marque = "Marque du produit",
                list_additif = "aucune",
                code_barres = "029388383838",
                list_ingredients = listOf("Ingr1", "Ingr2"),
                list_pays_vendu = "France",
                list_substance = "Aucune",
                url_image = "https://www.aprifel.com/wp-content/uploads/2019/02/carotte.jpg",
                quantite = "20g",
                nutriscores = "F"

            ),
            Product(
                nom = "Nom du produit 1",
                marque = "Marque du produit",
                list_additif = "aucune",
                code_barres = "029388383838",
                list_ingredients = listOf("Ingr1", "Ingr2"),
                list_pays_vendu = "France",
                list_substance = "Aucune",
                url_image = "https://www.aprifel.com/wp-content/uploads/2019/02/carotte.jpg",
                quantite = "20g",
                nutriscores = "F"

            )
        )

        binding.recyclerView.layoutManager = LinearLayoutManager(requireActivity())
        binding.recyclerView.adapter =
            ProductsListAdapter(products, this)

    }

    override fun onProductClicked(product: Product) {
        findNavController().navigate(
            ProductsListFragmentDirections.actionProductsListFragmentToProductDetailsFragment(
                product
            )
        )
    }
}


// Adapter = que dois-je afficher ?
class ProductsListAdapter(val products: List<Product>, val callback: OnProductItemClicked) : RecyclerView.Adapter<ProductViewHolder>() {

    // Combien y a-t-il d'éléments dans la liste
    override fun getItemCount(): Int {
        return products.size
    }

    // Comment créer 1 cellule
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // Donner le XML
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context))
        return ProductViewHolder(binding)
    }

    // Que faut-il afficher à la position [position]
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        products[position].let { product ->
            holder.bindProduct(product, position)
            holder.itemView.setOnClickListener {
                callback.onProductClicked(product)
            }
        }
    }

    interface OnProductItemClicked {
        fun onProductClicked(product: Product)
    }
}

// 1 cellule
class ProductViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindProduct(product: Product, position: Int) {
        binding.TPois.text = product.nom
        binding.subTitle.text = product.marque
        binding.tcodebar.text = product.code_barres
        binding.tvendu.text = product.list_pays_vendu
        binding.tingredient.text = product.list_ingredients.joinToString(" , ")
        binding.tsubstances.text = product.list_substance
        binding.tadditifs.text = product.list_additif

    }

}

