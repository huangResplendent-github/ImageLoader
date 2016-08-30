package imageloader.my.imageloader.tool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by huangResplendent on 16/8/24.
 * 图片加载
 */
public class ImageLoader {
    private ImageCache mImageCahce;

    //线程池，线程数量为CPU最大数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public ImageLoader() {
        mImageCahce = new ImageCache();
    }


    public void displayImage(final String url, final ImageView imageview) {

        Bitmap bitmap = mImageCahce.getCache(url);
        if (bitmap != null) {
            imageview.setImageBitmap(bitmap);
            return;
        }
        imageview.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {


                Bitmap bitmap = downloadImage(url);
                if (bitmap == null)
                    return;
                if (imageview.getTag().equals(url)) {
                    imageview.setImageBitmap(bitmap);
                }
                mImageCahce.putCache(url, bitmap);

            }
        });

    }


    public Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            BitmapFactory.decodeStream(http.getInputStream());
            http.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;

    }

}
