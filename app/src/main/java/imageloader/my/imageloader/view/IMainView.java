package imageloader.my.imageloader.view;

import java.util.List;

import imageloader.my.imageloader.bean.ImageEntity;

/**
 * Created by huangResplendent on 16/8/30.
 */
public interface IMainView {
    public void showLoading(boolean isShow);
    public void showData(List<ImageEntity> datasource);

}
