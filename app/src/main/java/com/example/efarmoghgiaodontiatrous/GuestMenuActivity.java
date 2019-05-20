package com.example.efarmoghgiaodontiatrous;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.efarmoghgiaodontiatrous.domain.Dentist;
import com.example.efarmoghgiaodontiatrous.domain.Specialization;

import java.util.List;

public class GuestMenuActivity extends AppCompatActivity implements GuestMenuView{
    final int REQUEST_CODE_DENTIST_SEARCH=1;
    private GuestMenuPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        presenter= new GuestMenuPresenter(this);
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_guest_menu);
        List<Specialization> specializations=presenter.getSpecializations();
        String Specializations[]=new String[specializations.size()];
        for (int i=0;i<specializations.size();i++){
            Specializations[i]=specializations.get(i).getSpecializationName();
        }
        Spinner s = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, Specializations);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);
        findViewById(R.id.search_dentist_by_name).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String lastname=((EditText) findViewById(R.id.lastname)).getText().toString();
                String firstname=((EditText) findViewById(R.id.firstname)).getText().toString();
                presenter.searchbyname(lastname,firstname);
            }
        });
    }

    public void showError(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
    }

    public void showSearchView(String lastname, String firstname) {
        Intent intent = new Intent(this, DentistSearchActivity.class);
        intent.putExtra("lastname", lastname);
        intent.putExtra("firstname", firstname);
        startActivityForResult(intent,1);
    }


}
