package com.catata.masterdetailexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.catata.masterdetailexample.databinding.FragmentDetailBinding
import com.catata.masterdetailexample.extensions.setBitmapfromString
import com.catata.masterdetailexample.model.Superhero
const val ARG_HERO = "ARG_HERO_KEY"

class DetailFragment : Fragment() {
    private var superHeroId: Int? = null
    private var superHero: Superhero? = null

    private lateinit var binding: FragmentDetailBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            superHeroId = it.getInt(ARG_HERO,-1)
            superHero = Superhero.getSuperHeroById(superHeroId)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentDetailBinding.inflate(inflater,container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvSuperhero.text = superHero?.superhero
        binding.tvRealName.text  = superHero?.realName
        binding.tvDescription.text  = superHero?.description

        binding.ivPoster.setBitmapfromString(superHero?.photo?:"")

    }




    companion object {
        @JvmStatic
        fun newInstance(heroId: Int) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_HERO, heroId)
                }
            }
    }
}