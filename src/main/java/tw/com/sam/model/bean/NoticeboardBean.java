package tw.com.sam.model.bean;

import java.sql.Date;
import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;


@Entity
@Table(name = "announcement")
@Component("noticeboardbean")
public class NoticeboardBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String publisher;
	private Date publishedDate;
	private Date expirationDate;
	private String content;
	private byte[] attach;
	private String attachName;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public Date getPublishedDate() {
		return publishedDate;
	}
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	
	
	public byte[] getAttach() {
		return attach;
	}
	public void setAttach(byte[] attach) {
		this.attach = attach;
	}
	public String getAttachName() {
		return attachName;
	}
	public void setAttachName(String attachName) {
		this.attachName = attachName;
	}
	public NoticeboardBean() {
		super();
	}
	public NoticeboardBean(Integer id, String title, String publisher, Date publishedDate, Date expirationDate,
			String content) {
		super();
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.expirationDate = expirationDate;
		this.content = content;
	}
	
	public NoticeboardBean(Integer id, String title, String publisher, Date publishedDate, Date expirationDate,
			String content, byte[] attach, String attachName) {
		super();
		this.id = id;
		this.title = title;
		this.publisher = publisher;
		this.publishedDate = publishedDate;
		this.expirationDate = expirationDate;
		this.content = content;
		this.attach = attach;
		this.attachName = attachName;
	}
	
	@Override
	public String toString() {
		return "NoticeboardBean [id=" + id + ", title=" + title + ", publisher=" + publisher + ", publishedDate="
				+ publishedDate + ", expirationDate=" + expirationDate + ", content=" + content + ", attach="
				+ Arrays.toString(attach) + ", attachName=" + attachName + "]";
	}
	
	
	
	
	
}
