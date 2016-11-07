package etl.com.bd.animatedsplash;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;


/**
 * Created by Zulfikar on 10/1/2016.
 */
public class RounderTransformation implements com.squareup.picasso.Transformation {


    private final int radius;
    private final int margin;

    public RounderTransformation(final int radius, final int margin) {
        this.radius = radius;
        this.margin = margin;
    }


    @Override
    public Bitmap transform(Bitmap source) {
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(source, Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP));

        Bitmap output = Bitmap.createBitmap(source.getWidth(),
                source.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        canvas.drawRoundRect(new RectF(margin, margin, source.getWidth()
                - margin, source.getHeight() - margin), radius, radius, paint);

        if (source != output) {
            source.recycle();
        }

        return output;

    }

    @Override
    public String key() {
        return "rounded";
    }
}
