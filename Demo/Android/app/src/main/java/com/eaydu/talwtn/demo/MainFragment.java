/*
 * Copyright 2022 Beijing TAL Technology Ltd. All Rights Reserved.
 * SPDX-license-identifier: BSD-3-Clause
 */
package com.eaydu.talwtn.demo;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;


import com.eaydu.talwtn.demo.databinding.FragmentMainBinding;
import com.eaydu.talwtn.demo.utils.CommonUtils;

public class MainFragment extends Fragment {

    public MainFragment() {
        super(R.layout.fragment_main);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentMainBinding binding = FragmentMainBinding.bind(view);

        // region "主页" 页面响应事件
        binding.tabMain.publish.setOnClickListener(v -> {

                    String pushStreamId = binding.tabMain.etPush.getText().toString();
                    Constants.PUSH_URL = CommonUtils.getPushUrl(pushStreamId);
                    Constants.PUSH_STREAMID = pushStreamId;
                    Navigation.findNavController(v)
                            .navigate(R.id.open_publish);
                }
                );
        binding.tabMain.subscribe.setOnClickListener(v -> {

                    String pullStreamId = binding.tabMain.etPull.getText().toString();
                    Constants.PULL_URL = CommonUtils.getPullUrl(pullStreamId);
                    Constants.PULL_STREAMID = pullStreamId;
                    Navigation.findNavController(v)
                            .navigate(R.id.open_subscribe);
                }
                );
        // endregion
    }
}
