package miao.kmirror.viewlearn;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

public class CustomView extends View {

    private int lastX;
    private int lastY;

    public CustomView(Context context) {
        super(context);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // 获取手指触摸点的横纵坐标
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                lastX = x;
                lastY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                // 计算移动距离
                int offsetX = x - lastX;
                int offsetY = y - lastY;
//                // 调用 layout 方法来重新放置它的位置
//                layout(getLeft() + offsetX, getTop() + offsetY,
//                        getRight() + offsetX, getBottom() + offsetY);


//                // offsetLeftAndRight() 和 offsetTopAndBottom() 方法
//                // 对 left 和 right 进行偏移
//                offsetLeftAndRight(offsetX);
//                // 对 top 和 bottom 进行偏移
//                offsetTopAndBottom(offsetY);

//                // LayoutParams (改变布局参数)
//                // 这里因为控件是 LinearLayout，所以用了 LinearLayout.LayoutParams。
//                // 如果父控件是 RelativeLayout，则要使用 RelativeLayout.LayoutParams
//
//                // LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
//                // 我们不仅能使用布局的 LayoutParams 还可以使用 ViewGroup.MarginLayoutParams 来实现。
//                ViewGroup.MarginLayoutParams layoutParams  = (ViewGroup.MarginLayoutParams) getLayoutParams();
//
//                layoutParams.leftMargin = getLeft() + offsetX;
//                layoutParams.topMargin = getTop() + offsetY;
//                setLayoutParams(layoutParams);

                // scrollTo 与 scrollBy
                /**
                 * 这里是移动父控件
                 * 简单理解父控件是画布，CustomView 位置确定，手机屏幕位置不动，所以是负数，相对移动
                 * */
                ((View) getParent()).scrollBy(-offsetX, -offsetY);
                break;
            default:
                break;
        }
        return true;
    }
}
