package com.it15301.utilities;

import java.io.File;
import java.nio.file.Files;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UploadFileUtils {
	public File handleUploadFile(
		MultipartFile uploadedFile
	) {
		String folderPath = "C:\\Users\\khanh\\eclipse-workspace\\ASM\\src\\main\\static/storage";
		File myUploadFolder = new File(folderPath);
		
		// Kiểm tra thư mục lưu trữ file có tồn tại? nếu ko thì tạo mới thư mục
		if (!myUploadFolder.exists()) {
			myUploadFolder.mkdirs();
		}
		
		File savedFile = null;
		try {
			// Lưu file vào thư mục đã chọn
			String uuid = UUID.randomUUID().toString();
			String fileName = uuid + "_" + uploadedFile.getOriginalFilename();
			savedFile = new File(myUploadFolder, fileName);
			uploadedFile.transferTo(savedFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return savedFile;
	}
}
