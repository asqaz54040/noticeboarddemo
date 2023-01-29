package tw.com.sam.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.sam.model.bean.NoticeboardBean;
import tw.com.sam.model.dao.NoticeboardDao;

@Service
@Transactional
public class NoticeboardService {
	@Autowired
	private NoticeboardDao nDao;
	
	public NoticeboardBean insert(NoticeboardBean noticeboard) {
		return nDao.insert(noticeboard);
	}
	
	public NoticeboardBean updateNotice(NoticeboardBean noticeboard) {
		return nDao.updateNotice(noticeboard);
	}
	
	public List<NoticeboardBean> selectAll(){
		return nDao.selectAll();
	}
	
	public void delete(NoticeboardBean noticeboard) {
		nDao.delete(noticeboard);
	}
	public NoticeboardBean findById(Integer id) {
		return nDao.findById(id);
	}
	public List<NoticeboardBean> searchTitle(String title) {
		return nDao.searchTitle(title);
	}
	
}
