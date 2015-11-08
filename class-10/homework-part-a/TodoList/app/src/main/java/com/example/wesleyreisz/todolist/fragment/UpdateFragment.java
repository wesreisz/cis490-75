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
import com.example.wesleyreisz.todolist.model.Task;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;

/**
 * A simple {@link Fragment} subclass.
 */
public class UpdateFragment extends Fragment {
    private TextView txtName;
    private TextView txtDescription;

    private String name;
    private String description;

    private Button btnUpdate;
    private Button btnDelete;
    private Button btnBack;
    private String objectId;

    public UpdateFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update, container, false);

        txtName = (TextView) view.findViewById(R.id.txtName);
        txtDescription = (TextView) view.findViewById(R.id.txtDescription);

        ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
        query.getInBackground(objectId, new GetCallback<ParseObject>() {
            public void done(ParseObject task, ParseException e) {
                if (e == null) {
                    name = task.getString("name");
                    txtName.setText(name);

                    description = task.getString("description");
                    txtDescription.setText(description);

                } else {
                    Toast.makeText(getActivity(),
                            "Something went wrong",
                            Toast.LENGTH_LONG).show();
                }
            }
        });


        btnUpdate = (Button) view.findViewById(R.id.btnUpdate);
        btnUpdate.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                name = txtName.getText().toString();
                description = txtDescription.getText().toString();

                if (name.equals("") && description.equals("")) {
                    Toast.makeText(getActivity(),
                            "Please enter name and description",
                            Toast.LENGTH_LONG).show();

                } else {
                    ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");

                    query.getInBackground(objectId, new GetCallback<ParseObject>() {
                        public void done(ParseObject task, ParseException e) {
                            if (e == null) {
                                task.put("name", name);
                                task.put("description", description);
                                task.saveInBackground();

                                FragmentManager fragmentManager = getFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.fragmentContainer, new TaskListFragment());
                                fragmentTransaction.commit();
                            } else {
                                Toast.makeText(getActivity(),
                                        "Something went wrong",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });


                }

            }
        });

        btnDelete = (Button) view.findViewById(R.id.btnDelete);
        btnDelete.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                ParseQuery<ParseObject> query = ParseQuery.getQuery("Task");
                query.getInBackground(objectId, new GetCallback<ParseObject>() {
                    public void done(ParseObject task, ParseException e) {
                        if (e == null) {

                            try {
                                task.delete();

                                //wait for delete then load fragment maanager
                                FragmentManager fragmentManager = getFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.fragmentContainer, new TaskListFragment());
                                fragmentTransaction.commit();
                            } catch (ParseException e1) {
                                e1.printStackTrace();
                            }
                        } else {
                            Toast.makeText(getActivity(),
                                    "Something went wrong",
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });

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

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }
}
