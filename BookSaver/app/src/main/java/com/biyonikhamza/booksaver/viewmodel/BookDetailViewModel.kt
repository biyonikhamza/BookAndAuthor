package com.biyonikhamza.booksaver.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.biyonikhamza.booksaver.model.BookAndAuthor
import com.biyonikhamza.booksaver.model.Contents

class BookDetailViewModel : ViewModel() {

    val choosenBookModelOne = MutableLiveData<BookAndAuthor>()
    val choosenBookModelTwo = MutableLiveData<Contents>()

    fun getRoomData(){
        val homosapiensContent = Contents(
            "Homo Sapiens",
            300,
            "Evrim teorisini esas almış ama bize uymuyor." ,
            " Ciltsiz")
        val homosapiens = BookAndAuthor(
            "Homo Sapiens",
            "Yuval noah harari",
            "www.sapiens.com")

        choosenBookModelOne.value = homosapiens
        choosenBookModelTwo.value = homosapiensContent
    }

}