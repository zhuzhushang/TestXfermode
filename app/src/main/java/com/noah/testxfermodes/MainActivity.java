package com.noah.testxfermodes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener,SeekBar.OnSeekBarChangeListener{


    private CircleRectView circlerectview;

    @BindView(R.id.seekbar)
    SeekBar mSeekbar;

    @BindView(R.id.alphaview)
    AlphaView mAlphaView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        findViewById(R.id.button).setOnClickListener(this);

        testAlphaView();
    }

    private void testAlphaView() {

        mSeekbar.setMax(255);
        mSeekbar.setProgress(mAlphaView.getAlpha1());
        mSeekbar.setOnSeekBarChangeListener(this);



    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.button:

                startActivity(new Intent(this,XfermodesActivity.class));

                break;

        }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        mAlphaView.setAlpha(progress );

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
