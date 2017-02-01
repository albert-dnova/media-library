package com.lasalle.second.part.medialibrary.view.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lasalle.second.part.medialibrary.R;

public class MainActivity extends AbstractActivity implements View.OnClickListener {

    private Button addButton;
    private Button listbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, R.layout.activity_main);

        addButton = (Button) findViewById(R.id.activity_main_add_button);
        listbutton = (Button) findViewById(R.id.activity_main_list_button);

        addButton.setOnClickListener(this);
        listbutton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == addButton.getId())
        {
            Intent intent = new Intent(this, AddItem.class);
            startActivity(intent);
        }
        else if(view.getId() == listbutton.getId())
        {

        }
    }
}
