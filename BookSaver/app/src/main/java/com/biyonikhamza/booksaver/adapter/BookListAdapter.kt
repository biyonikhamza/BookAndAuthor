package com.biyonikhamza.booksaver.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.biyonikhamza.booksaver.R
import com.biyonikhamza.booksaver.databinding.RecyclerListDesignBinding
import com.biyonikhamza.booksaver.model.BookAndAuthor
import com.biyonikhamza.booksaver.view.fragment.BookListFragmentDirections

class BookListAdapter(val bookAndAuthorList : ArrayList<BookAndAuthor> ) : RecyclerView.Adapter<BookListAdapter.BookSaverViewHolder>() {

    class BookSaverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var binding = RecyclerListDesignBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookSaverViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_list_design , parent,false)
        return BookSaverViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookSaverViewHolder, position: Int) {
        val booksAuthor = bookAndAuthorList[position]
        holder.binding.bookNameRecycler.text = booksAuthor.book
        holder.binding.autherNameRecycler.text = booksAuthor.author
        // Görsel eklenecek inşaAllah

        holder.itemView.setOnClickListener {
            val action = BookListFragmentDirections.actionBookListFragmentToBookDetailFragment()
            Navigation.findNavController(it).navigate(action)
        }

    }
    fun booksListUpdate(newBookList : List<BookAndAuthor>){
        bookAndAuthorList.clear()
        bookAndAuthorList.addAll(newBookList)
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = bookAndAuthorList.size
}