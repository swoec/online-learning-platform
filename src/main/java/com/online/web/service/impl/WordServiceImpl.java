/**  
* <p>Title: WordServiceImpl.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 2/06/2018  
* @version 1.0  
*/  
package main.java.com.online.web.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import main.java.com.online.core.generic.GenericDao;
import main.java.com.online.core.generic.GenericServiceImpl;
import main.java.com.online.web.dao.WordsMapper;
import main.java.com.online.web.model.WordsWithBLOBs;
import main.java.com.online.web.service.WordService;

/**  
* <p>Title: WordServiceImpl</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 2/06/2018  
*/
@Service
public class WordServiceImpl extends GenericServiceImpl<WordsWithBLOBs, Long>implements WordService {
	
	@Resource
	private WordsMapper wordmaper;

	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.WordService#getWordbyId(int)
	 */
	@Override
	public List<WordsWithBLOBs> getWordbyId(int id) {
		// TODO Auto-generated method stub
		WordsWithBLOBs  ad =wordmaper.selectByPrimaryKey(id);
		System.out.println("----get by id-----"+ad.getUid());
		System.out.println(ad.getExp());
		System.out.println(ad.getSentance());
		System.out.println(ad.getImg());
		System.out.println(ad.getSynon());
		System.out.println("-----get by id------"+ad.getUid());
		List <WordsWithBLOBs> alist = new ArrayList();
		alist.add(ad);
		return alist;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.web.service.WordService#getAllWord()
	 */
	@Override
	public List<WordsWithBLOBs> getAllWord() {
		// TODO Auto-generated method stub
		WordsWithBLOBs  ad =wordmaper.selectByPrimaryKey(1);
		System.out.println(ad.getUid());
		System.out.println(ad.getExp());
		System.out.println(ad.getSentance());
		System.out.println(ad.getImg());
		System.out.println(ad.getSynon());
		System.out.println(ad.getUid());
		List <WordsWithBLOBs> alist = new ArrayList();
		alist.add(ad);
		return alist;
		
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericService#insert(java.lang.Object)
	 */
	@Override
	public int insert(WordsWithBLOBs model) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericService#update(java.lang.Object)
	 */
	@Override
	public int update(WordsWithBLOBs model) {
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
	public WordsWithBLOBs selectById(Long id) {
		// TODO Auto-generated method stub
		return wordmaper.selectByPrimaryKey(id.intValue());
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericService#selectOne()
	 */
	@Override
	public WordsWithBLOBs selectOne() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericService#selectList()
	 */
	@Override
	public List<WordsWithBLOBs> selectList() {
		// TODO Auto-generated method stub
		return wordmaper.selectByExampleWithBLOBs(null);
	}

	/* (non-Javadoc)
	 * @see main.java.com.online.core.generic.GenericServiceImpl#getDao()
	 */
	@Override
	public GenericDao<WordsWithBLOBs, Long> getDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
