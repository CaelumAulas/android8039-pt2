package br.com.caelum.twittelumappweb.fragment

import android.arch.lifecycle.ViewModelProviders
import br.com.caelum.twittelumappweb.modelo.Tweet
import br.com.caelum.twittelumappweb.viewmodel.TweetViewModel
import br.com.caelum.twittelumappweb.viewmodel.ViewModelFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MeuMapaFragment : SupportMapFragment() {

    private val tweetViewModel: TweetViewModel by lazy {
        ViewModelProviders.of(activity!!, ViewModelFactory).get(TweetViewModel::class.java)
    }

    override fun onResume() {
        super.onResume()
        getMapAsync { mapa: GoogleMap ->

            val tweets: List<Tweet> = tweetViewModel.lista().value!!

            tweets.forEach { tweet ->

                val latitude = tweet.latitude
                val longitude = tweet.longitude

                val marcador = MarkerOptions()

                marcador.position(LatLng(latitude, longitude))
                marcador.title(tweet.dono.nome)

                mapa.addMarker(marcador)

            }


        }
    }

}
