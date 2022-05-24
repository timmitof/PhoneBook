package com.timmitof.phonebook.views.mainActivity

import android.Manifest
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.timmitof.phonebook.databinding.ActivityMainBinding
import com.timmitof.phonebook.presenters.mainActivity.IAddContactPresenters

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var presenters: IAddContactPresenters
    lateinit var photoProfile: ImageView
    private val REQUEST_CODE = 100
    private var imageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        requestPermissions()
//        presenters = MainActivityPresenters(this)
//        binding.addContactBtn.setOnClickListener {
//            presenters.fabOnClick()
//        }
//        setRecyclerView()
    }
//
//    override fun setRecyclerView() {
//        val users = App.instance?.getDatabase()?.PhoneNumberDao()?.getAllPhoneNumbers()
//        val recyclerView = binding.contactsRecyclerView
//        recyclerView.adapter = users?.let { ContactAdapter(it) }
//    }
//
//    override fun setAlertDialog(){
//        val alert = AlertDialog.Builder(this)
//        val inflater = layoutInflater.inflate(R.layout.add_contact_dialog, null)
//        alert.setView(inflater)
//        val name: EditText = inflater.findViewById(R.id.name)
//        val phoneNumber: EditText = inflater.findViewById(R.id.phoneNumber)
//        photoProfile = inflater.findViewById(R.id.user_photo)
//        val addBtn: Button = inflater.findViewById(R.id.addBtn)
//        val closeBtn: Button = inflater.findViewById(R.id.closeBtn)
//        val dialog = alert.create()
//
//        closeBtn.setOnClickListener {
//            dialog.dismiss()
//        }
//
//        addBtn.setOnClickListener {
//            presenters.addContact(
//                name = name.text.toString(),
//                phoneNumber = phoneNumber.text.toString(),
//                photo = imageUri.toString()
//            )
//            Log.d("ADDD", "${App.instance?.getDatabase()?.PhoneNumberDao()?.getAllPhoneNumbers()}")
//            dialog.dismiss()
//        }
//        dialog.show()
//    }
//
    fun requestPermissions() {
        val requestPermissionLauncher =
            registerForActivityResult(
                ActivityResultContracts.RequestPermission()
            ) { isGranted: Boolean ->
                if (isGranted) {
                    Toast.makeText(this, "Права получены", Toast.LENGTH_SHORT).show()
                } else {
                    ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 1234)
                }
            }
        requestPermissionLauncher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
    }

//    private fun openGallery() = CoroutineScope(Dispatchers.Main).launch {
//        val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            if (result.resultCode == Activity.RESULT_OK) {
//                val data = result.data
//                photoProfile.setImageURI(data?.data)
//            }
//        }
//        val intent = Intent()
//        intent.type = "image/*"
//        intent.action = Intent.ACTION_GET_CONTENT
//        resultLauncher.launch(intent)
//    }
}