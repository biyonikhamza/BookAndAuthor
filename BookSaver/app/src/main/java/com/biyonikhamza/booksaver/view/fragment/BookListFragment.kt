package com.biyonikhamza.booksaver.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.biyonikhamza.booksaver.adapter.BookListAdapter
import com.biyonikhamza.booksaver.databinding.FragmentBookListBinding
import com.biyonikhamza.booksaver.model.BookAndAuthor
import com.biyonikhamza.booksaver.viewmodel.BookListViewModel


class BookListFragment : Fragment() {
    private lateinit var viewModel : BookListViewModel
    private val adapter = BookListAdapter(arrayListOf())
    private var _binding : FragmentBookListBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBookListBinding.inflate(inflater , container , false)
        return binding!!.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(BookListViewModel::class.java)
        viewModel.refreshData()

        _binding!!.bookListRecycler.layoutManager = LinearLayoutManager(context)
        _binding!!.bookListRecycler.adapter = adapter

        observeLiveData()

    }

    fun observeLiveData(){
        viewModel.booksAndAuthor.observe(viewLifecycleOwner, Observer { booksAndAuth ->
            booksAndAuth?.let {
                _binding!!.bookListRecycler.visibility = View.VISIBLE
                adapter.booksListUpdate(booksAndAuth as List<BookAndAuthor>)
            }
        })
        viewModel.alertMessage.observe(viewLifecycleOwner, Observer { alertMesage ->
            alertMesage?.let {
                with(_binding!!){
                    if (it){
                        bookListAlertMessage.visibility = View.VISIBLE
                        bookListRecycler.visibility = View.GONE
                        bookListProgressBar.visibility = View.GONE
                    }
                    else{
                        bookListAlertMessage.visibility = View.GONE
                    }

                }
            }
        })
        viewModel.booksLoading.observe(viewLifecycleOwner, Observer { loadingBar ->
            loadingBar?.let {
                with(_binding!!){
                    if (it){
                        bookListProgressBar.visibility = View.VISIBLE
                        bookListRecycler.visibility = View.GONE
                        bookListAlertMessage.visibility = View.GONE
                    }
                    else{
                        bookListProgressBar.visibility = View.GONE
                    }
                }
            }
        })
    }
}