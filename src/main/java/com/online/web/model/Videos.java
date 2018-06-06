package main.java.com.online.web.model;

public class Videos {
    private Integer uid;

    private String img;

    private String pic;

    private String pron;

    private String word;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getPron() {
        return pron;
    }

    public void setPron(String pron) {
        this.pron = pron == null ? null : pron.trim();
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word == null ? null : word.trim();
    }
}