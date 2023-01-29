package tw.com.sam.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import tw.com.sam.model.bean.NoticeboardBean;
import tw.com.sam.model.service.NoticeboardService;

@Controller
public class NoticeboardController {
	@Autowired
	private NoticeboardService nService;

	@GetMapping("/index")
	public String dataList(@RequestParam(defaultValue = "1") int pageNumber, Model m) {

	    List<NoticeboardBean> al = nService.selectAll();
	    PagedListHolder<NoticeboardBean> pageList = new PagedListHolder<NoticeboardBean>(al);
	    pageList.setPageSize(8);
	    pageList.setPage(pageNumber - 1);
	    m.addAttribute("dataList", pageList.getPageList());
	    m.addAttribute("pageNumber",pageNumber);
	    m.addAttribute("pageCount",pageList.getPageCount());
	    return "/index";
	}

	@GetMapping("/addpage")
	public String add() {
		return "/addnotice";
	}

	@PostMapping("/add")
	public String addNotice(@ModelAttribute("NoticeboardBean") NoticeboardBean noticeboard) {
		
		nService.insert(noticeboard);
		return "redirect:/index";
	}
	
//	@PostMapping("/add")
//	public String addNote(@ModelAttribute("NoticeboardBean") NoticeboardBean noticeboard,
//	                      @RequestParam("attach") MultipartFile attach) throws IOException {
//
//	    noticeboard.setAttach(attach.getBytes());
//	    nService.insert(noticeboard);
//	    return "redirect:/index";
//	}

	@GetMapping("/updatepage")
	public String updatePage(@RequestParam Integer id, Model m) {
		NoticeboardBean page = nService.findById(id);
		m.addAttribute("page", page);
		return "/updatenotice";
	}

	@PostMapping("/update")
	public String updateNotice(@ModelAttribute("NoticeboardBean") NoticeboardBean noticeboard) {
//		updatenote.getTitle();
//		System.out.println(updatenote.getTitle());
//		updatenote.getPublisher();
//		System.out.println(updatenote.getPublisher());
//		updatenote.getPublishedDate();
//		System.out.println(updatenote.getPublishedDate());
//		updatenote.getExpirationDate();
//		System.out.println(updatenote.getExpirationDate());
//		updatenote.getContent();
//		System.out.println(updatenote.getContent());
		nService.updateNotice(noticeboard);
		return "redirect:/index";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		NoticeboardBean notice = new NoticeboardBean();
		notice.setId(id);
		nService.delete(notice);
		return "redirect:/index";
	}

	@GetMapping("/singlepage")
	public String findsinglepage(@RequestParam Integer id, Model m) {
		NoticeboardBean page = nService.findById(id);
		m.addAttribute("page", page);
		return "/singlepage";

	}
	
	@PostMapping("/search")
	public String searchTitle(@RequestParam("title")String title,Model m) {
		List<NoticeboardBean> result = nService.searchTitle(title);
		if(result.equals(null)) {
			return "redirect:/index";
		}
		m.addAttribute("dataList",result);
		return "/index";
	}
	
	@RequestMapping("/uploads")
	public String uploads(@RequestParam("upload") MultipartFile file,
			@RequestParam("CKEditorFuncNum") String CKEditorFuncNum, HttpServletResponse response,
			HttpServletRequest request) throws IOException {
		System.out.println("有文件想要上传");
		PrintWriter out = response.getWriter();
		String name = null;
		name = new String(file.getOriginalFilename().getBytes("iso-8859-1"), "UTF-8");
		String uploadContentType = file.getContentType();
		// 处理文件后缀
		String expandedName = "";
		if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {
			// IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
			expandedName = ".jpg";
		} else if (uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")) {
			// IE6上传的png图片的headimageContentType是"image/x-png"
			expandedName = ".png";
		} else if (uploadContentType.equals("image/gif")) {
			expandedName = ".gif";
		} else if (uploadContentType.equals("image/bmp")) {
			expandedName = ".bmp";
		} else {
			// 文件格式不符合，返回错误信息
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'',"
					+ "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
			out.println("</script>");
			return null;
		}

		// 文件命名并保存到服务器
		DateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		name = df.format(new Date()) + expandedName;
//		String DirectoryName = request.getContextPath() + "/tempImag";
		String DirectoryName ="C:\\Temp\\upload\\";
		System.out.println("DirectoryName++++"+DirectoryName);
		try {
//			File file1 = new File(request.getServletContext().getRealPath("/tempImag"), name);
			File file1 = new File(DirectoryName, name);
			System.out.println(file1.getPath());
			file.transferTo(file1);
		} catch (Exception e) {
			e.printStackTrace();
		}

		String fileURL = DirectoryName + name;

		// 返回"图像"选项卡和图像在服务器的地址并显示图片
		out.println("<script type=\"text/javascript\">");
//		out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + fileURL + "','')");
//		out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'/uploads/" + fileURL + "',''" + ")");
		out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'" + fileURL + "','')");
		out.println("</script>");
		out.close();
		return null;
	}

}
