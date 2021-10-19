package com.example.alp.ui.notuploaded;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alp.R;
import com.example.alp.adapter.NotUploadedStandarAdapter;
import com.example.alp.adapter.UnfinishedStandarAdapter;
import com.example.alp.model.NotUploadedStandar;
import com.example.alp.model.UnfinishedStandar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NotuploadedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NotuploadedFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<NotUploadedStandar> list;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NotuploadedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NotuploadedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NotuploadedFragment newInstance(String param1, String param2) {
        NotuploadedFragment fragment = new NotuploadedFragment();
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
        list.add(new NotUploadedStandar("Nama Gallery Not Uploaded 1","Alamat Not Uploaded Gallery 1", "Kota Not Uploaded Not Uploaded Gallery 1","1"));
        list.add(new NotUploadedStandar("Nama Gallery Not Uploaded 2","Alamat Not Uploaded Gallery 2", "Kota Not Uploaded Not Uploaded Gallery 2","2"));
        list.add(new NotUploadedStandar("Nama Gallery Not Uploaded 3","Alamat Not Uploaded Gallery 3", "Kota Not Uploaded Not Uploaded Gallery 3","3"));
        list.add(new NotUploadedStandar("Nama Gallery Not Uploaded 4","Alamat Not Uploaded Gallery 4", "Kota Not Uploaded Not Uploaded Gallery 4","4"));
        list.add(new NotUploadedStandar("Nama Gallery Not Uploaded 5","Alamat Not Uploaded Gallery 5", "Kota Not Uploaded Not Uploaded Gallery 5","5"));
        list.add(new NotUploadedStandar("Nama Gallery Not Uploaded 6","Alamat Not Uploaded Gallery 6", "Kota Not Uploaded Not Uploaded Gallery 1","6"));
        list.add(new NotUploadedStandar("Nama Gallery Not Uploaded 7","Alamat Not Uploaded Gallery 7", "Kota Not Uploaded Not Uploaded Gallery 2","7"));
        list.add(new NotUploadedStandar("Nama Gallery Not Uploaded 8","Alamat Not Uploaded Gallery 8", "Kota Not Uploaded Not Uploaded Gallery 3","8"));
        list.add(new NotUploadedStandar("Nama Gallery Not Uploaded 9","Alamat Not Uploaded Gallery 9", "Kota Not Uploaded Not Uploaded Gallery 4","9"));
        list.add(new NotUploadedStandar("Nama Gallery Not Uploaded 10","Alamat Not Uploaded Gallery 10", "Kota Not Uploaded Not Uploaded Gallery 5","10"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_notuploaded, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        NotUploadedStandarAdapter notUploadedStandarAdapter = new NotUploadedStandarAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(notUploadedStandarAdapter);
        return view;
    }
}