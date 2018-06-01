package main.java.com.angular.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import main.java.com.angular.dao.ICommodityDao;
import main.java.com.angular.dao.WordDao;
import main.java.com.angular.model.CommentEntity;
import main.java.com.angular.model.CommodityEntity;
import main.java.com.angular.model.WordEntity;

@Transactional
@Service("commService")
public class CommodityServiceImpl implements ICommodityService {
	@Resource
	private ICommodityDao commdao;

	@Resource
	private WordDao worddao;
	
	@Override
	public List<CommodityEntity> getCommbyId(int id) {
		// TODO Auto-generated method stub
		return commdao.getCommById(id);
		
	}

	@Override
	public List<CommodityEntity> getAllComm() {
		// TODO Auto-generated method stub
		return commdao.getAllComm();
	}

	@Override
	public List<CommentEntity> getCommentbyId(int commid) {
		// TODO Auto-generated method stub
		return commdao.getCommentbyId(commid);
	}

	@Override
	public boolean addCommentbyId(int userId, int commodityID, String userName, String comment) {
		// TODO Auto-generated method stub
		return commdao.addCommentbyId(userId, commodityID, userName, comment);
	}

	@Override
	public List<CommodityEntity> searchComm(String keyword) {
		// TODO Auto-generated method stub
		return commdao.searchComm(keyword);
	}

	/* (non-Javadoc)
	 * @see main.java.com.angular.service.ICommodityService#getWordbyId(int)
	 */
	@Override
	public List<WordEntity> getWordbyId(int id) {
		// TODO Auto-generated method stub
		return worddao.getWordById(id);
		
	}

	/* (non-Javadoc)
	 * @see main.java.com.angular.service.ICommodityService#getAllWord()
	 */
	@Override
	public List<WordEntity> getAllWord() {
		// TODO Auto-generated method stub
		return worddao.getWord();
	}

	
}
