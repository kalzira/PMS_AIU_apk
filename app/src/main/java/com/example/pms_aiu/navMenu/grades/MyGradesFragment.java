package com.example.pms_aiu.navMenu.grades;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.pms_aiu.R;
import com.example.pms_aiu.navMenu.news.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class MyGradesFragment extends Fragment {





    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_my_grades, container, false);

//
//        Spinner spinner = root.findViewById(R.id.spinner_grades);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.yearAndTerm,
//                android.R.layout.simple_spinner_item);

        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        return root;
    }


}