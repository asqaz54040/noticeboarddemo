package tw.com.sam.model.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.com.sam.model.bean.NoticeboardBean;

@Repository
@Transactional
public class NoticeboardDao {
	@Autowired
	private SessionFactory factory;
	
	public NoticeboardBean insert(NoticeboardBean noticeboard) {//新增
		Session session =factory.getCurrentSession();
		if(noticeboard!=null) {
			session.save(noticeboard);
		}
		return noticeboard;
	}
	
	public NoticeboardBean updateNotice(NoticeboardBean noticeboard) {//修改
		Session session = factory.getCurrentSession();
		session.update(noticeboard);
		return noticeboard;
	}
	
	public List<NoticeboardBean> selectAll(){
		Session session = factory.getCurrentSession();
		Query<NoticeboardBean> query = session.createQuery("from NoticeboardBean",NoticeboardBean.class);
		//不能漏了from
		System.out.println(query);
		return query.list();
	}
	
	public void delete(NoticeboardBean note) {//刪除
		Session session =factory.getCurrentSession();
		session.delete(note);
	}
	
	public NoticeboardBean findById(Integer id) {
		NoticeboardBean bean=null;
		Session session =factory.getCurrentSession();
		Query<NoticeboardBean> query = session.createQuery("from NoticeboardBean WHERE id=:id",NoticeboardBean.class);
		try {
			bean =(NoticeboardBean)query.setParameter("id", id).getSingleResult();
		}catch (NoResultException e) {
			System.out.println("沒有這頁喔");;  // 表示查無紀錄
		}
		return bean;
	}
	
	public List<NoticeboardBean> searchTitle(String title) {
	    Session session = factory.getCurrentSession();
	    Query<NoticeboardBean> query = session.createQuery("from NoticeboardBean WHERE title LIKE :title", NoticeboardBean.class);
	    query.setParameter("title", "%" + title + "%");
	    return query.getResultList();
	}
	
}
