/**  
* <p>Title: VideoService.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 6/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.service;

import java.util.List;

import main.java.com.online.core.generic.GenericService;
import main.java.com.online.web.model.VideosWithBLOBs;
import main.java.com.online.web.model.WordsWithBLOBs;

/**  
* <p>Title: VideoService</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 6/06/2018  
*/
public interface VideoService extends GenericService<VideosWithBLOBs, Long>{
	public List<VideosWithBLOBs> getVideobyId(int id);
	public List<VideosWithBLOBs> getAllVideo();
	public int insert(WordsWithBLOBs model);
}
