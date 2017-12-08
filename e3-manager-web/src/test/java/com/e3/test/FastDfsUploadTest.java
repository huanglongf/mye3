package com.e3.test;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;

import com.e3.manager.utils.FastDFSClient;

public class FastDfsUploadTest {
	
	
	@Test
	public void fastUploadTest() throws Exception{
		
		String pic = "d:\\qq.jpg";
		
		//指定配置文件绝对路径
		String client = "D:\\itemtwo\\mye3\\e3-manager-web\\src\\main\\resources\\conf\\client.conf";
		
		//连接tracker_server服务器
		ClientGlobal.init(client);
		
		//创建trackerClient客户端，获取服务对象
		TrackerClient trackerClient = new TrackerClient();
		TrackerServer trackerServer = trackerClient.getConnection();
		
		//创建Storage存储服务客户对象
		StorageServer storageServer = null;
		StorageClient sClient = new StorageClient(trackerServer, storageServer);
		
		String[] uls = sClient.upload_file(pic, "jpg", null);
		for (String url : uls) {
			System.out.println(url);
		}
		
		
	}
	
	@Test
	public void uploadFile() throws Exception{
		String pic = "d:\\2.jpg";
		
		//指定配置文件绝对路径
		String client = "D:\\itemtwo\\mye3\\e3-manager-web\\src\\main\\resources\\conf\\client.conf";
		
		FastDFSClient fastClient  = new FastDFSClient(client);
		
		String url = fastClient.uploadFile(pic);
		System.out.println(url);
		
		
	}
}
