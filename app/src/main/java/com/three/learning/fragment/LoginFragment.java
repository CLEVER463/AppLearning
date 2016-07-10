package com.three.learning.fragment;


import android.content.res.Resources;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.three.learning.MainActivity;
import com.three.learning.Person;
import com.three.learning.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private static String[] grade = {"1", "2", "3", "book4"};
    private Person person;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Resources res = getResources();
        String[] major = res.getStringArray(R.array.major);
        View view = inflater.inflate(R.layout.login_layout, container, false);
        Spinner majorSp = (Spinner) view.findViewById(R.id.major);
        Spinner gradeSp = (Spinner) view.findViewById(R.id.grade);
        ArrayAdapter<String> majorAdp = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,major);
        ArrayAdapter<String> gradeAdp = new ArrayAdapter<String>(getActivity(),R.layout.support_simple_spinner_dropdown_item,grade);
        majorSp.setAdapter(majorAdp);
        gradeSp.setAdapter(gradeAdp);
        majorSp.setTag("major");
        gradeSp.setTag("grade");
        majorSp.setOnItemSelectedListener(this);
        gradeSp.setOnItemSelectedListener(this);
        person = new Person();
        view.findViewById(R.id.confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),person.toString(),Toast.LENGTH_SHORT).show();
                getFragmentManager().beginTransaction()
                        .addToBackStack("bookme")
                        .detach(getFragmentManager().findFragmentByTag("login"))
                        .add(R.id.placeholder,new BookOrMe())
                        .commit();
            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String tag = (String)parent.getTag();
        switch (tag){
            case "major":
                person.setMajor((String)parent.getItemAtPosition(position));
                break;
            case "grade":
                person.setGrade((String)parent.getItemAtPosition(position));
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
