package hr.ferit.tumiljanovic.osnoverwima_lv1;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerItemDecorator extends RecyclerView.ItemDecoration {


    private final int verticalSpaceHeight;


    public DividerItemDecorator(Context context) {
        this.verticalSpaceHeight = (int) context.getResources().getDimension(R.dimen.divider_space_height) ;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);

        if (parent.getChildAdapterPosition(view) != parent.getAdapter().getItemCount()) {
            outRect.bottom = verticalSpaceHeight;
        }
    }


}
