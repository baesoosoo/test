package com.spring.upload;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Service
public class Upload {
	
	
	public boolean fileUpload(MultipartHttpServletRequest mRequest) {
		
		boolean isUpload = false;
		
		String uploadPath = "C:\\NCS\\workspace(spring)\\14_FileUpload\\src\\main\\webapp\\resources\\upload\\";
		
		Calendar cal = Calendar.getInstance();
		
		int year = cal.get(Calendar.YEAR);
		
		int month = cal.get(Calendar.MONTH)+1;
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		
		Iterator<String> iterator = mRequest.getFileNames();
		
		while(iterator.hasNext()) {
			
			String uploadFileName = iterator.next(); //업로드 폼의 name들의 변수명이 들어감
			
			System.out.println("uploadFileName >>>"+uploadFileName);
			
			MultipartFile mFile = mRequest.getFile(uploadFileName);
			
			// getOriginalFilename() : 업로드 되는 파일에서 확장자를 포함한 파일의 이름을 반환해 주는 메서드
			String originalFileName = mFile.getOriginalFilename();
			
			System.out.println("originalFileName >>"+originalFileName);
			
			
			//실제로 폴더를 만들어 보자.
			// ......\\resources\\upload\\2024-04-25
			String homeDir = uploadPath + year + "-" + month + "-" + day;
			
			File path1 = new File(homeDir);
			
			if(!path1.exists()) {
				path1.mkdirs(); //실제로 폴더를 만들어 주는 메서드
			}
			
			// 실제 파일을 만들어 보자.
			String savaFileName = originalFileName;
			
			if(!savaFileName.equals("")) {
				savaFileName = System.currentTimeMillis()+"_"+savaFileName;
				
				
				
				
				try {
					File origin = new File(homeDir + "/"+savaFileName);
					
					//transferTo() : 파일 데이터를 지정한 폴더를 실제 저장시키는 메서드.
					mFile.transferTo(origin);
					
					isUpload = true;
					
				} catch (IllegalStateException e) {
					
					e.printStackTrace();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		} // while문 end 
		
		return isUpload;
	}
	

}
