package com.e3.manager.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.e3.manager.utils.FastDFSClient;
import com.e3.utils.JsonUtils;
import com.e3.utils.kingEditorModel;

@Controller
public class UploadController {
	
	@Value("${IMAGE_URL}")
	private String IMAGE_URL;		
	
	
	@RequestMapping("/pic/upload")
	@ResponseBody
	public String  uploadFile(MultipartFile uploadFile){
		
		try {
			String filename = uploadFile.getOriginalFilename();
			String extname = filename.substring(filename.lastIndexOf(".")+1);
			
			FastDFSClient fClient = new FastDFSClient("classpath:conf/client.conf");
			
			String url = fClient.uploadFile(uploadFile.getBytes(), extname);
			
			url = IMAGE_URL +url;
			
			kingEditorModel model  = new kingEditorModel();
			
			model.setError(0);
			model.setUrl(url);
			
			String json = JsonUtils.objectToJson(model);
			return json;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			kingEditorModel model  = new kingEditorModel();
			
			model.setError(1);
			model.setMessage("上传失败");
			String json = JsonUtils.objectToJson(model);
			return json;
		}
		
		
		
		
	}

}
