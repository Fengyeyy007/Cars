package edu.tinzel.Cars.action;

import edu.tinzel.Cars.biz.UsersBiz;
import edu.tinzel.Cars.biz.impl.UsersBizImpl;
import edu.tinzel.Cars.entity.Users;
import edu.tinzel.Cars.util.BaseAction;

public class UsersAction extends BaseAction {
	private Users users;

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}
	UsersBiz userBiz=new UsersBizImpl();
	public String login()throws Exception{
		Users uu=userBiz.login(users.getLoginName(), users.getLoginPwd());
		getSession().setAttribute("iuser", uu);
		if(uu==null){
			//登录失败，返回登录页面
			return "defeat";
		}else{
			//登录成功，跳往主页面
			return "loginsuccess";
		}
		
	}
}
