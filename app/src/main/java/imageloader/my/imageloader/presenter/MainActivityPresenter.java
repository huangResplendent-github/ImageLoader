package imageloader.my.imageloader.presenter;

import java.util.List;

import imageloader.my.imageloader.bean.ImageEntity;
import imageloader.my.imageloader.bean.ResultEntity;
import imageloader.my.imageloader.biz.IResultListener;
import imageloader.my.imageloader.biz.ImageBiz;
import imageloader.my.imageloader.view.IMainView;

/**
 * Created by huangResplendent on 16/8/30.
 */
public class MainActivityPresenter {

    private IMainView iMainView;

    public MainActivityPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
    }

    public void gainData(){
        ImageBiz imageBize=new ImageBiz();
        iMainView.showLoading(true);
        imageBize.gainData(new IResultListener() {
            @Override
            public void onResult(ResultEntity result) {
                iMainView.showLoading(false);
                iMainView.showData((List<ImageEntity>) result.getDate());
            }
        });
    }
}
