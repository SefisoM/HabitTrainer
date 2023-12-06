package com.example.habittrainer

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import com.example.habittrainer.databinding.ActivityCreateHabitBinding
import java.io.IOException

class createHabitActivity<Uri> : AppCompatActivity() {

    private lateinit var binding: ActivityCreateHabitBinding
    private val TAG = createHabitActivity::class.java
    private val CHOOSE_REQUEST_CODE = 1
    private var imageBitmap: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateHabitBinding.inflate(layoutInflater)
        setupUi()
        setContentView(binding.root)
    }

    private fun setupUi() {

    }

    fun chooseImage(v: View) {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT

        val chooser = Intent.createChooser(intent, "Choose image for habit")
        startActivityForResult(chooser, CHOOSE_REQUEST_CODE)

        Log.d(TAG.toString(), "Intent to choose image sent...")
    }

    //User choose an image from gallery
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == CHOOSE_REQUEST_CODE && resultCode == Activity.RESULT_OK && data != null && data.data != null){
            Log.d(TAG.toString(), "An image was chosen by the user")

            val bitmap = tryReadBitmap(data.data!!)

            bitmap?.let {
                this.imageBitmap = bitmap
                binding.previewImageview.setImageBitmap(bitmap)
                Log.d(TAG.toString(), "Read image bitmap and updated image view.")
            }
        }
    }

    private fun tryReadBitmap(data: android.net.Uri): Bitmap?{
        return try {
            MediaStore.Images.Media.getBitmap(contentResolver, data)
        }catch (e: IOException){
            e.printStackTrace()
            return null
        }
    }

    fun storeHabit(view: View) {
        if(binding.titleEditText.text.toString().isBlank() || binding.descriptionEditText.text.toString().isBlank()){
            Log.d(TAG.toString(), "No habit stored: title or description missing")
            displayError("Your habit needs title and description")
            return
        }else if (imageBitmap == null){
            Log.d(TAG.toString(), "No habit stored: image missing")
            displayError("Add a motivating picture to your habit")
            return
        }

        //store habit
        //binding.errorMessageTextview.visibility = View.GONE
    }

    private fun displayError(message: String) {
        with(binding.errorMessageTextview){
            text = message
            visibility = View.VISIBLE
        }
    }
}