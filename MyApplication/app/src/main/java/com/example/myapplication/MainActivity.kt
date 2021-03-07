package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.databinding.DetailsTabSummaryBinding
import com.example.myapplication.databinding.ListBinding
import com.example.myapplication.databinding.ListItemBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Utiliser le layout nutritional_facts
        //var binding = NutritionalFactsBinding.inflate(layoutInflater)
        var binding2 = DetailsTabSummaryBinding.inflate(layoutInflater)
       // val binding = ListBinding.inflate(layoutInflater)
        //val view = binding.root
        //setContentView(view)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<ProductDetailsFragment>(R.id.container_view)
            }
        }




        // setContentView(ActivityMainBinding.inflate(layoutInflater).root)

        //   val products = listOf(
        //  Product(
        //      name = "Petit pois et carottes ",
        //      brand = "Cassegrain",
        //      nutriscore = "Nutriscore : A",
        // //      kcal = "234 kCal / Part"
        //),
        //  Product(
        //      name = "Petit pois et carottes ",
        // //      brand = "Cassegrain",
        //   nutriscore = "Nutriscore : A",
        //      kcal = "234 kCal / Part"
        //
        //  ),
        //  Product(
        //      name = "Petit pois et carottes ",
        //      brand = "Cassegrain",
        //      nutriscore = "Nutriscore : A",
        //      kcal = "234 kCal / Part"
        //
        //  ),
        //  Product(
        //      name = "Petit pois et carottes",
        // //      brand = "Cassegrain",
        //   nutriscore = "Nutriscore : A",
        //      kcal = "234 kCal / Part"
        //
        //  ),
        //
        //  Product(
        //      name = "Petit pois et carottes ",
        // //      brand = "Cassegrain",
        //   nutriscore = "Nutriscore : A",
        //      kcal = "234 kCal / Part"
        //
        //  ),
        //
        //  Product(
        //      name = "Petit pois et carottes ",
        //      brand = "Cassegrain",
        //      nutriscore = "Nutriscore : A",
        // //      kcal = "234 kCal / Part"
        //
        //  ),
        //)
        //binding.recyclerView.layoutManager = LinearLayoutManager(this)
        //binding.recyclerView.adapter = ListAdapter(products)
         }
}

// Adapter = que dois-je afficher ?
class ListAdapter(val products: List<Product>) : RecyclerView.Adapter<ProductViewHolder>() {

    // Combien y a-t-il d'éléments dans la liste
    override fun getItemCount(): Int {
        return products.size
    }

    // Comment créer 1 cellule
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        // Donner le XML
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductViewHolder(binding)
    }

    // Que faut-il afficher à la position [position]
    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindProduct(products[position], position)
    }

}

// 1 cellule
class ProductViewHolder(val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindProduct(product: Product, position: Int) {
        binding.productTitle.text = product.name
        binding.productBrand.text = product.brand
        binding.productNutriscore.text = product.nutriscore
       binding.productKcal.text = product.kcal

    }


    val product = ProductDetails(
        //   name = "Petit pois et carottes",
        //  brand = "Cassegrain",
        //  ingredients = listOf(
        //     "Petits pois 66%",
        //      "eau",
        //     "garniture 2.8%(salade, oignon grelot) ",
        //     "sucre",
        //      "sel",
        //      "arôme naturel"
        //   ),
        //   barres = "Code barres : 3083680085304",
        //   quantité = "Quantité : 400 g (280 g net égoutté)",
        //    vendu = "Vendu en : France, Japon, Suisse",
        //   url = "https://static.openfoodfacts.org/images/products/308/368/008/5304/front_fr.7.400.jpg",
        //    substance = "Substances allergènes : Aucune",
        //   additifs = "Additifs : Aucun"
    )

    //     binding2.name.text = product.name
    //     binding.brand.text = product.brand
    //    binding.barres.text = product.barres
    //    binding.quantites.text = product.quantité
    //    binding.url.text = product.url
    //     binding.vendu.text = product.vendu
    //    binding.substance.text = product.substance
    //     binding.additfs.text = product.additifs


    //    binding.ingredient.text = product.ingredients.joinToString(", ")

        //     Glide.with(this)
//      .load("url")
    //     .into(binding.url)
//
//        // Récupérer nutritional_facts_item_fat
//         binding.nutritionalFactsItemFat.nutritionalFactsItemText.text = "0.8g de Matières grasses"
//        binding.nutritionalFactsItemGras.nutritionalFactsItemText.text = "0.1g d'acides gras"
//        binding.nutritionalFactsItemSugar.nutritionalFactsItemText.text = "5.2g de sucres"
//        binding.nutritionalFactsItemSalt.nutritionalFactsItemText.text = "0.75g de sel"
//
//        DrawableCompat.setTintList(binding.nutritionalFactsItemFat.nutritionalFactsItemIndicator.background,
//            ColorStateList.varueOf(ContextCompat.getColor(this, R.color.nutrient_level_low)))
//
//
//        DrawableCompat.setTintList(binding.nutritionalFactsItemGras.nutritionalFactsItemIndicator.background,
//            ColorStateList.varueOf(ContextCompat.getColor(this, R.color.nutrient_level_low)))
//
//
//        DrawableCompat.setTintList(binding.nutritionalFactsItemSugar.nutritionalFactsItemIndicator.background,
//            ColorStateList.varueOf(ContextCompat.getColor(this, R.color.nutrient_level_moderate)))
//
//
//        DrawableCompat.setTintList(binding.nutritionalFactsItemSalt.nutritionalFactsItemIndicator.background,
//            ColorStateList.varueOf(ContextCompat.getColor(this, R.color.nutrient_level_high)))


}
