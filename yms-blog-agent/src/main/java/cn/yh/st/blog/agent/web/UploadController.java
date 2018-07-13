package cn.yh.st.blog.agent.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import cn.yh.st.blog.agent.vo.ImageResultMsg;
import cn.yh.st.common.util.DateUtils;

/**
 * 文件上传
 * 
 * @author yuhang
 * @Date 2018年7月13日
 * @desc
 */
@Controller
@RequestMapping("upload")
public class UploadController {

	/**
	 * 
	 * @param files
	 * @return ResultMsg
	 * @throws IOException
	 */
	@RequestMapping("uploadFile")
	@ResponseBody
	public ImageResultMsg uploadFile(@RequestParam("imgFile") CommonsMultipartFile file) {
		ImageResultMsg msg = new ImageResultMsg();
		try {
			String tmpFilePath = "/upload/";
			String datePath = DateUtils.formatDate(new Date(), DateUtils.PATTERN_A);
			long time = System.currentTimeMillis();
			BufferedImage imageInputStream = ImageIO.read(file.getInputStream());// 不是图片返回null
			System.out.println(imageInputStream);
			if (imageInputStream != null) {
				File f = new File(tmpFilePath + datePath + time + file.getOriginalFilename());
				FileUtils.copyInputStreamToFile(file.getInputStream(), f);
				msg.setUrl(tmpFilePath + datePath + time + file.getOriginalFilename());
				msg.setError(0);
			} else {
				msg.setError(1);
			}
		} catch (Exception e) {
			msg.setError(1);
			e.printStackTrace();
		}
		return msg;
	}
}
