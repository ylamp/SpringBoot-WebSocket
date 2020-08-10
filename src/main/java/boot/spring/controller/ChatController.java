package boot.spring.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSON;

import boot.spring.config.MyWebSocketHandler;
import boot.spring.po.Message;
import boot.spring.po.User;
import boot.spring.service.LoginService;

@Controller
public class ChatController {
	@Autowired
	MyWebSocketHandler handler;

	@Autowired
	LoginService loginservice;

	@RequestMapping("/onlineusers")
	@ResponseBody
	public Set<String> onlineusers(HttpSession session) {
		Map<Long, WebSocketSession> map = MyWebSocketHandler.userSocketSessionMap;
		Set<Long> set = map.keySet();
		Iterator<Long> it = set.iterator();
		Set<String> nameset = new HashSet<String>();
		while (it.hasNext()) {
			Long entry = it.next();
			String name = loginservice.getnamebyid(entry);
			String user = (String) session.getAttribute("username");
			if (!user.equals(name))
				nameset.add(name);
		}
		return nameset;
	}

	// 发布系统广播（群发）
	@RequestMapping(value = "broadcast", method = RequestMethod.POST)
	@ResponseBody
	public void broadcast(@RequestParam("text") String text) throws IOException {
		Message msg = new Message();
		msg.setDate(new Date());
		msg.setFrom(-1L);// -1表示系统广播
		msg.setFromName("系统广播");
		msg.setTo(0L);
		msg.setText(text);
		handler.broadcast(new TextMessage(JSON.toJSONString(msg)));
	}

	@RequestMapping("getuid")
	@ResponseBody
	public User getuid(@RequestParam("username") String username) {
		Long a = loginservice.getUidbyname(username);
		User u = new User();
		u.setUid(a);
		return u;
	}
}
