package me.moxun.overlaydemo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean hasOverlay = false;
    private View target;
    private Overlays.ViewHighlightOverlaysJellybeanMR2 highlighter;
    private final int contentColor = Color.parseColor("#A86FA8DC");
    private FrameLayout right;
    private FrameLayout left;
    private TextView x;
    private boolean isAnimStarted = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instantiationViews();
        target = findViewById(R.id.text_view);
        highlighter = new Overlays.ViewHighlightOverlaysJellybeanMR2();

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasOverlay) {
                    highlighter.removeHighlight(target);
                } else {
                    highlighter.highlightView(target, contentColor);
                }
                hasOverlay = !hasOverlay;
            }
        });

        findViewById(R.id.step).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hasOverlay) {
                    highlighter.removeHighlight(target);
                    hasOverlay = false;
                }
                highlighter.highlightStepByStep(target, contentColor);
            }
        });

        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ObjectAnimator anim = ObjectAnimator.ofFloat(x, "translationX", 0, right.getWidth() * 2);
                anim.setDuration(2000);
                right.getOverlay().add(x);
                anim.start();

                anim.addListener(new Animator.AnimatorListener() {

                    @Override
                    public void onAnimationStart(Animator animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        right.getOverlay().remove(x);
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {
                        right.getOverlay().remove(x);
                    }
                });
            }
        });
    }

    private void instantiationViews() {
        right = (FrameLayout) findViewById(R.id.right);
        left = (FrameLayout) findViewById(R.id.left);
        x = (TextView) findViewById(R.id.x);
    }
}
