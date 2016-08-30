package imageloader.my.imageloader.tool;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by huangResplendent on 16/8/29.
 */
public class DiskCache {

    public String cacheDir= Environment.getExternalStorageDirectory() + "/imageloader/image/";

    public Bitmap getCache(String url){
        return BitmapFactory.decodeFile(cacheDir+url);
    }

    public void putCache(String url,Bitmap bitmap){
        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(cacheDir+url);
            bitmap.compress(Bitmap.CompressFormat.PNG,80,fileOutputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
