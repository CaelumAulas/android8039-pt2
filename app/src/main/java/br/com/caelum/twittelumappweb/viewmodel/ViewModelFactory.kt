package br.com.caelum.twittelumappweb.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import br.com.caelum.twittelumappweb.data.TweetRepository
import br.com.caelum.twittelumappweb.data.UsuarioRepository
import br.com.caelum.twittelumappweb.webservices.InicializadorDoRetrofit
import br.com.caelum.twittelumappweb.webservices.usuario.UsuarioWebClient

object ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    private fun getRetrofit() = InicializadorDoRetrofit.retrofit

    private fun getTweetRepository() = TweetRepository()

    private fun getUsuarioWebClient() = UsuarioWebClient(getRetrofit())
    private fun getUsuarioRepository() = UsuarioRepository(getUsuarioWebClient())

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T = when (modelClass) {
        TweetViewModel::class.java -> {
            TweetViewModel(getTweetRepository()) as T
        }
        else -> {
            UsuarioViewModel(getUsuarioRepository()) as T
        }
    }


}