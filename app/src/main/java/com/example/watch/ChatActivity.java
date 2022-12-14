package com.example.watch;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.watch.databinding.ActivityChatBinding;

public class ChatActivity extends Activity {

    private TextView mTextView;
    private ActivityChatBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityChatBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

    }
}