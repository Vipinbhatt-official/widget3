package com.example.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.widget.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

class Fragment2 extends Fragment {
    private MyFragmentAListener listener;
    private EditText e;
    private Button b;

    public void updateEditTextofFragmentB(CharSequence c) {
    }

    public interface MyFragmentAListener {
        void onInputASent(CharSequence c);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment1, container,false);
        e = v.findViewById(R.id.textViewf2);

        return v;
    }

    public  void updateEditTextofFragmentA(CharSequence newdata){
        e.setText(newdata);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof MyFragmentAListener){
            listener = (MyFragmentAListener) context;
        }else{
            throw new RuntimeException(context.toString()+"Your activity should implement the interface of Fragment2");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
}