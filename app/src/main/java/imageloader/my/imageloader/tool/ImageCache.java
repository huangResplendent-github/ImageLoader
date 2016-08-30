package imageloader.my.imageloader.tool;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by huangResplendent on 16/8/24.
 * 图片缓存
 */
public class ImageCache {


    LruCache<String,Bitmap> mImageCache;

    public ImageCache(){
        initImageCache();
    }

    private void initImageCache(){
        //获取可使用的最大内存
        final int maxMemory=(int)(Runtime.getRuntime().maxMemory()/1024);
        //取四分之一作为缓存内存
        final int cacheSize=maxMemory/4;
        mImageCache=new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight()*1024;//设置最小为。最大为cacheSize
            }
        };

    }

    public void putCache(String  key,Bitmap value){
        mImageCache.put(key,value);
    }


    public Bitmap getCache(String key){
        return mImageCache.get(key);
    }

}
