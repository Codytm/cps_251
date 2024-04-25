package com.example.contactproject

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.contactproject.databinding.ActivityMainBinding
import java.util.Locale

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var adapter: ContactListAdapter? = null
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenerSetup()
        observerSetup()
        recyclerSetup()
    }

    private fun clearFields() {
        binding.contactName.setText("")
        binding.contactPhone.setText("")
    }

    private fun listenerSetup() {
        binding.addBtn.setOnClickListener {
            val name = binding.contactName.text.toString()
            val number = binding.contactPhone.text.toString()

            if (name != "" && number != "") {
                val contact = Contact(name, number)
                viewModel.insertContact(contact)
                clearFields()
            } else {
                //binding.contactName.text = "Incomplete information"
            }
        }
        binding.findBtn.setOnClickListener {
            viewModel.findContact(
            binding.contactName.text.toString())
        }

        binding.ascBtn.setOnClickListener {
            viewModel.ascContacts()?.observe(this) { contacts ->
                contacts?.let {
                    adapter?.setContactList(it)
                }
            }
        }

        binding.descBtn.setOnClickListener {
            viewModel.descContacts()?.observe(this) { contacts ->
                contacts?.let {
                    adapter?.setContactList(it)
                }
            }
        }

//        binding.deleteBtn.setOnClickListener {
//            viewModel.deleteContact(binding.contactId.text.toString())
//            clearFields()
//        }
    }

    private fun recyclerSetup() {
        adapter = ContactListAdapter(R.layout.contact_list)
        binding.contactRecycler.layoutManager = LinearLayoutManager(this)
        binding.contactRecycler.adapter = adapter
    }

    private fun observerSetup() {
        viewModel.getAllContacts()?.observe(this) { contacts ->
            contacts?.let {
                adapter?.setContactList(it)
            }
        }
        viewModel.getSearchResults().observe(this) { products ->
            products?.let {
                if (it.isNotEmpty()) {
                    binding.contactName.setText(it[0].contactName)
                    binding.contactPhone.setText(
                        String.format(
                            Locale.US, "%d",
                            it[0].contactPhone
                        )
                    )
                } else {
                    //binding.contactName.text = "No Match"
                }
            }
        }
    }

}