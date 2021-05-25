package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.model.Opus;
import com.service.OpusService;

/**
 * Servlet implementation class OpusUploadImgServlet
 */
@WebServlet("/OpusUploadImgServlet")
public class OpusUploadImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private OpusService os = new OpusService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String operate = null;
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");

		//文件保存位置
		File uploadPath = new File("F:\\eclipse中文版\\workspace\\Draw\\WebContent\\images");
		if (!uploadPath.exists()) {
			uploadPath.mkdir();
		}
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(1024 * 1024); // 设置上传文件最大尺寸
		try {
			List<FileItem> list = upload.parseRequest(request);
			// 创建一个对象
			Opus opus = new Opus();
			
			for (FileItem item : list) {
				String fileName = item.getName();
				// isFormField() 判断是否是普通属性 是返回true，否则返回false type=file 返回false
				// 判断是否是  type = file ，如果是 进入到if中，否则到else中
				if (!item.isFormField()) {
					System.out.println("fileName = " + fileName);
					if(fileName != null) {
						File saveFile = new File(uploadPath, item.getName());
						item.write(saveFile);  //文件上传
						
						opus.setImg(fileName);
					}
				} else {
					
					switch (item.getFieldName()) {
						case "operate":
								operate = new String(item.getString().getBytes("ISO-8859-1"), "utf-8");
								break;
						case "id":
								opus.setId(Integer.parseInt(item.getString()));
								break;
						case "name":
								opus.setName(new String(item.getString().getBytes("ISO-8859-1"), "utf-8"));
								break;
						case "author":
								opus.setAuthor(new String(item.getString().getBytes("ISO-8859-1"), "utf-8"));
								break;
						case "tid":
								opus.setTid(Integer.parseInt(item.getString()));
								break;
						case "sid":
								opus.setSid(Integer.parseInt(item.getString()));
								break;
						case "introduce":
								opus.setIntroduce(new String(item.getString().getBytes("ISO-8859-1"), "utf-8"));
								break;
						}
						
					} 
					
			}
			if ("add".equals(operate)) {
				os.addOpus(opus.getAuthor(), opus.getName(), opus.getImg(), opus.getTid(), opus.getSid(), opus.getIntroduce());	
			} else {
				os.mergeOpus(opus.getId(), opus.getAuthor(), opus.getName(), opus.getImg(), opus.getTid(), opus.getSid(), opus.getIntroduce());
			}
			response.sendRedirect("OpusManagerServlet?operate=showpage");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
	}

}
