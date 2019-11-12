package com.sujanmaharjan008.simpleapp.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.speech.tts.TextToSpeech;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sujanmaharjan008.simpleapp.R;
import com.sujanmaharjan008.simpleapp.activities.MainActivity;
import com.sujanmaharjan008.simpleapp.activities.NavigationActivity;
import com.sujanmaharjan008.simpleapp.model.UserLogin;
import com.sujanmaharjan008.simpleapp.model.Users;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener {
    EditText edtUsername, edtPassword;
    Button btnLogin;
    String savedUsername, savedPassword;
    boolean status;

    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        edtUsername = view.findViewById(R.id.edtUsernameL);
        edtPassword = view.findViewById(R.id.edtPasswordL);
        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(this);
//        savedUsername = String.valueOf(getArguments().getString("username"));
//        savedPassword = String.valueOf(getArguments().getString("password"));

//        savedUsername = new Users().getUsername();
//        savedPassword = new Users().getPassword();

        return view;
    }

    @Override
    public void onClick(View v) {
        savedUsername = edtUsername.getText().toString();
        savedPassword = edtPassword.getText().toString();
        if(TextUtils.isEmpty(edtUsername.getText().toString())){
            edtUsername.setError("Enter your username");
            return;
        }
        else if(TextUtils.isEmpty(edtPassword.getText().toString())){
            edtPassword.setError("Enter your password");
        }

        UserLogin userLogin = new UserLogin();
        userLogin.setUsername(savedUsername);
        userLogin.setPassword(savedPassword);
        status = userLogin.testUser();

        if(status){

            Intent intent = new Intent(getActivity(), NavigationActivity.class);
            startActivity(intent);
            Toast.makeText(getActivity(), "Welcome " + savedUsername, Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getActivity(), "Login Credentials not correct", Toast.LENGTH_LONG).show();
        }

//        if (edtUsername.getText().toString().equals(savedUsername) && edtPassword.getText().toString().equals(savedPassword )){
//            Toast.makeText(getActivity(), "KEKW", Toast.LENGTH_SHORT).show();
//        }
//        else{
//            Toast.makeText(getActivity(), "Login Credentials not correct", Toast.LENGTH_LONG).show();
//        }
    }
}
