package imageloader.my.imageloader.bean;

/**
 * Created by huangResplendent on 16/8/30.
 * 图片实体类
 */
public class ImageEntity {
    private String iId;
    private String iUrl;

    public ImageEntity(String iId, String iUrl) {
        this.iId = iId;
        this.iUrl = iUrl;
    }


    public ImageEntity() {
    }


    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId;
    }

    public String getiUrl() {
        return iUrl;
    }

    public void setiUrl(String iUrl) {
        this.iUrl = iUrl;
    }
}
