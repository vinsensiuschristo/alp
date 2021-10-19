package com.example.alp.ui.uploaded;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alp.R;
import com.example.alp.adapter.UnfinishedStandarAdapter;
import com.example.alp.adapter.UploadedStandarAdapter;
import com.example.alp.model.NotUploadedStandar;
import com.example.alp.model.UnfinishedStandar;
import com.example.alp.model.UploadedStandar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UploadedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UploadedFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<UploadedStandar> list;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UploadedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UploadedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UploadedFragment newInstance(String param1, String param2) {
        UploadedFragment fragment = new UploadedFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        list.add(new UploadedStandar("Nama Gallery Uploaded 1","Alamat Uploaded Gallery 1", "Kota Uploaded Gallery 1","1"));
        list.add(new UploadedStandar("Nama Gallery Uploaded 2","Alamat Uploaded Gallery 2", "Kota Uploaded Gallery 2","2"));
        list.add(new UploadedStandar("Nama Gallery Uploaded 3","Alamat Uploaded Gallery 3", "Kota Uploaded Gallery 3","3"));
        list.add(new UploadedStandar("Nama Gallery Uploaded 4","Alamat Uploaded Gallery 4", "Kota Uploaded Gallery 4","4"));
        list.add(new UploadedStandar("Nama Gallery Uploaded 5","Alamat Uploaded Gallery 5", "Kota Uploaded Gallery 5","5"));
        list.add(new UploadedStandar("Nama Gallery Uploaded 6","Alamat Uploaded Gallery 6", "Kota Uploaded Gallery 6","6"));
        list.add(new UploadedStandar("Nama Gallery Uploaded 7","Alamat Uploaded Gallery 7", "Kota Uploaded Gallery 7","7"));
        list.add(new UploadedStandar("Nama Gallery Uploaded 8","Alamat Uploaded Gallery 8", "Kota Uploaded Gallery 8","8"));
        list.add(new UploadedStandar("Nama Gallery Uploaded 9","Alamat Uploaded Gallery 9", "Kota Uploaded Gallery 9","9"));
        list.add(new UploadedStandar("Nama Gallery Uploaded 10","Alamat Uploaded Gallery 10", "Kota Uploaded Gallery 10","10"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_uploaded, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        UploadedStandarAdapter uploadedStandarAdapter = new UploadedStandarAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(uploadedStandarAdapter);
        return view;
    }
}