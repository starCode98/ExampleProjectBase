package pe.com.starcode.testprojectbase.movies.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.android.support.DaggerFragment
import pe.com.starcode.testprojectbase.databinding.FragmentMoviesBinding
import pe.com.starcode.testprojectbase.general.di.viewFactory.ViewModelFactory
import pe.com.starcode.testprojectbase.general.utils.DialogMessageHelper
import javax.inject.Inject

class MoviesFragment : DaggerFragment() {

    companion object {
        fun newInstance() = MoviesFragment()
    }

    private var helperDialog = DialogMessageHelper()

    @Inject
    lateinit var viewModelFactory: ViewModelFactory
    private val viewModel: MoviesVM by viewModels { viewModelFactory }

    private val binding: FragmentMoviesBinding by lazy {
        FragmentMoviesBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        helperDialog.messageDefaultDialog(
            title = "hola",
            message = "esta es una prueba",
            childFragmentManager = childFragmentManager
        )
        return binding.root
    }

}