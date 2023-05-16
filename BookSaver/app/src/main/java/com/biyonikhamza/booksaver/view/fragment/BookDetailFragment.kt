package com.biyonikhamza.booksaver.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.Navigation
import com.biyonikhamza.booksaver.databinding.FragmentBookDetailBinding
import com.biyonikhamza.booksaver.databinding.FragmentBookListBinding
import com.biyonikhamza.booksaver.viewmodel.BookDetailViewModel

class BookDetailFragment : Fragment() {
    private lateinit var viewModel : BookDetailViewModel
    private var _binding : FragmentBookDetailBinding? = null
    private val binding get() = _binding
    private var bookId = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookDetailBinding.inflate(inflater , container , false)
        return binding!!.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(BookDetailViewModel::class.java)
        viewModel.getRoomData()

        observeLiveData()

    }

    fun observeLiveData(){
        viewModel.choosenBookModelTwo.observe(viewLifecycleOwner , Observer { detail ->
            detail?.let {
                with(_binding!!){
                    bookDetailName.text = it.bookName
                    bookDetailPage.text = it.bookPage.toString()
                    bookDetailAbout.text = it.about
                    bookDetailBookSKin.text = it.bookSkin
                }
            }
        })
    }

}