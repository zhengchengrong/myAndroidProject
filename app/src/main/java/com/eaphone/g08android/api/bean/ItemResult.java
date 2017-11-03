package com.eaphone.g08android.api.bean;

/**
 * Created by zhengchengrong on 2017/9/1.
 */

public class ItemResult {

    /**
     * id : 536563
     * title : new2 - 阿尔卡特 (OT-927) 炭黑 联通3G手机 双卡双待
     * sellPoint : 清仓！仅北京，武汉仓有货！
     * price : 29900000
     * num : 99999
     * barcode :
     * image : http://image.taotao.com/jd/4ef8861cf6854de9889f3db9b24dc371.jpg
     * cid : 560
     * status : 1
     * created : 1425821598000
     * updated : 1428755918000
     */

    private int id;
    private String title;
    private String sellPoint;
    private int price;
    private int num;
    private String barcode;
    private String image;

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    private int cid;
    private int status;
    private long created;
    private long updated;
    private int itemId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getUpdated() {
        return updated;
    }

    public void setUpdated(long updated) {
        this.updated = updated;
    }
}
