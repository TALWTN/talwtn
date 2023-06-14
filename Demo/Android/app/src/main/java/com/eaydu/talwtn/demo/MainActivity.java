/*
 * Copyright 2022 Beijing TAL Technology Ltd. All Rights Reserved.
 * SPDX-license-identifier: BSD-3-Clause
 */
package com.eaydu.talwtn.demo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.eaydu.talwtn.demo.engine.EngineHelper;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EngineHelper.initEngine(getApplicationContext());
    }
}