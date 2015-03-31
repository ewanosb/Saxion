package nl.saxion.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Roy on 31-3-2015.
 */
public class Priority extends View {

    private Paint paint;

    public Priority(Context context) {
        super(context);
        init();
    }

    public Priority(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Priority(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        this.paint = new Paint();
        this.paint.setColor(Color.GREEN);
        this.paint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {

        canvas.drawCircle(canvas.getWidth() / 2, canvas.getHeight() / 2, canvas.getWidth() / 2, paint);

    }
}
