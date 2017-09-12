package cn.p2p.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.code.kaptcha.Producer;

@Controller
public class YZMController {
	private static Logger logger = LoggerFactory.getLogger(YZMController.class);
	@Autowired
	private Producer producer;

	/**
	 * 获取验证码
	 * 
	 * @param request
	 * @param response
	 * @param session
	 * @throws IOException
	 */
	@RequestMapping("/yzm")
	public void yzm(HttpServletRequest request, HttpServletResponse response,

			HttpSession session) throws IOException {

		String lastYZM = (String) session.getAttribute("yzm");

		logger.info("*******************上一次的验证码是" + lastYZM + "**********************");

		// 设置浏览器不要对数据进行缓存

		response.setDateHeader("Expires", 0);

		// Set standard HTTP/1.1 no-cache headers.

		response.setHeader("Cache-Control",

				"no-store, no-cache, must-revalidate");

		// Set IE extended HTTP/1.1 no-cache headers (use addHeader).

		response.addHeader("Cache-Control", "post-check=0, pre-check=0");

		// Set standard HTTP/1.0 no-cache header.

		response.setHeader("Pragma", "no-cache");

		// return a jpeg

		response.setContentType("image/jpeg");

		String yzm = producer.createText();

		logger.info("*******************本次的验证码是" + yzm + "**********************");

		session.setAttribute("yzm", yzm);

		BufferedImage image = producer.createImage(yzm);

		OutputStream out = response.getOutputStream();

		ImageIO.write(image, "jpg", out);

		try {

			out.flush();

		} finally {

			out.close();

		}

	}

	/**
	 * 验证码验证
	 * 
	 * @param yzm
	 * @param session
	 * @return
	 */
	@RequestMapping("/checkYzm")
	@ResponseBody
	public String checkYzm(@RequestParam String yzm, HttpSession session) {
		String code = (String) session.getAttribute("yzm");
		if (null == yzm) {
			return "null";
		}
		if (yzm.equalsIgnoreCase(code)) {
			return "true";
		}
		return "false";
	}
}
