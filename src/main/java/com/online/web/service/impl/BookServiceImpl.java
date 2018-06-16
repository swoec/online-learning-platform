/**  
* <p>Title: BookServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 16/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import main.java.com.online.core.generic.GenericDao;
import main.java.com.online.core.generic.GenericServiceImpl;
import main.java.com.online.web.dao.BooksMapper;
import main.java.com.online.web.model.Books;
import main.java.com.online.web.model.BooksExample;
import main.java.com.online.web.service.BookService;

/**  
* <p>Title: BookServiceImpl</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 16/06/2018  
*/
@Service
public class BookServiceImpl extends GenericServiceImpl<Books, Long>implements BookService {
	@Resource
	private BooksMapper bookmapper;

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericDao<Books, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.BookService#getAllBook()
	 */
	@Override
	public List<Books> getAllBook() {
		// TODO Auto-generated method stub
		BooksExample example = new BooksExample();
		return bookmapper.selectByExample(example);
		
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.BookService#getBookByID(int)
	 */
	@Override
	public List<Books> getBookByID(int id) {
		// TODO Auto-generated method stub
		ArrayList books = new ArrayList();
		BooksExample example = new BooksExample();
		example.createCriteria().andBidEqualTo(id);
		books.add(bookmapper.selectByExample(example));
		return books;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.BookService#getBookByUser(int)
	 */
	@Override
	public List<Books> getBookByUser(int uid) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
