package com.londonappbrewery.destini;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;
    int mStoryIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        mStoryTextView = findViewById(R.id.storyTextView);
        mButtonTop = findViewById(R.id.buttonTop);
        mButtonBottom = findViewById(R.id.buttonBottom);
        mStoryIndex = 1;


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:

        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex == 1) {
                    setActivity(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                }
                if (mStoryIndex==3) {
                    mStoryTextView.setText(R.string.T6_End);
                    setButtonsInvisible();
                }
                if (mStoryIndex==2) {
                    setActivity(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2);
                }
            }
        });


        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mStoryIndex==3) {
                    mStoryTextView.setText(R.string.T5_End);
                    setButtonsInvisible();
                }
                if (mStoryIndex==2) {
                    mStoryTextView.setText(R.string.T4_End);
                    setButtonsInvisible();
                }
                if (mStoryIndex==1) {
                    setActivity(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2);

                }
            }
        });

    }

    void setActivity(int story, int ans1, int ans2) {
        mStoryTextView.setText(story);
        mButtonTop.setText(ans1);
        mButtonBottom.setText(ans2);
        mStoryIndex= ++mStoryIndex;
    }

    void setButtonsInvisible () {
        mButtonBottom.setVisibility(View.INVISIBLE);
        mButtonTop.setVisibility(View.INVISIBLE);
    }
}
