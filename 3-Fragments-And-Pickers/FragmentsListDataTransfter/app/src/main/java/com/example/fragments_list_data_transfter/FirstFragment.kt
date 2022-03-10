package com.example.fragments_list_data_transfter

import android.media.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    var AndroidOS = arrayOf(
        "Cupcake", "Donut", "Eclair", "Froye", "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "Jelly Bean", "Kitkat", "Lollipop", "Marshmallow", "Nougat", "Oreo"
    )

    var CardsOS= arrayOf(R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image4)

    lateinit var  lv : ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view : View = inflater.inflate(R.layout.fragment_first, container, false)
        lv = view.findViewById(R.id.lst) as ListView
        val arrayAdapter = ArrayAdapter(requireActivity(), android.R.layout.simple_list_item_1, AndroidOS)
        lv.setAdapter(arrayAdapter)
        lv.setOnItemClickListener { adapterView, view, i, l ->
            val txtFrag = parentFragmentManager.findFragmentById(R.id.fragment2) as SecondFragment
            txtFrag.changeImage(CardsOS[i % 4])
            txtFrag.change("Android OS : -" + AndroidOS[i])
            lv.setSelector(R.color.purple_200)
        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}