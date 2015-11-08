package com.example.wesleyreisz.todolist.fragment;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wesleyreisz.todolist.R;
import com.parse.ParseObject;

/**
 * A simple {@link Fragment} subclass.
 */
public class CreateFragment extends Fragment {
    private TextView txtName;
    private TextView txtDescription;
    private String name;
    private String description;
    private Button btnCreate;
    private Button btnBack;

    public CreateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create, container, false);

        txtName = (TextView) view.findViewById(R.id.txtName);
        txtDescription = (TextView) view.findViewById(R.id.txtDescription);

        btnCreate = (Button) view.findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                name = txtName.getText().toString();
                description = txtDescription.getText().toString();

                if (name.equals("") && description.equals("")) {
                    Toast.makeText(getActivity().getApplicationContext(),
                            "Please enter name and description",
                            Toast.LENGTH_LONG).show();

                } else {
                    ParseObject task = new ParseObject("Task");
                    task.put("name", name);
                    task.put("description", description);
                    task.saveInBackground();

                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(R.id.fragmentContainer, new TaskListFragment());
                    fragmentTransaction.commit();
                }

            }
        });

        btnBack = (Button) view.findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmentContainer, new TaskListFragment());
                fragmentTransaction.commit();
            }
        });

        return view;
    }

}
