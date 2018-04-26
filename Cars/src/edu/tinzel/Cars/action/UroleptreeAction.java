package edu.tinzel.Cars.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.tinzel.Cars.biz.UroleperviewBiz;
import edu.tinzel.Cars.biz.UsersBiz;
import edu.tinzel.Cars.biz.impl.UroleperviewBizImpl;
import edu.tinzel.Cars.biz.impl.UsersBizImpl;
import edu.tinzel.Cars.entity.Perview;
import edu.tinzel.Cars.entity.Uroleperview;
import edu.tinzel.Cars.entity.Users;
import edu.tinzel.Cars.util.BaseAction;
import edu.tinzel.Cars.util.Pager;

public class UroleptreeAction extends BaseAction {
	UroleperviewBiz urpBiz = new UroleperviewBizImpl();
	UsersBiz userBiz=new UsersBizImpl();
	private Uroleperview uro;
	private Perview perview;
	private String pagers;
	private String dels;
	private String[] delid;
	private Users us;
	
	public Users getUs() {
		return us;
	}

	public void setUs(Users us) {
		this.us = us;
	}

	public String getDels() {
		return dels;
	}

	public void setDels(String dels) {
		this.dels = dels;
	}

	public String getPagers() {
		return pagers;
	}

	public void setPagers(String pagers) {
		this.pagers = pagers;
	}

	public Uroleperview getUro() {
		return uro;
	}

	public void setUro(Uroleperview uro) {
		this.uro = uro;
	}

	public Perview getPerview() {
		return perview;
	}

	public void setPerview(Perview perview) {
		this.perview = perview;
	}

	// 查看菜单树
	public String urpTree() throws Exception {
		Users uu = (Users) getSession().getAttribute("iuser");
		List<Uroleperview> list = urpBiz.queryTree(uu.getUserId());
		getSession().setAttribute("treelist", list);
		return "ss";
	}

	// 查看用户管理
	public String umanage() throws Exception {
		Users uu = (Users) getSession().getAttribute("iuser");
		List<Uroleperview> list = urpBiz.queryUrp();
		int length = list.size();
		Uroleperview[] urps = new Uroleperview[length];
		for (int i = 0; i < length; i++) {
			urps[i] = list.get(i);
		}
		List<Uroleperview> ilist = new ArrayList<Uroleperview>();
		int l;
		for (int m = 0; m < length; m += l) {
			l = 1;
			int h = 0;
			String s = urps[m].getPerviewName();
			for (int n = m + 1; n < length; n++) {
				if (urps[m].getUserId() == urps[n].getUserId()) {
					l++;
					h = 1;
					s = s + "~" + urps[n].getPerviewName();
				}
				if ((urps[m].getUserId() != urps[n].getUserId()) && h == 0) {
					l = 1;
				}
			}
			ilist.add(new Uroleperview(urps[m + l - 1].getUserId(), urps[m + l
					- 1].getRoleId(), urps[m + l - 1].getPerviewId(), urps[m
					+ l - 1].getPerId(), urps[m + l - 1].getRoleMark(), urps[m
					+ l - 1].getUserName(), urps[m + l - 1].getRoleName(), s));

		}
		// getRequest().setAttribute("manalist", ilist);

		// 从界面中获取页码
		int currentPaged = 1;

		// 用户有没有点击改变页码
		if (getPagers() != null&&!getPagers().equals("")) {
			currentPaged = Integer.parseInt(getPagers());
		}
		// 1、创建分页类对象
		Pager pager = new Pager();
		// 2、需要分页的文本
		pager.setTopicSelect(ilist);
		// 3、设置每页显示行数
		pager.setSizePerPage(4);
		// 4、获取最大页数
		int maxPage = pager.getTotalPage();
		// 5、获取当前页
		/*pager.setCurrentPage(currentPaged);*/
		if(currentPaged<=maxPage){
			pager.setCurrentPage(currentPaged);
		}else{
			pager.setCurrentPage(maxPage);
		}
		getRequest().setAttribute("pager", pager);

		return "listuser";
	}

	// 根据编号查询用户详细信息
	public String querymanaById() throws Exception {
		Uroleperview urp = urpBiz.QuerymanageById(uro.getUserId());
		getRequest().setAttribute("userurp", urp);
		return "updateuser";
	}

	// 做用户修改操作
	public String upduserrole() throws Exception {
		// 修改用户信息
		boolean bo1 = urpBiz.upduser(new Uroleperview(uro.getUserId(), 0, uro
				.getUserName(), null, uro.getLoginPwd(), uro.getLoginName()));
		String name = uro.getRoleName();
		// 根据角色名称查询角色id
		int roleId = urpBiz.queryByname(name);
		// 修改用户角色
		boolean bo2 = urpBiz.updmanarole(uro.getUserId(), roleId);
		// 调用查询全部用户信息
		return umanage();
	}

	// 角色管理查询所有角色信息
	public String queryAllroles() throws Exception {
		List<Uroleperview> list = urpBiz.querryAllrole();
		int length = list.size();
		Uroleperview[] urps = new Uroleperview[length];
		for (int i = 0; i < length; i++) {
			urps[i] = list.get(i);
		}
		List<Uroleperview> ilist = new ArrayList<Uroleperview>();
		int l;
		for (int m = 0; m < length; m += l) {
			l = 1;
			int h = 0;
			String s = urps[m].getPerviewName();
			for (int n = m + 1; n < length; n++) {
				if (urps[m].getRoleId() == urps[n].getRoleId()) {
					l++;
					h = 1;
					s = s + "~" + urps[n].getPerviewName();
				}
				if ((urps[m].getRoleId() != urps[n].getRoleId()) && h == 0) {
					l = 1;
				}
			}
			ilist.add(new Uroleperview(urps[m + l - 1].getUserId(), urps[m + l
					- 1].getRoleId(), urps[m + l - 1].getPerviewId(), urps[m
					+ l - 1].getPerId(), urps[m + l - 1].getRoleMark(), urps[m
					+ l - 1].getUserName(), urps[m + l - 1].getRoleName(), s));

		}
		// getRequest().setAttribute("rolelist", ilist);
		// 从界面中获取页码
		int currentPaged = 1;

		// 用户有没有点击改变页码
		if (getPagers() != null&&!getPagers().equals("")) {
			currentPaged = Integer.parseInt(getPagers());
		}
		// 1、创建分页类对象
		Pager pager = new Pager();
		// 2、需要分页的文本
		pager.setTopicSelect(ilist);
		// 3、设置每页显示行数
		pager.setSizePerPage(4);
		// 4、获取最大页数
		int maxPage = pager.getTotalPage();
		// 5、获取当前页
		/*pager.setCurrentPage(currentPaged);*/
		if(currentPaged<=maxPage){
			pager.setCurrentPage(currentPaged);
		}else{
			pager.setCurrentPage(maxPage);
		}
		getRequest().setAttribute("pager", pager);
		return "listrole";
	}

	// 根据角色编号查看角色详细信息
	public String queryroleById() throws Exception {
		List<Uroleperview> list = urpBiz.querryroleById(uro.getRoleId());
		Uroleperview urole = list.get(0);
		getRequest().setAttribute("urole", urole);
		getRequest().setAttribute("urolelist", list);
		return "updaterole";
	}

	// 修改角色
	public String updrolep() throws Exception {
		// Uroleperview uou=new Uroleperview(uro.getRoleId(), 0,
		// uro.getRoleMark(), uro.getRoleName(), null);
		// 修改角色信息
		boolean bo1 = urpBiz.updrole(new Uroleperview(uro.getRoleId(), 0, uro
				.getRoleMark(), uro.getRoleName(), null));
		int roleId = uro.getRoleId();
		// 根据角色id删除其具有的第一代权限
		boolean bo2 = urpBiz.delrolepre(roleId);
		String[] perviewname = uro.getPerviewName().split(", ");
		int length = perviewname.length;
		boolean bo3 = false;
		for (int i = 0; i < length; i++) {
			// 遍历checkbox选中的权限名
			String tt = perviewname[i];
			// 根据权限名查询权限id
			int perviewId = urpBiz.queryroleByName(perviewname[i]);
			// 根据角色id添加其所具有的第一代权限（perId=0）
			bo3 = urpBiz.addrolepre(roleId, perviewId);
		}
		if (bo1 && bo2 && bo3) {
			// 修改成功调用查询全部角色方法
			return queryAllroles();
		} else {
			// 修改失败调用查询单条角色方法
			return queryroleById();
		}
	}

	// 权限管理，查看全部权限
	public String queryAllper() throws Exception {
		List<Perview> list = urpBiz.QueryAllper();
		getRequest().setAttribute("perlist", list);
		return "listpur";
	}

	// 根据权限编号查询单条权限
	public String queryperById() throws Exception {
		Perview perr = urpBiz.QueryperById(perview.getPerviewId());
		getRequest().setAttribute("per", perr);
		return "updatepur";
	}

	// 修改权限
	public String updper() throws Exception {
		urpBiz.updperview(new Perview(perview.getPerviewId(), perview
				.getPerviewName()));
		// 调用查看全部权限
		return queryAllper();
	}
	
	//删除用户记录
	public String delUser()throws Exception{
		if(getDels()==null){
			return umanage();
		}else{
			delid=getDels().split(", ");
			for(int i=0;i<delid.length;i++){
				urpBiz.deluserById(Integer.parseInt(delid[i]));
				urpBiz.delUroleById(Integer.parseInt(delid[i]));
			}
			return umanage();
		}
		

	}
	//添加用户
	public String adduser()throws Exception{
		urpBiz.Adduser(new Users(us.getUserName(), us.getLoginName(), us.getLoginPwd()));
		int roleId=urpBiz.queryByname(uro.getRoleName());
		int uid=userBiz.queryByName(us.getLoginName());
		urpBiz.Addur(uid, roleId);
		return umanage();

	}
	//删除角色
	public String delrole()throws Exception{
		if(getDels()==null){
			return queryAllroles();
		}else{
			delid=getDels().split(", ");
			for(int i=0;i<delid.length;i++){
				urpBiz.delroleById(Integer.parseInt(delid[i]));
				urpBiz.delrolepre(Integer.parseInt(delid[i]));
			}
			return queryAllroles();
		}
	}
	//删除权限
	public String delpre()throws Exception{
		if(getDels()==null){
			return queryAllper();
		}else{
			delid=getDels().split(", ");
			for(int i=0;i<delid.length;i++){
				urpBiz.delpre(Integer.parseInt(delid[i]));
			}
			return queryAllper();
		}
	}
	//添加权限
	public String addpre()throws Exception{
		urpBiz.addpre(new Perview(perview.getPerviewName()));
		return queryAllper();
	}
}
