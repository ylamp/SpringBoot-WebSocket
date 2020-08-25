package boot.spring.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import com.alibaba.fastjson.JSON;

import boot.spring.po.Message;
import boot.spring.po.User;
import boot.spring.service.LoginService;
import boot.spring.service.WebSocketServer;

@Controller
public class ChatController {

	@Autowired
	LoginService loginservice;
	

	@RequestMapping("/onlineusers")
	@ResponseBody
	public Set<String> onlineusers(@RequestParam("currentuser") String currentuser) {
		ConcurrentHashMap<String, Session> map = WebSocketServer.getSessionPools();
		Set<String> set = map.keySet();
		Iterator<String> it = set.iterator();
		Set<String> nameset = new HashSet<String>();
		while (it.hasNext()) {
			String entry = it.next();
			if (!entry.equals(currentuser))
				nameset.add(entry);
		}
		return nameset;
	}

	/** 发布系统广播（群发）
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
	**/

	@RequestMapping("getuid")
	@ResponseBody
	public User getuid(@RequestParam("username") String username) {
		Long a = loginservice.getUidbyname(username);
		User u = new User();
		u.setUid(a);
		return u;
	}
}
