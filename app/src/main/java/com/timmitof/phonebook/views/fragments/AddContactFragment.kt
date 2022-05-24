package com.timmitof.phonebook.views.fragments

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import com.timmitof.phonebook.databinding.FragmentAddContactBinding
import com.timmitof.phonebook.presenters.mainActivity.IAddContactPresenters
import com.timmitof.phonebook.presenters.mainActivity.AddContactPresenters

class AddContactFragment : Fragment(), IAddContactFragmentView {
    var _binding: FragmentAddContactBinding? = null
    val binding get() = _binding!!

    lateinit var presenters: IAddContactPresenters
    private var imageUri: Uri? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddContactBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenters = AddContactPresenters(this)

        binding.addBtn.setOnClickListener {
            presenters.addContact(
                name = binding.name.text.toString(),
                phoneNumber = binding.phoneNumber.text.toString(),
                photo = imageUri.toString()
            )
        }
        openGallery()
    }

    private fun openGallery() {
        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data = result.data
                binding.userPhoto.setImageURI(data?.data)
                imageUri = data?.data
            }
        }

        binding.userPhoto.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            resultLauncher.launch(intent)
        }
    }
}