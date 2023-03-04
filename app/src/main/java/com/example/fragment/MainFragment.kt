package com.example.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.retrofit12.App
import com.example.retrofit12.CalculateModel
import com.example.retrofit12.R
import com.example.retrofit12.databinding.FragmentMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.calculate.setOnClickListener {
             getRequest()
        }
    }

    private fun getRequest() {
        App.api.getPercentage(binding.edMe.text.toString(), binding.dbEdit.text.toString()).enqueue(
            object : Callback<CalculateModel> {
                override fun onResponse(
                    call: Call<CalculateModel>,
                    response: Response<CalculateModel>
                ) {
//                    response.body()?.result
                   findNavController().navigate(R.id.resultFragment,
                   bundleOf(RESULT to response.body()?.result
                   , ED_ME to binding.edMe.text.toString(),
                   ED_YOU to binding.dbEdit.text.toString() )
                       )
                }
                override fun onFailure(call: Call<CalculateModel>, t: Throwable) {
                    Log.e("-------------erer", "${t.message}")
                }
            }
        )
    }

    companion object {
        const val RESULT = "key.result"
        const val ED_ME = "key.me"
        const val ED_YOU = "key.yuo"
    }
}

