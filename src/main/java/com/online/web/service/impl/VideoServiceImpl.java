/**  
* <p>Title: VideoServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 6/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import main.java.com.online.core.generic.GenericDao;
import main.java.com.online.core.generic.GenericServiceImpl;
import main.java.com.online.web.dao.VideosMapper;
import main.java.com.online.web.model.VideosExample;
import main.java.com.online.web.model.VideosWithBLOBs;
import main.java.com.online.web.model.WordsWithBLOBs;
import main.java.com.online.web.service.VideoService;

/**  
* <p>Title: VideoServiceImpl</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 6/06/2018  
*/
@Service
public class VideoServiceImpl extends GenericServiceImpl<VideosWithBLOBs, Long>implements VideoService {

	@Resource
	private VideosMapper videomaper;
	
	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.VideoService#getVideobyId(int)
	 */
	@Override
	public List<VideosWithBLOBs> getVideobyId(int id) {
		// TODO Auto-generated method stub
		VideosWithBLOBs vd = new VideosWithBLOBs();
		List <VideosWithBLOBs> alist = new ArrayList();
		alist.add(vd);;
		return alist;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.VideoService#getAllVideo()
	 */
	@Override
	public List<VideosWithBLOBs> getAllVideo() {
		// TODO Auto-generated method stub
		VideosExample example = new VideosExample();
		example.createCriteria().andUidEqualTo(1);
		return videomaper.selectByExampleWithBLOBs(example);
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericDao<VideosWithBLOBs, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.VideoService#insert(main.java.com.online.web.model.WordsWithBLOBs)
	 */
	@Override
	public int insert(WordsWithBLOBs model) {
		// TODO Auto-generated method stub
		return 0;
	}

}
