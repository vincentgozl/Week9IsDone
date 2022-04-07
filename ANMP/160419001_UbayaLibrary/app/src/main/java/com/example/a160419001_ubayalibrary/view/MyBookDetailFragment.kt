package com.example.a160419001_ubayalibrary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.a160419001_ubayalibrary.R
import com.example.a160419001_ubayalibrary.Util.loadImage
import com.example.a160419001_ubayalibrary.viewModel.DetailViewModel
import com.example.a160419001_ubayalibrary.viewModel.MyDetailViewModel
import kotlinx.android.synthetic.main.fragment_detail_book.*
import kotlinx.android.synthetic.main.fragment_my_book_detail.*


/**
 * A simple [Fragment] subclass.
 * Use the [MyBookDetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyBookDetailFragment : Fragment() {
    private lateinit var viewModel: MyDetailViewModel
    private val myBookListAdapter = MyBookListAdapter(arrayListOf())
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_book_detail, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (arguments != null) {
            val myBookId = MyBookDetailFragmentArgs.fromBundle(requireArguments()).myBookId
            viewModel = ViewModelProvider(this).get(MyDetailViewModel::class.java)
            viewModel.fetch(myBookId)
        }

        buttonEditMyDetail.setOnClickListener {
            val action = MyBookDetailFragmentDirections.actionEditMyBook()
            Navigation.findNavController(it).navigate(action)
        }

        buttonBackMyDetail.setOnClickListener {
            val action = MyBookDetailFragmentDirections.actionDetailToMyItem()
            Navigation.findNavController(it).navigate(action)
        }

        observeViewModel()
    }

    fun observeViewModel() {
        viewModel.bookLDKud.observe(viewLifecycleOwner, {
            textIdMyBookDetail.setText(viewModel.bookLDKud.value?.id)
            textNamaMyBookDetail.setText(viewModel.bookLDKud.value?.judul)
            textSinopsisMyBookDetail.setText(viewModel.bookLDKud.value?.sinopsis)
            imageViewMyDetailBook.loadImage(viewModel.bookLDKud.value?.imageUrl.toString(), progressLoadMyDetail)
        })
    }
}