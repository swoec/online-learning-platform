/**  
* <p>Title: StudentServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 16/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import main.java.com.online.core.generic.GenericDao;
import main.java.com.online.core.generic.GenericServiceImpl;
import main.java.com.online.web.dao.StudentsMapper;
import main.java.com.online.web.model.Students;
import main.java.com.online.web.model.StudentsExample;
import main.java.com.online.web.service.StudentService;

/**  
* <p>Title: StudentServiceImpl</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 16/06/2018  
*/
@Service
public class StudentServiceImpl extends GenericServiceImpl<Students, Long> implements StudentService {

	
	@Resource
	private StudentsMapper studentmapper;
	
	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericDao<Students, Long> getDao() {
		// TODO Auto-generated method stub
		
		return null;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.StudentService#getAllStudent()
	 */
	@Override
	public List<Students> getAllStudent() {
		// TODO Auto-generated method stub
        StudentsExample example = new StudentsExample();		
		return studentmapper.selectByExample(example);
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.StudentService#getAllFriends(int)
	 */
	@Override
	public List<Students> getAllFriends(int uid) {
		// TODO Auto-generated method stub
		return null;
	}

}
