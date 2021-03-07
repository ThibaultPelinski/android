package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.ListBinding

class ProductDetailsFragment : Fragment() {

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
            Product(
                name = "Petit pois et carottes ",
                brand = "Cassegrain",
                nutriscore = "Nutriscore : A",
                kcal = "234 kCal / Part"
            ),
            Product(
                name = "Petit pois et carottes ",
                brand = "Cassegrain",
                nutriscore = "Nutriscore : A",
                kcal = "234 kCal / Part"

            ),
            Product(
                name = "Petit pois et carottes ",
                brand = "Cassegrain",
                nutriscore = "Nutriscore : A",
                kcal = "234 kCal / Part"

            ),
            Product(
                name = "Petit pois et carottes",
                brand = "Cassegrain",
                nutriscore = "Nutriscore : A",
                kcal = "234 kCal / Part"

            ),

            Product(
                name = "Petit pois et carottes ",
                brand = "Cassegrain",
                nutriscore = "Nutriscore : A",
                kcal = "234 kCal / Part"

            ),

            Product(
                name = "Petit pois et carottes ",
                brand = "Cassegrain",
                nutriscore = "Nutriscore : A",
                kcal = "234 kCal / Part"

            ),
        )


    }
}