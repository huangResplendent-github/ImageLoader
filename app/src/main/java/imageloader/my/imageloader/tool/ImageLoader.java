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
    //内存缓存
    private ImageCache mImageCahce;
    //SD卡缓存
    private DiskCache mDiskCache;
    //线程池，线程数量为CPU最大数量
    ExecutorService mExecutorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
    //是否使用SD卡缓存
    private boolean isUseDiskCache = false;

    public ImageLoader() {
        mImageCahce = new ImageCache();
        mDiskCache = new DiskCache();
    }

    /**
     * 显示图片
     *
     * @param url
     * @param imageview
     */
    public void displayImage(final String url, final ImageView imageview) {

//       Bitmap bitmap = mImageCahce.getCache(url);
        Bitmap bitmap = isUseDiskCache ? mDiskCache.getCache(url) : mImageCahce.getCache(url);
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
                if (isUseDiskCache)
                    mDiskCache.putCache(url, bitmap);
                else
                    mImageCahce.putCache(url, bitmap);

            }
        });

    }

    /**
     * 下载图片
     *
     * @param imageUrl
     * @return
     */
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


    public void setmDiskCache(boolean useDiskCache) {
        isUseDiskCache = useDiskCache;
    }

}
