package com.sujanmaharjan008.simpleapp.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sujanmaharjan008.simpleapp.R;
import com.sujanmaharjan008.simpleapp.model.UserLogin;
import com.sujanmaharjan008.simpleapp.model.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RegistrationFragment extends Fragment implements View.OnClickListener {
    EditText edtUsername, edtPassword, edtCPassword;
    Button btnRegistration;
    String password, username;
    static List<Users> user = new ArrayList<Users>();

    public RegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_registration_layout, container, false);
        edtUsername = view.findViewById(R.id.edtUsernameR);
        edtPassword = view.findViewById(R.id.edtPasswordR);
        edtCPassword = view.findViewById(R.id.edtCPasswordR);
        btnRegistration = view.findViewById(R.id.btnRegistration);

        btnRegistration.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {

        if (TextUtils.isEmpty(edtUsername.getText().toString())) {
            edtUsername.setError("Enter your Username");
            return;
        } else if (TextUtils.isEmpty(edtPassword.getText().toString())) {
            edtPassword.setError("Enter your password");
            return;
        } else if (TextUtils.isEmpty(edtCPassword.getText().toString())) {
            edtCPassword.setError("Confirm your password");
            return;
        }
        if (edtPassword.getText().toString().equals(edtCPassword.getText().toString())) {
            password = edtPassword.getText().toString();
            Users users = new Users();
            users.setUsername(edtUsername.getText().toString());
            users.setPassword(edtPassword.getText().toString());
            user.add(users);

            UserLogin userLogin = new UserLogin();
            userLogin.setUsersList(user);

            for (int i = 0; i < userLogin.getUsersList().size(); i++) {
                final Users user = userLogin.getUsersList().get(i);
                Toast.makeText(getActivity(), "" + user.getUsername() + " has been registered.", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(getActivity(), "Passwords do not match", Toast.LENGTH_LONG).show();
        }
    }
}
