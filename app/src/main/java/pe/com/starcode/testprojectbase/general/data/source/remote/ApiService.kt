package pe.com.starcode.testprojectbase.general.data.source.remote

import io.reactivex.rxjava3.core.Single
import pe.com.starcode.testprojectbase.general.data.source.remote.dto.movies.ListMoviesResDTO
import retrofit2.http.GET

interface ApiService {

    @GET("movies")
    fun getMovies(): Single<ListMoviesResDTO>
}