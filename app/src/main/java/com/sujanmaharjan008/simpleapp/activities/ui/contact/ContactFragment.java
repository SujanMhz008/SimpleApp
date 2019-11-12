package com.sujanmaharjan008.simpleapp.activities.ui.contact;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sujanmaharjan008.simpleapp.R;
import com.sujanmaharjan008.simpleapp.adapter.ContactsAdapter;
import com.sujanmaharjan008.simpleapp.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactFragment extends Fragment {

    private RecyclerView recyclerView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact, container, false);
        recyclerView = root.findViewById(R.id.recyclerView);

        List<Contacts> contactsList = new ArrayList<>();

        contactsList.add(new Contacts("Bibek Dhami","9865203584", R.drawable.noimage));
        contactsList.add(new Contacts("Manish Dhami","9875125632", R.drawable.noimage));
        contactsList.add(new Contacts("Manish Khadka","9865868521", R.drawable.noimage));
        contactsList.add(new Contacts("Rohan Sharma","9861254864", R.drawable.noimage));
        contactsList.add(new Contacts("Rest","45868585989785", R.drawable.noimage));

        ContactsAdapter contactsAdapter = new ContactsAdapter(getActivity(), contactsList);
        recyclerView.setAdapter(contactsAdapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return root;
    }
}