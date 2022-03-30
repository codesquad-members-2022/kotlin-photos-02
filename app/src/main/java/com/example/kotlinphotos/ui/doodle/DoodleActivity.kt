package com.example.kotlinphotos.ui.doodle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.kotlinphotos.R
import com.example.kotlinphotos.databinding.ActivityDoodleBinding
import com.example.kotlinphotos.ui.common.PhotosDiffCallback

class DoodleActivity : AppCompatActivity(), Clickable {

    private lateinit var binding: ActivityDoodleBinding

    private val viewModel: DoodleViewModel by viewModels { DoodleViewModelFactory(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_doodle)
        binding.imageButtonBack.setOnClickListener { finish() }
        setRecyclerView()
    }

    private fun setRecyclerView() {
        val doodleAdapter = DoodleAdapter(PhotosDiffCallback(), this, object : OnSaveListener {
            override fun showSaveButton() {
                binding.imageButtonSave.visibility = View.VISIBLE
            }
        })
        binding.recyclerviewDoodle.adapter = doodleAdapter
        binding.recyclerviewDoodle.layoutManager = GridLayoutManager(this, 3)
        viewModel.photos.observe(this) { doodleAdapter.submitList(it) }
    }

    override fun onLongClick() {
        viewModel.updateEditMode()
    }

    override fun onClick(position: Int) {
        viewModel.check(position)
    }

}