/**  
* <p>Title: WordEntity.java</p>  
* <p>Description: </p>  
* <p>Copyright: Copyright (c) 2018</p>  
* <p>Company: </p>  
* @author Alex Wang  
* @date 31/05/2018  
* @version 1.0  
*/  
package main.java.com.angular.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* <p>Title: WordEntity</p>  
* <p>Description: </p>  
* @author Alex Wang  
* @date 31/05/2018  
*/
@Table(name="words")
@Entity
public class WordEntity {
	
	private int id;
	private String word;
	private String explanation;
	private String pic;
	private String sentance;
	private String pronouncation;
	private String img;
	private String synonym;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UID", nullable = false, length = 11)
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name = "word", nullable = false, length = 100)
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	@Column(name = "exp", nullable = false, length = 300)
	public String getExplanation() {
		return explanation;
	}
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	@Column(name = "pic", nullable = false, length = 100)
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Column(name = "sentance", nullable = false, length = 400)
	public String getSentance() {
		return sentance;
	}
	public void setSentance(String sentance) {
		this.sentance = sentance;
	}
	
	@Column(name = "pron", nullable = false, length = 100)
	public String getPronouncation() {
		return pronouncation;
	}
	public void setPronouncation(String pronouncation) {
		this.pronouncation = pronouncation;
	}
	
	@Column(name = "img", nullable = false, length = 120)
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Column(name = "synon", nullable = false, length = 300)
	public String getSynonym() {
		return synonym;
	}
	public void setSynonym(String synonym) {
		this.synonym = synonym;
	}
	
	
}
