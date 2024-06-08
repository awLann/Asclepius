package com.dicoding.asclepius.view

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.asclepius.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    private lateinit var imageUri: Uri

    private var resultThreshold: String? = null
    private var resultCategory: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getImageUri()
        getResult()
    }

    private fun getImageUri() {
        imageUri = Uri.parse(intent.getStringExtra(EXTRA_IMAGE_URI))
        imageUri.let { binding.resultImage.setImageURI(it) }
    }

    private fun getResult() {
        resultThreshold = intent.getStringExtra(EXTRA_RESULT_THRESHOLD)
        resultCategory = intent.getStringExtra(EXTRA_RESULT_CATEGORY)

        binding.resultThreshold.text = resultThreshold
        binding.resultCategory.text = resultCategory
    }

    companion object {
        const val EXTRA_IMAGE_URI = "extra_image_uri"
        const val EXTRA_RESULT_THRESHOLD = "extra_result_threshold"
        const val EXTRA_RESULT_CATEGORY = "extra_result_category"
    }
}