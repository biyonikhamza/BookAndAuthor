package com.biyonikhamza.booksaver.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.biyonikhamza.booksaver.model.BookAndAuthor

class BookListViewModel : ViewModel() {

    val booksAndAuthor = MutableLiveData<List<BookAndAuthor?>>()
    val alertMessage = MutableLiveData<Boolean>()
    val booksLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        val homosapiens = BookAndAuthor("Homo Sapiens" , "Yuval noah harari" , "www.sapiens.com")
        val homodeus = BookAndAuthor("Homo Deus" , "Yuval noah harari" , "www.sapiens.com")
        val godofwar = BookAndAuthor("God of war" , "Jhon barlock" , "www.kratos.com")

        val bookList = arrayListOf<BookAndAuthor>(homosapiens , homodeus , godofwar)

        booksAndAuthor.value = bookList
        alertMessage.value = false
        booksLoading.value = false

    }

}