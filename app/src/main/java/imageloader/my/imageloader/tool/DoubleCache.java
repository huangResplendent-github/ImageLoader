package imageloader.my.imageloader.tool;

import android.graphics.Bitmap;

/**
 * Created by huangyan on 16/9/7.
 * 双缓存工具类
 */
public class DoubleCache {
    private DiskCache diskCach=new DiskCache();//SD卡缓存
    private ImageCache imageCache=new ImageCache();//内存缓存


    /**
     * 将图片放入sd卡和内存中
     * @param url
     * @param bitmap
     */
    public void putCache(String url,Bitmap bitmap){
        diskCach.putCache(url,bitmap);
        imageCache.putCache(url,bitmap);
    }


    public Bitmap getCache(String key){
        Bitmap bitmap=null;
        bitmap=imageCache.getCache(key);
        if(bitmap==null)
            bitmap=diskCach.getCache(key);
        return bitmap;

    }
}
