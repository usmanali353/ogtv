package com.example.helloworldsolution.ogtv;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by HelloWorldSolution on 4/17/2018.
 */

public class VerticalSpace extends RecyclerView.ItemDecoration {
    int space;
             public VerticalSpace(int space) {
                 this.space = space;
             }
             @Override
     public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                 if (parent.getChildLayoutPosition(view) == 0) {
                         outRect.top = space;
                     }
                outRect.right = space;
                outRect.left = space;
                 outRect.bottom = space;
             }
}
