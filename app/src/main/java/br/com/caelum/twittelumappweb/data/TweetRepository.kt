package br.com.caelum.twittelumappweb.data

import br.com.caelum.twittelumappweb.modelo.Tweet

class TweetRepository {

    fun salva(tweet: Tweet) {}
    fun lista() = arrayListOf(Tweet("Ble"), Tweet("Blo"), Tweet("Blu"))


}