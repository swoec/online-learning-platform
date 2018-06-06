/**  
* <p>Title: CommentServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 4/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import main.java.com.online.core.generic.GenericDao;
import main.java.com.online.core.generic.GenericServiceImpl;
import main.java.com.online.web.dao.CommentsMapper;
import main.java.com.online.web.model.Comments;
import main.java.com.online.web.model.CommentsExample;
import main.java.com.online.web.service.CommentService;

/**  
* <p>Title: CommentServiceImpl</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 4/06/2018  
*/
@Service
public class CommentServiceImpl extends GenericServiceImpl<Comments, Long>implements CommentService {

	@Resource
	private CommentsMapper commentmaper;
	
	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericService#insert(java.lang.Object)
	 */
	@Override
	public int insert(Comments model) {
		// TODO Auto-generated method stub
		return commentmaper.insert(model);
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericService#update(java.lang.Object)
	 */
	@Override
	public int update(Comments model) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericService#delete(java.lang.Object)
	 */
	@Override
	public int delete(Long id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericService#selectById(java.lang.Object)
	 */
	@Override
	public Comments selectById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericService#selectOne()
	 */
	@Override
	public Comments selectOne() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericService#selectList()
	 */
	@Override
	public List<Comments> selectList() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericDao<Comments, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.CommentService#getCommentbytype(int)
	 */
	@Override
	public List<Comments> getCommentbytype(int type) {
		// TODO Auto-generated method stub
		CommentsExample example = new CommentsExample();
		example.createCriteria().andTypeEqualTo(type);
		return commentmaper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.CommentService#getCommentbyeid(int)
	 */
	@Override
	public List<Comments> getCommentbyeid(int elementid) {
		// TODO Auto-generated method stub
		CommentsExample example = new CommentsExample();
		example.createCriteria().andEleidEqualTo(elementid);
		return commentmaper.selectByExample(example);
	}

}
