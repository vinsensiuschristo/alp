package com.example.alp.ui.unfinished;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alp.R;
import com.example.alp.adapter.UnfinishedStandarAdapter;
import com.example.alp.model.UnfinishedStandar;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link UnfinishedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class UnfinishedFragment extends Fragment {

    View view;
    private RecyclerView recyclerView;
    private List<UnfinishedStandar> list;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public UnfinishedFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment UnfinishedFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static UnfinishedFragment newInstance(String param1, String param2) {
        UnfinishedFragment fragment = new UnfinishedFragment();
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
        list.add(new UnfinishedStandar("Nama Gallery 1","Alamat Gallery 1", "Kota Gallery 1","1"));
        list.add(new UnfinishedStandar("Nama Gallery 2","Alamat Gallery 2", "Kota Gallery 2","2"));
        list.add(new UnfinishedStandar("Nama Gallery 3","Alamat Gallery 3", "Kota Gallery 3","3"));
        list.add(new UnfinishedStandar("Nama Gallery 4","Alamat Gallery 4", "Kota Gallery 4","4"));
        list.add(new UnfinishedStandar("Nama Gallery 5","Alamat Gallery 5", "Kota Gallery 5","5"));
        list.add(new UnfinishedStandar("Nama Gallery 1","Alamat Gallery 1", "Kota Gallery 1","1"));
        list.add(new UnfinishedStandar("Nama Gallery 2","Alamat Gallery 2", "Kota Gallery 2","2"));
        list.add(new UnfinishedStandar("Nama Gallery 3","Alamat Gallery 3", "Kota Gallery 3","3"));
        list.add(new UnfinishedStandar("Nama Gallery 4","Alamat Gallery 4", "Kota Gallery 4","4"));
        list.add(new UnfinishedStandar("Nama Gallery 5","Alamat Gallery 5", "Kota Gallery 5","5"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_unfinished, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        UnfinishedStandarAdapter unfinishedStandarAdapter = new UnfinishedStandarAdapter(getContext(),list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(unfinishedStandarAdapter);
        return view;
    }
}