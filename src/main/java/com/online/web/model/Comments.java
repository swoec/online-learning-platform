package main.java.com.online.web.model;

public class Comments {
    private Integer id;

    private Integer userid;

    private String comments;

    private String uname;

    private Integer type;

    private Integer status;

    private String dtime;

    private String pic;

    private String cfile;

    private Integer eleid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments == null ? null : comments.trim();
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDtime() {
        return dtime;
    }

    public void setDtime(String dtime) {
        this.dtime = dtime == null ? null : dtime.trim();
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    public String getCfile() {
        return cfile;
    }

    public void setCfile(String cfile) {
        this.cfile = cfile == null ? null : cfile.trim();
    }

    public Integer getEleid() {
        return eleid;
    }

    public void setEleid(Integer eleid) {
        this.eleid = eleid;
    }
}