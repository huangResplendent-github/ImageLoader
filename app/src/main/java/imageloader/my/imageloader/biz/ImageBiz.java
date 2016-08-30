package imageloader.my.imageloader.biz;

import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import imageloader.my.imageloader.bean.ImageEntity;
import imageloader.my.imageloader.bean.ResultEntity;

/**
 * Created by huangResplendent on 16/8/30.
 */
public class ImageBiz implements  IImageBiz{

    @Override
    public void gainData(final IResultListener resultListener) {
        new AsyncTask<Integer,Integer,List<ImageEntity>>(){

            @Override
            protected List<ImageEntity> doInBackground(Integer... integers) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                List<ImageEntity> dataSource=new ArrayList<ImageEntity>();
                dataSource.add(new ImageEntity(dataSource.size()+"","http://www.qqpk.cn/Article/UploadFiles/201112/20111212155248983.jpg"));
                dataSource.add(new ImageEntity(dataSource.size()+"","http://img15.3lian.com/2015/f1/153/d/3.jpg"));
                dataSource.add(new ImageEntity(dataSource.size()+"","http://img15.3lian.com/2015/a1/54/d/130.jpg"));
                dataSource.add(new ImageEntity(dataSource.size()+"","http://pic32.photophoto.cn/20140916/0035035797006285_b.jpg"));
                dataSource.add(new ImageEntity(dataSource.size()+"","http://www.qqpk.cn/article/uploadfiles/201112/20111212155249294.jpg"));
                dataSource.add(new ImageEntity(dataSource.size()+"","http://img2.3lian.com/2014/f5/33/d/1.jpg"));

                return dataSource;
            }

            @Override
            protected void onPostExecute(List<ImageEntity> result) {
                super.onPostExecute(result);
                if(resultListener!=null)
                    resultListener.onResult(new ResultEntity(1,result));
            }
        }.execute();

    }
}
