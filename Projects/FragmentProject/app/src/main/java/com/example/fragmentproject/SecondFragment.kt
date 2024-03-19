package com.example.fragmentproject

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentproject.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    //BOOK STATED THIS IS ADDED AUTOMATICALLY BUT I DID NOT SEE THAT AS THE CASE
    //I ALSO DID NOT SEE THAT IT IS NEEDED AS I REMOVED IT AND IT WAS FINE.
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_second, container, false)
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        arguments?.let {
            //val args = SecondFragmentArgs.fromBundle(it)
            //binding.argsText.text = args.message
            //Log.i("zzz",args.message1)
            val args = SecondFragmentArgs.fromBundle(it)
            binding.argsText.text = args.title
            binding.imageView.setImageResource(args.image)

        }
    }

}

