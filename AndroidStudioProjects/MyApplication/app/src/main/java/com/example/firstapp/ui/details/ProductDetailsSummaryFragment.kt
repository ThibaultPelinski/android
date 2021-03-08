package com.example.firstapp.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.firstapp.model.Product
import com.example.firstapp.model.ServerResponse
import com.example.firstapp.databinding.ProductDetailsSummaryFragmentBinding


class ProductDetailsSummaryFragment : Fragment() {

    private lateinit var binding: ProductDetailsSummaryFragmentBinding

    // Equivalent du setContentView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ProductDetailsSummaryFragmentBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val barcode = ProductDetailsFragmentArgs.fromBundle(requireArguments()).barcode

        binding.TPois.text = barcode.nom
        binding.subTitle.text = barcode.marque
        binding.tcodebar.text = barcode.code_barres
        binding.tvendu.text = barcode.list_pays_vendu
        binding.tingredient.text = barcode.list_ingredients.joinToString(" , ")
        binding.tsubstances.text = barcode.list_substance
        binding.tadditifs.text = barcode.list_additif

        Glide.with(this)
            .load(barcode.url_image)
            .into(binding.plat)
    }
}