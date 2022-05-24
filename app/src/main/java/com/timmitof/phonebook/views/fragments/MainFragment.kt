package com.timmitof.phonebook.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.timmitof.phonebook.App
import com.timmitof.phonebook.adapters.ContactAdapter
import com.timmitof.phonebook.databinding.FragmentMainBinding

class MainFragment : Fragment(), IMainFragmentView {
    var _binding: FragmentMainBinding? = null
    val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addContactBtn.setOnClickListener {
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToAddContactFragment())
        }
        setRecyclerView()
    }

    override fun setRecyclerView() {
        val users = App.instance?.getDatabase()?.PhoneNumberDao()?.getAllPhoneNumbers()
        val recyclerView = binding.contactsRecyclerView
        recyclerView.adapter = users?.let { ContactAdapter(it) }
    }
}