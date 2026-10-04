package com.example.tenantmanagementsystem

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.tenantmanagementsystem.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Make the SAVE button work (Part C & G combined)
        binding.saveButton.setOnClickListener {
            val name = binding.tenantNameEditText.text.toString().trim()
            val phone = binding.phoneEditText.text.toString().trim()
            val rent = binding.rentEditText.text.toString().trim()

            // Optional Validation from "Try it yourself"
            if (name.isEmpty()) {
                binding.tenantNameEditText.error = "Tenant name is required"
                return@setOnClickListener
            }

            // Create the Tenant object and bind it to the XML
            val tenant = Tenant(name, phone, rent)
            binding.tenant = tenant

            // Optional: Clear fields after saving
            binding.tenantNameEditText.text.clear()
            binding.phoneEditText.text.clear()
            binding.rentEditText.text.clear()
        }
    }
}