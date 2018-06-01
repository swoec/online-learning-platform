package main.java.com.angular.dao;

import java.util.List;

import main.java.com.angular.model.CommentEntity;
import main.java.com.angular.model.CommodityEntity;

public interface ICommodityDao {
	
	public List<CommodityEntity> getCommById(int id);
	public List<CommodityEntity> getAllComm();
	public List<CommentEntity> getCommentbyId(int commid);
	public boolean addCommentbyId(int userId,int commodityID,String userName,String comment);
	public List<CommodityEntity> searchComm(String keyword);

}
